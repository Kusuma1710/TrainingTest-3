package com.verizon.service;
import com.verizon.dao.ProductDao;
import com.verizon.exception.ProductNotFoundException;
import com.verizon.model.Product;
import com.verizon.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private final ProductDao productDao;

    public ProductService(ProductRepository productRepository, ProductDao productDao) {
        this.productRepository = productRepository;
        this.productDao = productDao;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    public List<Product> getAllProductsBetweenPrice(double low, double high) {
        return productDao.getProductsByPriceRange(low, high);
    }

    public void updateProduct(Integer id, Product updatedProduct) throws ProductNotFoundException {
        Product existingProduct = getProductById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        productRepository.save(existingProduct);
    }

    public void deleteProduct(Integer id) throws ProductNotFoundException {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
