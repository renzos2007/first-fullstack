package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Boek;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BoekDAO {
    private BoekRepository boekRepository;

    public BoekDAO(BoekRepository boekRepository) {
        this.boekRepository = boekRepository;
    }

    public List<Boek> getAllBoeken(){
        List<Boek> boekenLijst = boekRepository.findAll();
        return boekenLijst;
    }

    public Optional<Boek> getBoekById(long id){
        Optional<Boek> boekdetails = boekRepository.findById(id);
        return boekdetails;
    }

    public Optional<List<Boek>> getBookByName(String naam) {
        Optional<List<Boek>> books = boekRepository.findByNaam(naam);
        return books;
    }
}
