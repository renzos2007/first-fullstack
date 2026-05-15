package com.bruna.webshop.dao;


import com.bruna.webshop.modules.Schrijver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SchrijverDAO {
    private SchrijverRepository schrijverRepository;

    public SchrijverDAO(SchrijverRepository schrijverRepository) {
        this.schrijverRepository = schrijverRepository;
    }

    public List<Schrijver> getAllSchrijvers() {
        List<Schrijver> schrijvers = schrijverRepository.findAll();
        return schrijvers;
    }
}
