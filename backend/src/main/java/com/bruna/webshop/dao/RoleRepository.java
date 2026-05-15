package com.bruna.webshop.dao;

import com.bruna.webshop.modules.ERole;
import com.bruna.webshop.modules.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
