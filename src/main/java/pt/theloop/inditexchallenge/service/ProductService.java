package pt.theloop.inditexchallenge.service;

import org.springframework.stereotype.Service;
import pt.theloop.inditexchallenge.exception.ProductNotFoundException;
import pt.theloop.inditexchallenge.model.Product;
import pt.theloop.inditexchallenge.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

}
