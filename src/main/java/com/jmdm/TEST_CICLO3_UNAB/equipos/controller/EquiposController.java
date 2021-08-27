/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.equipos.controller;

/**
 *
 * @author José M Dager Montoya
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Equipos;
import java.util.List;
import com.jmdm.TEST_CICLO3_UNAB.equipos.service.EquiposService;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/api/equipos")
@CrossOrigin
public class EquiposController {
    
    @Autowired
    private EquiposService equiposService;
    
    @GetMapping("/equipos")
    public List<Equipos> getEquipos(){
        return equiposService.getEquipos();
    }
}
