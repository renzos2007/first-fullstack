package com.bruna.webshop.dao;

import com.bruna.webshop.modules.ERole;
import com.bruna.webshop.modules.Role;
import com.bruna.webshop.repositories.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class RoleDAO {
    private final RoleRepository roleRepository;

    public RoleDAO(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(ERole name) {
        return roleRepository.findByName(name).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    }
}
