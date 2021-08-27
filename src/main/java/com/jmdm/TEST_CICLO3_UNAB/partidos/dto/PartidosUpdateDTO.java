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
public class PartidosUpdateDTO {
    @NotBlank
    private String partidosID;
    
    @NotBlank
    private String golesLocal;
    
    @NotBlank
    private String golesVisitante;

    public PartidosUpdateDTO(String partidosID, String golesLocal, String golesVisitante) {
        this.partidosID = partidosID;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public String getPartidosID() {
        return partidosID;
    }

    public void setPartidosID(String partidosID) {
        this.partidosID = partidosID;
    }

    public String getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(String golesLocal) {
        this.golesLocal = golesLocal;
    }

    public String getGolesVisitantes() {
        return golesVisitante;
    }

    public void setGolesVisitantes(String golesVisitante) {
        this.golesVisitante = golesVisitante;
    }
    
}
