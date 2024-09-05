package com.verizon.controller;

import com.verizon.exception.ProductNotFoundException;
import com.verizon.model.Product;
import com.verizon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping("/price")
    public List<Product> getAllProductsBetweenPrice(@RequestParam double low, @RequestParam double high) {
        return productService.getAllProductsBetweenPrice(low, high);
    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody Product product) throws ProductNotFoundException {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) throws ProductNotFoundException {
        productService.deleteProduct(id);
    }
}
