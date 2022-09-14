package pt.theloop.inditexchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.theloop.inditexchallenge.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
