/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.partidos.service;

/**
 *
 * @author José M Dager Montoya
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Partidos;
import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Usuarios;
import com.jmdm.TEST_CICLO3_UNAB.equipos.repository.EquiposRepository;
import com.jmdm.TEST_CICLO3_UNAB.partidos.dto.PartidosDTO;
import com.jmdm.TEST_CICLO3_UNAB.partidos.dto.PartidosUpdateDTO;
import com.jmdm.TEST_CICLO3_UNAB.partidos.repository.PartidosRepository;
import com.jmdm.TEST_CICLO3_UNAB.partidos.dto.PartidosUsuariosDTO;
import com.jmdm.TEST_CICLO3_UNAB.usuarios.repository.UsuariosRepository;

@Service
@Transactional
public class PartidosService {
    
    @Autowired
    private PartidosRepository partidosRepository;
    
    @Autowired
    private EquiposRepository equiposRepository;
    
    @Autowired
    private UsuariosRepository usuariosRepository;
    
    public List<Partidos> getPartidos(){
        return partidosRepository.findAll();
    }
    
    public Partidos getPartido(String id){
        return partidosRepository.findById(Long.parseLong(id)).get();
    }
    
    public PartidosUsuariosDTO getPartidosUsuarios(String nombreUsuario){
        PartidosUsuariosDTO listaUsuarios;
        Usuarios usuario = usuariosRepository.findByUsuario(nombreUsuario);
        listaUsuarios = new PartidosUsuariosDTO(usuario, partidosRepository.findByUsuariosId(usuario.getId()));
        return listaUsuarios;
    }
    
    public boolean setNuevoPartido(PartidosDTO nuevoPartido){
        Partidos  partido = new Partidos(nuevoPartido.getFecha(),Short.parseShort(nuevoPartido.getGoles_local()),Short.parseShort(nuevoPartido.getGoles_visitante()));
        partido.setUsuariosId(Short.parseShort(nuevoPartido.getUsuarios_id()));
        partido.setEquiposIdLocal(equiposRepository.findById(Long.parseLong(nuevoPartido.getEquipos_id_local())).get());
        partido.setEquiposIdVisitante(equiposRepository.findById(Long.parseLong(nuevoPartido.getEquipos_id_visitante())).get());
        partido = partidosRepository.save(partido);
        return partido.getId() != null;
    }
    
    public boolean setActualizarPartido(PartidosUpdateDTO actualizarPartido){
        Partidos partido = partidosRepository.findById(Long.parseLong(actualizarPartido.getPartidosID())).get();
        partido.setGolesLocal(Short.parseShort(actualizarPartido.getGolesLocal()));
        partido.setGolesVisitante(Short.parseShort(actualizarPartido.getGolesVisitantes()));
        partido = partidosRepository.save(partido);
        return partido.getId() != null;
    }    

}
