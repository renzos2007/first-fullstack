package com.bruna.webshop.controller;

import com.bruna.webshop.dao.ProductDAO;
import com.bruna.webshop.modules.Product;
import com.bruna.webshop.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> GetAllProducts(){
        return this.productService.GetAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> GetProductById(@PathVariable long id){
        return productService.GetProductById(id);
    }

    @GetMapping("search/{name}")
    public Optional<List<Product>> GetProductByName(@PathVariable String name){
        return productService.GetProductByName(name);
    }
}
