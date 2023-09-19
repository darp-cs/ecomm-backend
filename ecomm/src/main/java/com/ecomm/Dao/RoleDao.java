package com.ecomm.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.ecomm.Model.Role;
import com.ecomm.Repository.RoleRepository;

//Component annotation lets springboot know to keep track and that its a been that can be autowired
//Implements keyword makes a promise that a class will implement all methods in class its implementing
@Component
public class RoleDao implements Dao<Role> {

    @Autowired
    RoleRepository roleRepository;

    //Overriding is required here since Roledao promised to implement all methods in Dao
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

    /*
     * Method used to find role object by name
     * 
     * @param       Expected parameter is name of a role
     * @return      returns a role object
     */
    public Role getRoleByName(String name){
        return roleRepository.findFirstByName(name,Sort.by("name"));
    }
    
}
