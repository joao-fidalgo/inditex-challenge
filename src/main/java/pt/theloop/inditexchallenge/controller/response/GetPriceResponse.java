package pt.theloop.inditexchallenge.controller.response;

import lombok.Getter;
import pt.theloop.inditexchallenge.model.Price;

import java.text.NumberFormat;
import java.time.LocalDateTime;

public class GetPriceResponse {

    @Getter
    private final Long brandId;

    @Getter
    private final LocalDateTime endDate;

    @Getter
    private final String price;

    @Getter
    private final Long priceList;

    @Getter
    private final Long productId;

    @Getter
    private final LocalDateTime startDate;

    public GetPriceResponse(final Price price) {
        this.brandId = price.getBrand().getId();
        this.endDate = price.getEndDate();
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setCurrency(price.getCurrency());
        this.price = nf.format(price.getPrice());
        this.priceList = price.getPriceList();
        this.productId = price.getProduct().getId();
        this.startDate = price.getStartDate();
    }

}
