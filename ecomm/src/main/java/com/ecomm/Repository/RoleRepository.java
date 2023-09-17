package com.ecomm.Repository;

import com.ecomm.Model.Role;

import java.util.ArrayList;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    //Most methods required will be part of JpaRepository already
    //Here i am creating one manually because i need an arraylist instead of the default of a list
    //The default for jpa repository will return a static list of type Role
    public ArrayList<Role> findAll();

    public Role findFirstByName(String name, Sort sort);
}
