/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jmdm.TEST_CICLO3_UNAB.DB.Entities.Usuarios;
import org.springframework.stereotype.Repository;

/**
 *
 * @author José M Dager Montoya
 */
@Repository
public interface UsuariosRepository  extends JpaRepository<Usuarios, Long> {

    public Usuarios findByCorreo(String correo);
    
    public Usuarios findByUsuario(String usuario);
    
}
