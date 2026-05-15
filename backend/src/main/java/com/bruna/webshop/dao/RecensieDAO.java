package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Recensie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecensieDAO {
    private RecensieRepository recensieRepository;

    public RecensieDAO(RecensieRepository recensieRepository) {
        this.recensieRepository = recensieRepository;
    }

    public List<Recensie> getRecensies() {
        List<Recensie> recenties = recensieRepository.findAll();
        return recenties;
    }
}
