package com.bruna.webshop.dao;


import com.bruna.webshop.modules.Writer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WriterDAO {
    private final WriterRepository writerRepository;

    public WriterDAO(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public List<Writer> getAllWriters() {
        List<Writer> writerList = writerRepository.findAll();
        return writerList;
    }
}
