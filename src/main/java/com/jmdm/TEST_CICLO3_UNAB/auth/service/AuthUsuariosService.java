/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.auth.service;

/**
 *
 * @author José M Dager Montoya
 */

import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.AuthUsuarios;
import com.jmdm.TEST_CICLO3_UNAB.auth.dto.JwtDTO;
import com.jmdm.TEST_CICLO3_UNAB.auth.dto.LoginDTO;
import com.jmdm.TEST_CICLO3_UNAB.auth.jwt.JWT;
import com.jmdm.TEST_CICLO3_UNAB.usuarios.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
public class AuthUsuariosService implements UserDetailsService{
    
    @Autowired
    private UsuariosService usuariosService;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JWT jwtProvider;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        return AuthUsuarios.build(this.usuariosService.findByUsuario(usuario));
    }
    
    public JwtDTO validarUsuario(LoginDTO login){
         Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsuario(), login.getContrasena()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generarToken(authentication);
        AuthUsuarios usuario = (AuthUsuarios) authentication.getPrincipal();
        JwtDTO jwt = new JwtDTO(usuario.getId(), usuario.getNombre(), usuario.getUsuario(), usuario.getCorreo(),token, usuario.getAuthorities());
        return jwt;
    }
    
}