package pt.theloop.inditexchallenge.service;

import org.springframework.stereotype.Service;
import pt.theloop.inditexchallenge.exception.ProductNotFoundException;
import pt.theloop.inditexchallenge.model.Price;
import pt.theloop.inditexchallenge.repository.PriceRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService implements IPriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<Price> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public Price getPrice(Long brandId, Long productId, LocalDateTime date) {
        Price price = priceRepository.
                findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                        brandId,
                        productId,
                        date,
                        date);

        if (null == price) {
            throw new ProductNotFoundException();
        }

        return price;
    }

}
