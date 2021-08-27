/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.usuarios.controller;

/**
 *
 * @author José M Dager Montoya
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.jmdm.TEST_CICLO3_UNAB.usuarios.service.UsuariosService;
import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Usuarios;
import com.jmdm.TEST_CICLO3_UNAB.dto.RespuestasDTO;
import com.jmdm.TEST_CICLO3_UNAB.usuarios.DTO.UsuariosDTO;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin
public class UsuariosController {
    
    @Autowired
    private UsuariosService usuariosService;    
            
    @GetMapping("/usuarios")
    public List<Usuarios> getUsuarios(){
        return usuariosService.getUsuarios();
    }
    
    @PostMapping("/nuevoUsuario")
    public ResponseEntity<?> adicionarUsuario(@Valid @RequestBody UsuariosDTO nuevoUsuario){
        if(usuariosService.adicionarUsuario(nuevoUsuario)){
            return new ResponseEntity(new RespuestasDTO("Usuario Creado"), HttpStatus.CREATED);
        }
        return new ResponseEntity(new RespuestasDTO("Usuario no Creado"), HttpStatus.BAD_REQUEST);
    }
    
}
