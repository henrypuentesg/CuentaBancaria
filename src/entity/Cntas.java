/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry
 */
@Entity
@Table(name = "CNTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cntas.findAll", query = "SELECT c FROM Cntas c"),
    @NamedQuery(name = "Cntas.findByIdCnta", query = "SELECT c FROM Cntas c WHERE c.idCnta = :idCnta"),
    @NamedQuery(name = "Cntas.findByFchaCrcion", query = "SELECT c FROM Cntas c WHERE c.fchaCrcion = :fchaCrcion"),
    @NamedQuery(name = "Cntas.findByIdBnco", query = "SELECT c FROM Cntas c WHERE c.idBnco = :idBnco"),
    @NamedQuery(name = "Cntas.findByNmroIdntfcion", query = "SELECT c FROM Cntas c WHERE c.nmroIdntfcion = :nmroIdntfcion"),
    @NamedQuery(name = "Cntas.findByIdMnda", query = "SELECT c FROM Cntas c WHERE c.idMnda = :idMnda"),
    @NamedQuery(name = "Cntas.findBySldo", query = "SELECT c FROM Cntas c WHERE c.sldo = :sldo")})
public class Cntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CNTA")
    private int idCnta;
    @Column(name = "FCHA_CRCION")
    @Temporal(TemporalType.DATE)
    private Date fchaCrcion;
    @Column(name = "ID_BNCO")
    private String idBnco;
    @Column(name = "NMRO_IDNTFCION")
    private String nmroIdntfcion;
    @Column(name = "ID_MNDA")
    private String idMnda;
    @Column(name = "SLDO")
    private double sldo;

    public Cntas() {
    }

    public Cntas(int idCnta) {
        this.idCnta = idCnta;
    }

    public int getIdCnta() {
        return idCnta;
    }

    public void setIdCnta(int idCnta) {
        this.idCnta = idCnta;
    }

    public Date getFchaCrcion() {
        return fchaCrcion;
    }

    public void setFchaCrcion(Date fchaCrcion) {
        this.fchaCrcion = fchaCrcion;
    }

    public String getIdBnco() {
        return idBnco;
    }

    public void setIdBnco(String idBnco) {
        this.idBnco = idBnco;
    }

    public String getNmroIdntfcion() {
        return nmroIdntfcion;
    }

    public void setNmroIdntfcion(String nmroIdntfcion) {
        this.nmroIdntfcion = nmroIdntfcion;
    }

    public String getIdMnda() {
        return idMnda;
    }

    public void setIdMnda(String idMnda) {
        this.idMnda = idMnda;
    }

    public double getSldo() {
        return sldo;
    }

    public void setSldo(double sldo) {
        this.sldo = sldo;
    }
    
}
