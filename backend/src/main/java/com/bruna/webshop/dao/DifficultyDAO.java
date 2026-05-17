package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Difficulty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DifficultyDAO {
    private final DifficultyRepository difficultyRepository;

    public DifficultyDAO(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    public List<Difficulty> getAllDifficulties() {
        List<Difficulty> difficultyList = difficultyRepository.findAll();
        return difficultyList;
    }

    public Optional<Difficulty> getDifficultyById(long id) {
        Optional<Difficulty> difficulty = difficultyRepository.findById(id);
        return difficulty;
    }
}
