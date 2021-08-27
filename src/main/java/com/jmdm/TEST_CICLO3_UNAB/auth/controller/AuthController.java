/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.auth.controller;

/**
 *
 * @author José M Dager Montoya
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jmdm.TEST_CICLO3_UNAB.auth.dto.JwtDTO;
import com.jmdm.TEST_CICLO3_UNAB.auth.dto.LoginDTO;
import com.jmdm.TEST_CICLO3_UNAB.auth.service.AuthUsuariosService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    
    @Autowired
    private AuthUsuariosService authUsuariosService;
    
    @PostMapping("/login")
    public JwtDTO login(@Valid @RequestBody LoginDTO login){
        return authUsuariosService.validarUsuario(login);
    }
}
