package pt.theloop.inditexchallenge.controller.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public class GetPriceRequest {

    @Getter
    @NonNull
    private final Long brandId;

    @Getter
    @NonNull
    private final Long productId;

    @Getter
    private final LocalDateTime date;

    @JsonCreator
    public GetPriceRequest(final Long brandId, final Long productId, final LocalDateTime date) {
        this.brandId = brandId;
        this.productId = productId;
        this.date = (null == date) ? LocalDateTime.now() : date;
    }

}
