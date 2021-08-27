/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.auth.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author José M Dager Montoya
 */
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotBlank
    private String usuario;
    
    @NotBlank
    private String contrasena;

    public LoginDTO(String usuario, String constrasena) {
        this.usuario = usuario;
        this.contrasena = constrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String constrasena) {
        this.contrasena = constrasena;
    }
}
