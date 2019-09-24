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
import javax.persistence.metamodel.SingularAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henry
 */
@Entity
@Table(name = "BNCOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bncos.findAll", query = "SELECT b FROM Bncos b"),
    @NamedQuery(name = "Bncos.findByIdBnco", query = "SELECT b FROM Bncos b WHERE b.idBnco = :idBnco"),
    @NamedQuery(name = "Bncos.findByNmbreBnco", query = "SELECT b FROM Bncos b WHERE b.nmbreBnco = :nmbreBnco")})
public class Bncos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BNCO")
    private int idBnco;
    @Column(name = "NMBRE_BNCO")
    private String nmbreBnco;

    public Bncos() {
    }

    public Bncos(int idBnco) {
        this.idBnco = idBnco;
    }

    public int getIdBnco() {
        return idBnco;
    }

    public void setIdBnco(int idBnco) {
        this.idBnco = idBnco;
    }

    public String getNmbreBnco() {
        return nmbreBnco;
    }

    public void setNmbreBnco(String nmbreBnco) {
        this.nmbreBnco = nmbreBnco;
    }

    
}
