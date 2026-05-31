package com.bruna.webshop.services;

import com.bruna.webshop.dao.ProductDAO;
import com.bruna.webshop.modules.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductDAO productDao;

    public ProductService(ProductDAO productDao) {
        this.productDao = productDao;
    }

    public List<Product> GetAllProducts(){
        return this.productDao.getAllProducts();
    }

    public Optional<Product> GetProductById(Long id){
        return productDao.getProductById(id);
    }

    public Optional<List<Product>> GetProductByName(String name){
        return productDao.getProductByName(name);
    }
}
