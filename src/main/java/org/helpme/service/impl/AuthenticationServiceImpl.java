package org.helpme.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;

import org.helpme.bean.auth.BLogin;
import org.helpme.exception.custom.AuthenticationException;
import org.helpme.exception.custom.AuthorizationException;
import org.helpme.model.User;
import org.helpme.service.abs.AuthenticationService;
import org.helpme.service.abs.UserService;
import org.helpme.util.security.SecurityCons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService;
    
    @Autowired
    private void setUserService(UserServiceImpl userService) {
    	this.userService = userService;
    }

    public User authenticate(BLogin bLogin) {
        Optional<User> user = Optional.of(userService.findByCode(bLogin.getUsercode()));

        if (user.isPresent() && BCrypt.checkpw(bLogin.getPassword(), user.get().getPassword())) {
            return user.get();
        } else {
        	throw new AuthenticationException("Incorrect username or password.");
        }
    }

    public String tokenFor(User user) {
        Date expiration = Date.from(LocalDateTime.now().plusHours(24).toInstant(ZoneOffset.UTC));
        
        return Jwts.builder()
                .setSubject(user.getCode())
                .setExpiration(expiration)
                .setIssuer(SecurityCons.ISSUER)
                .signWith(SignatureAlgorithm.HS512, SecurityCons.SECRET)
                .compact();
    }

    public User getUserFromToken(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(SecurityCons.SECRET).parseClaimsJws(token);
        Optional<User> user = Optional.of(userService.findByCode(claims.getBody().getSubject().toString()));

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new AuthorizationException("Not able to get an user from the given token.");
        }
    }

}
