package com.bruna.webshop.controller;

import com.bruna.webshop.dao.DifficultyDAO;
import com.bruna.webshop.modules.Difficulty;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/niveau")
public class NiveauController {
    private DifficultyDAO difficultyDAO;

    public NiveauController(DifficultyDAO difficultyDAO) {
        this.difficultyDAO = difficultyDAO;
    }

    @GetMapping
    public List<Difficulty> getAllNiveau() {
        return difficultyDAO.getAllDifficulties();
    }

    @GetMapping("/{id}")
    public Optional<Difficulty> getNiveauById(@PathVariable long id) {
        return difficultyDAO.getDifficultyById(id);
    }
}
