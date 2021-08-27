/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.auth.dto;

import java.io.Serializable;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author José M Dager Montoya
 */
public class JwtDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private long id;
    private String nombre;
    private String usuario;
    private String correo;
    private String token;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(long id, String nombre, String usuario, String correo, String token, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.token = "Bearer " + token;
        this.authorities = authorities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    } 
}
