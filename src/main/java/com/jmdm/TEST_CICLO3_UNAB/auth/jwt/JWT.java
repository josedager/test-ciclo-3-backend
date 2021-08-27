/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.auth.jwt;

import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.AuthUsuarios;
import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Usuarios;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author José M Dager Montoya
 */
@Component
public class JWT {
    private final static Logger logger =  LoggerFactory.getLogger(JWTEntryPoint.class);
    
    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generarToken(Authentication authentication){
        AuthUsuarios usuario = (AuthUsuarios) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuario.getUsuario())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000) )
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    public String getUserFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch(Exception ex){
            logger.error("Token inválido");
        }
        return false;
    }
}