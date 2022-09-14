package pt.theloop.inditexchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pt.theloop.inditexchallenge.model.Price;

import java.time.LocalDateTime;

public interface PriceRepository extends JpaRepository<Price, Long> {
    @Query(value = "select * from Prices where" +
            " brand_id = :brandId and" +
            " product_id = :productId and" +
            " start_date <= :date and" +
            " end_date => :date" +
            " order by priority desc" +
            " limit 1", nativeQuery = true)
    Price get(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("date") LocalDateTime date);

    Price findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime startDate, LocalDateTime endDate);
}
