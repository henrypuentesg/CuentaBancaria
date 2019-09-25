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
@Table(name = "MVMTOS_CNTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MvmtosCntas.findAll", query = "SELECT m FROM MvmtosCntas m"),
    @NamedQuery(name = "MvmtosCntas.findByIdMvmnto", query = "SELECT m FROM MvmtosCntas m WHERE m.idMvmnto = :idMvmnto"),
    @NamedQuery(name = "MvmtosCntas.findByIdCnta", query = "SELECT m FROM MvmtosCntas m WHERE m.idCnta = :idCnta"),
    @NamedQuery(name = "MvmtosCntas.findByFchaMvmnto", query = "SELECT m FROM MvmtosCntas m WHERE m.fchaMvmnto = :fchaMvmnto"),
    @NamedQuery(name = "MvmtosCntas.findByVlor", query = "SELECT m FROM MvmtosCntas m WHERE m.vlor = :vlor")})
public class MvmtosCntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MVMNTO")
    private int idMvmnto;
    @Column(name = "ID_CNTA")
    private int idCnta;
    @Column(name = "FCHA_MVMNTO")
    @Temporal(TemporalType.DATE)
    private Date fchaMvmnto;
    @Column(name = "VLOR")
    private double vlor;

    public MvmtosCntas() {
    }

    public MvmtosCntas(int idMvmnto) {
        this.idMvmnto = idMvmnto;
    }

    public int getIdMvmnto() {
        return idMvmnto;
    }

    public void setIdMvmnto(int idMvmnto) {
        this.idMvmnto = idMvmnto;
    }

    public int getIdCnta() {
        return idCnta;
    }

    public void setIdCnta(int idCnta) {
        this.idCnta = idCnta;
    }

    public Date getFchaMvmnto() {
        return fchaMvmnto;
    }

    public void setFchaMvmnto(Date fchaMvmnto) {
        this.fchaMvmnto = fchaMvmnto;
    }

    public double getVlor() {
        return vlor;
    }

    public void setVlor(double vlor) {
        this.vlor = vlor;
    }
    


}
