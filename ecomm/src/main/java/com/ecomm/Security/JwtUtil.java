package com.ecomm.Security;

import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.Cookie ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.ecomm.Model.User;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    // @Value("${bezkoder.app.jwtSecret}")
    private String jwtSecret;

    // @Value("${bezkoder.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    // @Value("${bezkoder.app.jwtCookieName}")
    private String jwtCookie;
    
    // @Value("${bezkoder.app.jwtRefreshCookieName}")
    private String jwtRefreshCookie;


    private String secret_key = "mysecretkey";
    private long accessTokenValidity = 60*60*1000;


    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";

    @PostConstruct
    public void init(){
        secret_key = Base64.getEncoder().encodeToString(secret_key.getBytes());
    }

    public String createToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
		claims.put("auth", user.getRoles().toString());

		Date now = new Date();
		return Jwts.builder().setClaims(claims).setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + accessTokenValidity))
				.signWith(SignatureAlgorithm.HS512, secret_key).compact();
    }

    public ResponseCookie generateJwtCookie(User user) {
        String jwt = createToken(user);   
        return generateCookie(jwtCookie, jwt, "/");
    }

    public ResponseCookie generateRefreshJwtCookie(String refreshToken) {
        return generateCookie(jwtRefreshCookie, refreshToken, "/auth/refreshtoken");
    }

    public Claims getClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
	}

    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return getClaimsFromToken(token);
            }
            return null;
        } catch (ExpiredJwtException ex) {
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public String getEmail(Claims claims) {
        return claims.getSubject();
    }

    private List<String> getRoles(Claims claims) {
        return (List<String>) claims.get("roles");
    }

    private ResponseCookie generateCookie(String name, String value, String path) {
    ResponseCookie cookie = ResponseCookie.from(name, value).path(path).maxAge(24 * 60 * 60).httpOnly(true).build();
    return cookie;
  }

   private String getCookieValueByName(HttpServletRequest request, String name) {
    Cookie cookie = WebUtils.getCookie(request, name);
    if (cookie != null) {
      return cookie.getValue();
    } else {
      return null;
    }
  }


}