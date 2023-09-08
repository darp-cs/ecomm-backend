package com.ecomm.Repository;

import com.ecomm.Model.Role;

import java.util.ArrayList;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    public ArrayList<Role> findAll();

    public Role findFirstByName(String name, Sort sort);
}
