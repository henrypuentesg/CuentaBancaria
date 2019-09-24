/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry
 */
@Entity
@Table(name = "CLNTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clntes.findAll", query = "SELECT c FROM Clntes c"),
    @NamedQuery(name = "Clntes.findByIdClnte", query = "SELECT c FROM Clntes c WHERE c.idClnte = :idClnte"),
    @NamedQuery(name = "Clntes.findByNmroIdntfcion", query = "SELECT c FROM Clntes c WHERE c.nmroIdntfcion = :nmroIdntfcion"),
    @NamedQuery(name = "Clntes.findByNmbreClnte", query = "SELECT c FROM Clntes c WHERE c.nmbreClnte = :nmbreClnte"),
    @NamedQuery(name = "Clntes.findByAplldoClnte", query = "SELECT c FROM Clntes c WHERE c.aplldoClnte = :aplldoClnte"),
    @NamedQuery(name = "Clntes.findByPaisClnte", query = "SELECT c FROM Clntes c WHERE c.paisClnte = :paisClnte"),
    @NamedQuery(name = "Clntes.findByCrreoClnte", query = "SELECT c FROM Clntes c WHERE c.crreoClnte = :crreoClnte")})
public class Clntes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLNTE")
    private int idClnte;
    @Column(name = "NMRO_IDNTFCION")
    private String nmroIdntfcion;
    @Column(name = "NMBRE_CLNTE")
    private String nmbreClnte;
    @Column(name = "APLLDO_CLNTE")
    private String aplldoClnte;
    @Column(name = "PAIS_CLNTE")
    private String paisClnte;
    @Column(name = "CRREO_CLNTE")
    private String crreoClnte;

    public Clntes() {
    }

    public Clntes(int idClnte) {
        this.idClnte = idClnte;
    }

    public int getIdClnte() {
        return idClnte;
    }

    public void setIdClnte(int idClnte) {
        this.idClnte = idClnte;
    }

    public String getNmroIdntfcion() {
        return nmroIdntfcion;
    }

    public void setNmroIdntfcion(String nmroIdntfcion) {
        this.nmroIdntfcion = nmroIdntfcion;
    }

    public String getNmbreClnte() {
        return nmbreClnte;
    }

    public void setNmbreClnte(String nmbreClnte) {
        this.nmbreClnte = nmbreClnte;
    }

    public String getAplldoClnte() {
        return aplldoClnte;
    }

    public void setAplldoClnte(String aplldoClnte) {
        this.aplldoClnte = aplldoClnte;
    }

    public String getPaisClnte() {
        return paisClnte;
    }

    public void setPaisClnte(String paisClnte) {
        this.paisClnte = paisClnte;
    }

    public String getCrreoClnte() {
        return crreoClnte;
    }

    public void setCrreoClnte(String crreoClnte) {
        this.crreoClnte = crreoClnte;
    }
    
}
