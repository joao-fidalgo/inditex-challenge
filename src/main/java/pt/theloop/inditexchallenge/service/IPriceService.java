package pt.theloop.inditexchallenge.service;

import pt.theloop.inditexchallenge.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceService {

    List<Price> findAll();
    Price getPrice(Long brandId, Long productId, LocalDateTime date);

}
