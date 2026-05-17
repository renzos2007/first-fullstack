package com.bruna.webshop.controller;

import com.bruna.webshop.dao.DifficultyDAO;
import com.bruna.webshop.modules.Difficulty;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/difficulty")
public class DifficultyController {
    private DifficultyDAO difficultyDAO;

    public DifficultyController(DifficultyDAO difficultyDAO) {
        this.difficultyDAO = difficultyDAO;
    }

    @GetMapping
    public List<Difficulty> getAlldifficulties() {
        return difficultyDAO.getAllDifficulties();
    }

    @GetMapping("/{id}")
    public Optional<Difficulty> getdifficultyById(@PathVariable long id) {
        return difficultyDAO.getDifficultyById(id);
    }
}
