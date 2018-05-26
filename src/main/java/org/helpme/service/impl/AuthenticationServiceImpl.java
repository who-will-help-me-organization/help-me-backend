package org.helpme.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.helpme.model.User;
import org.helpme.service.abs.UserService;
import org.helpme.util.security.SecurityCons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthenticationServiceImpl {
    private static final String ISSUER = "random";
    
    private UserService userService;
    
    @Autowired
    private void setUserService(UserServiceImpl userService) {
    	this.userService = userService;
    }

    public User authenticate(LoginBean loginBean) {
        User user = userService.findByIdentifier(loginBean.getIdentifier());

        if (user != null && user.authenticate(loginBean.getPassword())) {
            return user;
        }

        throw new RuntimeException();
    }

    public String tokenFor(User user) throws IOException, URISyntaxException {

        Date expiration = Date.from(LocalDateTime.now().plusHours(24 * 7).toInstant(ZoneOffset.UTC));
        return Jwts.builder()
                .setSubject(user.getUsercode())
                .setExpiration(expiration)
                .setIssuer(ISSUER)
                .signWith(SignatureAlgorithm.HS512, SecurityCons.SECRET)
                .compact();
    }

    public User getUserFromToken(String token) throws IOException, URISyntaxException {
        Jws<Claims> claims = Jwts.parser().setSigningKey(SecurityCons.SECRET).parseClaimsJws(token);
        User user = userService.findByUsercode(claims.getBody().getSubject().toString());

        if (user != null)
            return user;
        else
            throw new RuntimeException();
    }

}
