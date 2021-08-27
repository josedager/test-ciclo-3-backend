/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.usuarios.DTO;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author José M Dager Montoya
 */
public class UsuariosDTO {
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String correo;
    
    @NotBlank
    private String usuario;
    
    @NotBlank
    private String contrasena;

    public UsuariosDTO(String nombre, String correo, String usuario, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
