package com.bruna.webshop.controller;

import com.bruna.webshop.dao.NiveauDAO;
import com.bruna.webshop.modules.Niveau;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/niveau")
public class NiveauController {
    private NiveauDAO niveauDAO;

    public NiveauController(NiveauDAO niveauDAO) {
        this.niveauDAO = niveauDAO;
    }

    @GetMapping
    public List<Niveau> getAllNiveau() {
        return niveauDAO.getAllNiveaus();
    }

    @GetMapping("/{id}")
    public Optional<Niveau> getNiveauById(@PathVariable long id) {
        return niveauDAO.getNiveauById(id);
    }
}
