package pt.theloop.inditexchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.theloop.inditexchallenge.model.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
