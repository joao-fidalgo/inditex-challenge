package pt.theloop.inditexchallenge.model;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Objects;

@Entity
@Table(name = "prices")
public class Price {

    @Getter
    @JoinColumn(name = "brand_id", nullable = false)
    @ManyToOne(targetEntity = Brand.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @NonNull
    private Brand brand;

    @Column(name = "curr")
    @Getter
    private Currency currency;

    @Column(name = "end_date")
    @Getter
    private LocalDateTime endDate;

    @Column(name = "price")
    @Getter
    private BigDecimal price;

    @Column(name = "price_list")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long priceList;

    @Column(name = "priority")
    @Getter
    private Integer priority;

    @Getter
    @JoinColumn(name = "product_id", nullable = false)
    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @NonNull
    private Product product;

    @Column(name = "start_date")
    @Getter
    private LocalDateTime startDate;

    public Price() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(brand, price1.brand)
                && Objects.equals(currency, price1.currency)
                && Objects.equals(endDate, price1.endDate)
                && Objects.equals(price, price1.price)
                && Objects.equals(priceList, price1.priceList)
                && Objects.equals(priority, price1.priority)
                && Objects.equals(product, price1.product)
                && Objects.equals(startDate, price1.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, currency, endDate, price, priceList, priority, product, startDate);
    }

    @Override
    public String toString() {
        return "Price{" +
                "brand=" + brand +
                ", currency=" + currency +
                ", endDate=" + endDate +
                ", price=" + price +
                ", priceList=" + priceList +
                ", priority=" + priority +
                ", product=" + product +
                ", startDate=" + startDate +
                '}';
    }

}
