package pt.theloop.inditexchallenge.service;

import org.springframework.stereotype.Service;
import pt.theloop.inditexchallenge.exception.BrandNotFoundException;
import pt.theloop.inditexchallenge.model.Brand;
import pt.theloop.inditexchallenge.repository.BrandRepository;

@Service
public class BrandService implements IBrandService {

    private final BrandRepository brandRepository;

    public BrandService(final BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand getBrand(Long id) {
        return brandRepository
                .findById(id)
                .orElseThrow(BrandNotFoundException::new);
    }

}
