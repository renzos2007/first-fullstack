package com.bruna.webshop.dao;


import com.bruna.webshop.modules.Publisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublisherDAO {
    private final PublisherRepository publisherRepository;

    public PublisherDAO(PublisherRepository publisherRepository) {this.publisherRepository = publisherRepository;}

    public List<Publisher> getAllPublishers() {
        List<Publisher> PublisherList = publisherRepository.findAll();
        return PublisherList;
    }

}
