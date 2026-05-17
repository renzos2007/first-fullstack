package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDAO {
    private final ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Optional<Product> getProductById(long id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    public Optional<List<Product>> getProductByName(String name) {
        Optional<List<Product>> productList = productRepository.findByName(name);
        return productList;
    }
}
