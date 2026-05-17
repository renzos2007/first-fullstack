package com.bruna.webshop.controller;

import com.bruna.webshop.dao.ProductDAO;
import com.bruna.webshop.modules.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class BoekController {
    private ProductDAO productDao;

    public BoekController(ProductDAO productDao) {
        this.productDao = productDao;
    }

    @GetMapping
    public List<Product> GetAllBoek(){
        return this.productDao.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> GetBoekById(@PathVariable long id){
        return productDao.getProductById(id);
    }

    @GetMapping("search/{naam}")
    public Optional<List<Product>> GetBookByName(@PathVariable String naam){return productDao.getProductByName(naam);}
}
