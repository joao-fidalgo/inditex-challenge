package pt.theloop.inditexchallenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.theloop.inditexchallenge.controller.request.GetPriceRequest;
import pt.theloop.inditexchallenge.controller.response.GetPriceResponse;
import pt.theloop.inditexchallenge.model.Price;
import pt.theloop.inditexchallenge.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    GetPriceResponse getPrice(@RequestBody final GetPriceRequest getPriceRequest) {
        final Price price = priceService.getPrice(getPriceRequest.getBrandId(), getPriceRequest.getProductId(), getPriceRequest.getDate());
        return new GetPriceResponse(price);
    }

}
