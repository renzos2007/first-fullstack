package com.bruna.webshop.dao;

import com.bruna.webshop.modules.Boek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoekRepository extends JpaRepository<Boek, Long> {
    Optional<List<Boek>> findByNaam(String naam);
}
