package com.bruna.webshop.services;

import com.bruna.webshop.dao.DifficultyDAO;
import com.bruna.webshop.modules.Difficulty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DifficultyService {
    private DifficultyDAO difficultyDAO;

    public DifficultyService(DifficultyDAO difficultyDAO) {
        this.difficultyDAO = difficultyDAO;
    }

    public List<Difficulty> getAlldifficulties() {
        return difficultyDAO.getAllDifficulties();
    }

    public Optional<Difficulty> getdifficultyById(Long id) {
        return difficultyDAO.getDifficultyById(id);
    }
}
