/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.partidos.controller;

/**
 *
 * @author José M Dager Montoya
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Partidos;
import com.jmdm.TEST_CICLO3_UNAB.dto.RespuestasDTO;
import com.jmdm.TEST_CICLO3_UNAB.partidos.dto.PartidosDTO;
import com.jmdm.TEST_CICLO3_UNAB.partidos.dto.PartidosUpdateDTO;
import java.util.List;
import com.jmdm.TEST_CICLO3_UNAB.partidos.service.PartidosService;
import com.jmdm.TEST_CICLO3_UNAB.partidos.dto.PartidosUsuariosDTO;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/partidos")
@CrossOrigin
public class PartidosController {
    
    @Autowired
    private PartidosService partidosService;
    
    @GetMapping("/partidos")
    public List<Partidos> getPartidos(){
        return partidosService.getPartidos();
    }
    
    @GetMapping("/partido/{id}")
    public Partidos getPartido(@PathVariable String id){
        return partidosService.getPartido(id);
    }
    
    @GetMapping("/partidosUsuarios")
    public PartidosUsuariosDTO getPartidosUsuarios(Authentication authentication){
        String usuario = authentication.getName();
        return partidosService.getPartidosUsuarios(usuario);
    }
    
    @PostMapping("/nuevoPartido")
    public  ResponseEntity<?> setNuevoPartido(@Valid @RequestBody PartidosDTO nuevoPartido){
        if(partidosService.setNuevoPartido(nuevoPartido)){
            return new ResponseEntity(new RespuestasDTO("Partido Creado"), HttpStatus.CREATED);
        }
        return new ResponseEntity(new RespuestasDTO("Partido no Creado"), HttpStatus.BAD_REQUEST);
    }
    @PutMapping("/actualizarPartido")
    public  ResponseEntity<?> setActualizarPartido(@Valid @RequestBody PartidosUpdateDTO actualizarPartido){
        System.out.println(actualizarPartido);
        if(partidosService.setActualizarPartido(actualizarPartido)){
            return new ResponseEntity(new RespuestasDTO("Partido Actualizado"), HttpStatus.CREATED);
        }
        return new ResponseEntity(new RespuestasDTO("Partido no Actualizado"), HttpStatus.BAD_REQUEST);
    }
    
}
