package com.ecomm.Service;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecomm.Dao.RefreshTokenDao;
import com.ecomm.Dao.UserDao;
import com.ecomm.Model.RefreshToken;

@Service
public class RefreshTokenService {

    //This comes from a property
    // @Value("${bezkoder.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    RefreshTokenDao refreshTokenDao;

    @Autowired
    UserDao userDao;


    public RefreshToken findByToken(String token) {
    return refreshTokenDao.findByToken(token);
  }

  public RefreshToken createRefreshToken(Integer userId) {
    RefreshToken refreshToken = new RefreshToken();
    refreshToken.setUser(userDao.get(userId));
    refreshToken.setExpirationDate(new Timestamp(System.currentTimeMillis()));
    refreshToken.setToken(UUID.randomUUID().toString());

    refreshToken = refreshTokenDao.createToken(refreshToken);
    return refreshToken;
  }

  public RefreshToken verifyExpiration(RefreshToken token) throws Exception {
    if (token.getExpirationDate().compareTo(new Timestamp(System.currentTimeMillis())) < 0) {
      refreshTokenDao.delete(token);
      //TODO: need to create default exception
      throw new Exception("Token not valid");
    }

    return token;
  }

  
  public void deleteByUserId(Integer userId) {
    refreshTokenDao.deleteByUser(userDao.get(userId));
  }
    
}
