package com.bruna.webshop.controller;

import com.bruna.webshop.dao.DifficultyDAO;
import com.bruna.webshop.modules.Difficulty;
import com.bruna.webshop.services.DifficultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/difficulty")
public class DifficultyController {
    private DifficultyService difficultyService;

    public DifficultyController(DifficultyService difficultyService) {
        this.difficultyService = difficultyService;
    }

    @GetMapping
    public List<Difficulty> getAlldifficulties() {
        return difficultyService.getAlldifficulties();
    }

    @GetMapping("/{id}")
    public Optional<Difficulty> getdifficultyById(@PathVariable long id) {
        return difficultyService.getdifficultyById(id);
    }
}
