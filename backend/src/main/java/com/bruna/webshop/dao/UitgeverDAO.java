package com.bruna.webshop.dao;


import com.bruna.webshop.modules.Uitgever;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UitgeverDAO {
    private UitgeverRepository uitgeverRepository;

    public UitgeverDAO(UitgeverRepository uitgeverRepository) {this.uitgeverRepository = uitgeverRepository;}

    public List<Uitgever> getAllUitgevers() {
        List<Uitgever> uitgevers = uitgeverRepository.findAll();
        return uitgevers;
    }

}
