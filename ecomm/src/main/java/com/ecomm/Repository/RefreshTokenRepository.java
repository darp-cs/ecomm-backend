package com.ecomm.Repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ecomm.Model.RefreshToken;
import com.ecomm.Model.User;

import jakarta.transaction.Transactional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

    Optional<RefreshToken> findByToken(String token);

    void deleteByUser(User user);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM refreshtoken WHERE user_id =?1", nativeQuery = true)
    void deleteByUserId(Integer id);

    public ArrayList<RefreshToken> findAll();

}
