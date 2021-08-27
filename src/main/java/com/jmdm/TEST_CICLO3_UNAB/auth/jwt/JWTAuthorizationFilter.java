/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.auth.jwt;

import com.jmdm.TEST_CICLO3_UNAB.auth.service.AuthUsuariosService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


/**
 *
 * @author José M Dager Montoya
 */
public class JWTAuthorizationFilter extends OncePerRequestFilter{
    
    private final static Logger logger =  LoggerFactory.getLogger(JWTEntryPoint.class);

    @Autowired
    private JWT jwtProvider;
    
    @Autowired
    private AuthUsuariosService authUsuariosService;
    
    
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain fc) throws ServletException, IOException {
        try{
            String token = getToken(req);
            if(token != null && jwtProvider.validateToken(token)){
                String nombreUsuario = jwtProvider.getUserFromToken(token);
                UserDetails usuario = authUsuariosService.loadUserByUsername(nombreUsuario);
                // AQUI AGREGAR ROLES EN CASO DE TENER ROLES.
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch(Exception ex){
            logger.error("Error al autorizar la petición...");
        }
        fc.doFilter(req, res);
    }
    
    private String getToken(HttpServletRequest req){
        String header = req.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer")){
            return header.replace("Bearer ", "");
        }
        return null;
    }
}
