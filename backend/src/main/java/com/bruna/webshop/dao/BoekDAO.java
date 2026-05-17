package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BoekDAO {
    private ProductRepository productRepository;

    public BoekDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllBoeken(){
        List<Product> boekenLijst = productRepository.findAll();
        return boekenLijst;
    }

    public Optional<Product> getBoekById(long id){
        Optional<Product> boekdetails = productRepository.findById(id);
        return boekdetails;
    }

    public Optional<List<Product>> getBookByName(String naam) {
        Optional<List<Product>> books = productRepository.findByNaam(naam);
        return books;
    }
}
