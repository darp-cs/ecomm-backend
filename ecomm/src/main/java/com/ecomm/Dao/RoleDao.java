package com.ecomm.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ecomm.Model.Role;
import com.ecomm.Repository.RoleRepository;


@Component
public class RoleDao implements Dao<Role> {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role get(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public ArrayList<Role> getAll() {

        return roleRepository.findAll();
    }

    @Override
    public void save(Role t) {
        roleRepository.save(t);
    }

    @Override
    public void delete(Role t) {
        roleRepository.delete(t);
    }

    public Role getRoleByName(String name){
        return roleRepository.findFirstByName(name,Sort.by("name"));
    }
    
}
