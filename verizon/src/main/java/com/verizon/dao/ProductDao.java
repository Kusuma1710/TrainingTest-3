package com.verizon.dao;

import com.verizon.model.Product;
import com.verizon.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    private final ProductRepository productRepository;

    public ProductDao(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByPriceRange(double low, double high) {
        return productRepository.findByPriceBetween(low, high);
    }
}
