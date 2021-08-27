/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jmdm.TEST_CICLO3_UNAB.DB.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author José M Dager Montoya
 */
@Entity
@Table(name = "partidos")
@NamedQueries({
    @NamedQuery(name = "Partidos.findAll", query = "SELECT p FROM Partidos p"),
    @NamedQuery(name = "Partidos.findById", query = "SELECT p FROM Partidos p WHERE p.id = :id"),
    @NamedQuery(name = "Partidos.findByFecha", query = "SELECT p FROM Partidos p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Partidos.findByGolesLocal", query = "SELECT p FROM Partidos p WHERE p.golesLocal = :golesLocal"),
    @NamedQuery(name = "Partidos.findByGolesVisitante", query = "SELECT p FROM Partidos p WHERE p.golesVisitante = :golesVisitante"),
    @NamedQuery(name = "Partidos.findByUsuariosId", query = "SELECT p FROM Partidos p WHERE p.usuariosId = :usuariosId")})
public class Partidos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    
    @Basic(optional = false)
    @Column(name = "goles_local")
    private short golesLocal;
   
    @Basic(optional = false)
    @Column(name = "goles_visitante")
    private short golesVisitante;
    
    @JoinColumn(name = "equipos_id_local", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipos equiposIdLocal;
    
    @JoinColumn(name = "equipos_id_visitante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Equipos equiposIdVisitante;
    
    /*@JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuariosId;*/
    
    @Basic(optional = false)
    @Column(name = "usuarios_id")
    private long usuariosId;

    public Partidos() {
    }

    public Partidos(Long id) {
        this.id = id;
    }

    public Partidos(String fecha, short golesLocal, short golesVisitante) {
        this.id = id;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public short getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(short golesLocal) {
        this.golesLocal = golesLocal;
    }

    public short getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(short golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Equipos getEquiposIdLocal() {
        return equiposIdLocal;
    }

    public void setEquiposIdLocal(Equipos equiposIdLocal) {
        this.equiposIdLocal = equiposIdLocal;
    }

    public Equipos getEquiposIdVisitante() {
        return equiposIdVisitante;
    }

    public void setEquiposIdVisitante(Equipos equiposIdVisitante) {
        this.equiposIdVisitante = equiposIdVisitante;
    }

    public long getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(long usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partidos)) {
            return false;
        }
        Partidos other = (Partidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jmdm.TEST_UNAB_3.DB.Entities.Partidos[ id=" + id + " ]";
    }
    
}
