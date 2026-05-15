package com.bruna.webshop.controller;

import com.bruna.webshop.dao.BoekDAO;
import com.bruna.webshop.modules.Boek;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class BoekController {
    private BoekDAO boekDao;

    public BoekController(BoekDAO boekDao) {
        this.boekDao = boekDao;
    }

    @GetMapping
    public List<Boek> GetAllBoek(){
        return this.boekDao.getAllBoeken();
    }

    @GetMapping("/{id}")
    public Optional<Boek> GetBoekById(@PathVariable long id){
        return boekDao.getBoekById(id);
    }

    @GetMapping("search/{naam}")
    public Optional<List<Boek>> GetBookByName(@PathVariable String naam){return boekDao.getBookByName(naam);}
}
