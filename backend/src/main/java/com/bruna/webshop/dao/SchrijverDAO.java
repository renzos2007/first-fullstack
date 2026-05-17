package com.bruna.webshop.dao;


import com.bruna.webshop.modules.Writer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchrijverDAO {
    private WriterRepository writerRepository;

    public SchrijverDAO(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public List<Writer> getAllSchrijvers() {
        List<Writer> writers = writerRepository.findAll();
        return writers;
    }
}
