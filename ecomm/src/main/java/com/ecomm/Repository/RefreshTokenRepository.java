package com.ecomm.Repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.Model.RefreshToken;
import com.ecomm.Model.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Integer> {
    
  Optional<RefreshToken> findByToken(String token);

  void deleteByUser(User  user);

  public ArrayList<RefreshToken> findAll();
  
}
