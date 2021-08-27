/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.partidos.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author José M Dager Montoya
 */
public class PartidosDTO {
    @NotBlank
    private String usuarios_id;
    
    @NotBlank
    private String equipos_id_local;
    
    @NotBlank
    private String equipos_id_visitante;
    
    @NotBlank
    private String fecha;
    
    @NotBlank
    private String goles_local;
    
    @NotBlank
    private String goles_visitante;

    public PartidosDTO(String usuarios_id, String equipos_id_local, String equipos_id_visitante, String fecha, String goles_local, String goles_visitante) {
        this.usuarios_id = usuarios_id;
        this.equipos_id_local = equipos_id_local;
        this.equipos_id_visitante = equipos_id_visitante;
        this.fecha = fecha;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
    }

    public String getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(String usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public String getEquipos_id_local() {
        return equipos_id_local;
    }

    public void setEquipos_id_local(String equipos_id_local) {
        this.equipos_id_local = equipos_id_local;
    }

    public String getEquipos_id_visitante() {
        return equipos_id_visitante;
    }

    public void setEquipos_id_visitante(String equipos_id_visitante) {
        this.equipos_id_visitante = equipos_id_visitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(String goles_local) {
        this.goles_local = goles_local;
    }

    public String getGoles_visitante() {
        return goles_visitante;
    }

    public void setGoles_visitante(String goles_visitante) {
        this.goles_visitante = goles_visitante;
    }
    
}
