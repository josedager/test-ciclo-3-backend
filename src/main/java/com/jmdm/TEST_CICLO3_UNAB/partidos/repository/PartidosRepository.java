/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.partidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Partidos;
import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Usuarios;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author José M Dager Montoya
 */
@Repository
public interface PartidosRepository extends JpaRepository<Partidos, Long> {

    public List<Partidos> findByUsuariosId(long usuariosId);
    
}
