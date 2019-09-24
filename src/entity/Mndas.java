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
@Table(name = "MNDAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mndas.findAll", query = "SELECT m FROM Mndas m"),
    @NamedQuery(name = "Mndas.findByIdMnda", query = "SELECT m FROM Mndas m WHERE m.idMnda = :idMnda"),
    @NamedQuery(name = "Mndas.findByDscMnda", query = "SELECT m FROM Mndas m WHERE m.dscMnda = :dscMnda")})
public class Mndas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MNDA")
    private int idMnda;
    @Column(name = "DSC_MNDA")
    private String dscMnda;

    public Mndas() {
    }

    public Mndas(int idMnda) {
        this.idMnda = idMnda;
    }

    public int getIdMnda() {
        return idMnda;
    }

    public void setIdMnda(int idMnda) {
        this.idMnda = idMnda;
    }

    public String getDscMnda() {
        return dscMnda;
    }

    public void setDscMnda(String dscMnda) {
        this.dscMnda = dscMnda;
    }

}
