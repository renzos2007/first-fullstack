package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Difficulty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NiveauDAO {
    private DifficultyRepository difficultyRepository;

    public NiveauDAO(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    public List<Difficulty> getAllNiveaus() {
        List<Difficulty> difficulties = difficultyRepository.findAll();
        return difficulties;
    }

    public Optional<Difficulty> getNiveauById(long id) {
        Optional<Difficulty> niveaus = difficultyRepository.findById(id);
        return niveaus;
    }
}
