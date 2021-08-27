/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.equipos.service;

/**
 *
 * @author José M Dager Montoya
 */
import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Equipos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jmdm.TEST_CICLO3_UNAB.equipos.repository.EquiposRepository;

@Service
@Transactional
public class EquiposService {
    
    @Autowired
    private EquiposRepository equiposRepository;
    
    public List<Equipos> getEquipos(){
        return equiposRepository.findAll();
    }
}
