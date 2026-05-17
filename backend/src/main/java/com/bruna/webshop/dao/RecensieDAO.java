package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecensieDAO {
    private RecensieRepository recensieRepository;

    public RecensieDAO(RecensieRepository recensieRepository) {
        this.recensieRepository = recensieRepository;
    }

    public List<Review> getRecensies() {
        List<Review> recenties = recensieRepository.findAll();
        return recenties;
    }
}
