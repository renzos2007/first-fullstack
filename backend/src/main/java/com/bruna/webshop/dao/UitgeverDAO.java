package com.bruna.webshop.dao;


import com.bruna.webshop.modules.Publisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UitgeverDAO {
    private PublisherRepository publisherRepository;

    public UitgeverDAO(PublisherRepository publisherRepository) {this.publisherRepository = publisherRepository;}

    public List<Publisher> getAllUitgevers() {
        List<Publisher> Publishers = publisherRepository.findAll();
        return Publishers;
    }

}
