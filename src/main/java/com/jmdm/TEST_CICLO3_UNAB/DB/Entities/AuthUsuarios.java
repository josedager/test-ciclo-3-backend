/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.DB.Entities;

import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author José M Dager Montoya
 */

public class AuthUsuarios implements UserDetails {
    
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
  
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    
    private Collection<? extends GrantedAuthority> authorities;
    
    public AuthUsuarios(long id, String nombre, String correo, String usuario, String contrasena, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.authorities = authorities;
    }
    
    public static AuthUsuarios build(Usuarios usuario){
        List<GrantedAuthority> authorities = usuario.getRoles();
        return new AuthUsuarios(usuario.getId(),usuario.getNombre(), usuario.getCorreo(), usuario.getUsuario(), usuario.getContrasena(), authorities);
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
   
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.contrasena;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
