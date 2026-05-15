package com.bruna.webshop.dao;

import com.bruna.webshop.dao.NiveauRepository;
import com.bruna.webshop.modules.Niveau;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NiveauDAO {
    private NiveauRepository niveauRepository;

    public NiveauDAO(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    public List<Niveau> getAllNiveaus() {
        List<Niveau> niveaus = niveauRepository.findAll();
        return niveaus;
    }

    public Optional<Niveau> getNiveauById(long id) {
        Optional<Niveau> niveaus = niveauRepository.findById(id);
        return niveaus;
    }
}
