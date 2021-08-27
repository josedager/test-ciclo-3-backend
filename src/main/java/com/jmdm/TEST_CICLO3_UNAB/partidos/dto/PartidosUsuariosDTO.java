/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.partidos.dto;

import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author José M Dager Montoya
 */
public class PartidosUsuariosDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private String usuario;
    private String correo;
    private List<Partidos> listaPartidos;

    public PartidosUsuariosDTO(Usuarios usuario, List<Partidos> listaPartidos) {
        this.nombre = usuario.getNombre();
        this.usuario = usuario.getUsuario();
        this.correo = usuario.getCorreo();
        this.listaPartidos = listaPartidos;
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

    public List<Partidos> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(List<Partidos> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
    
}
