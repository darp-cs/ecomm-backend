package com.ecomm.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecomm.Model.RefreshToken;
import com.ecomm.Model.User;
import com.ecomm.Repository.RefreshTokenRepository;
import com.ecomm.Repository.UserRepository;

@Component
public class RefreshTokenDao implements Dao<RefreshToken>{
    
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserRepository userRepository;

    public RefreshToken findByToken(String token){
        return refreshTokenRepository.findByToken(token).get();
    }


    @Override
    public RefreshToken get(int id) {
        return refreshTokenRepository.findById(id).orElse(null);
    }

    @Override
    public ArrayList<RefreshToken> getAll() {
        return refreshTokenRepository.findAll();
    }

    @Override
    public void save(RefreshToken t) {
       refreshTokenRepository.save(t);
    }

    @Override
    public void delete(RefreshToken t) {
        refreshTokenRepository.delete(t);
    }

    public RefreshToken createToken(RefreshToken t){
        return refreshTokenRepository.save(t);
    }

    public void deleteByUser(User user){
        refreshTokenRepository.deleteByUser(user);
    }
}
