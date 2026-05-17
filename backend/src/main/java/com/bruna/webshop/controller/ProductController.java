package com.bruna.webshop.controller;

import com.bruna.webshop.dao.ProductDAO;
import com.bruna.webshop.modules.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductDAO productDao;

    public ProductController(ProductDAO productDao) {
        this.productDao = productDao;
    }

    @GetMapping
    public List<Product> GetAllProducts(){
        return this.productDao.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> GetProductById(@PathVariable long id){
        return productDao.getProductById(id);
    }

    @GetMapping("search/{naam}")
    public Optional<List<Product>> GetProductByName(@PathVariable String naam){return productDao.getProductByName(naam);}
}
