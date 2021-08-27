/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author José M Dager Montoya
 */
public class RespuestasDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @NotBlank
    private String mensaje;

    public RespuestasDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
