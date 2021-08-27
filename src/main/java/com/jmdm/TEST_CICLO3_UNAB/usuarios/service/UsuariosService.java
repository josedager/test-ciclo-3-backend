/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.usuarios.service;

/**
 *
 * @author José M Dager Montoya
 */

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Usuarios;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jmdm.TEST_CICLO3_UNAB.usuarios.repository.UsuariosRepository;
import com.jmdm.TEST_CICLO3_UNAB.usuarios.DTO.UsuariosDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@Transactional
public class UsuariosService {
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public List<Usuarios> getUsuarios(){
        return usuariosRepository.findAll();
    }
    
    public boolean adicionarUsuario(UsuariosDTO nuevoUsuario){
        Usuarios usuario = new Usuarios(nuevoUsuario.getNombre(), nuevoUsuario.getCorreo(), 
                                        nuevoUsuario.getUsuario(), passwordEncoder.encode(nuevoUsuario.getContrasena()));
        usuario = usuariosRepository.save(usuario);
        return usuario.getId() != null;
    }
    
    public Usuarios findByUsuario(String usuario){
        return usuariosRepository.findByUsuario(usuario);
    }
    
}