package com.springrest.service;

import com.springrest.entities.Role;
import com.springrest.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByRoleName(String name) {
        return roleRepository.findRoleByName(name);
    }

    public Set<Role> setRoles() {
        Set<Role> roles = new HashSet<>();

        return roles;
    }
}
