/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controlador.CntasJpaController;
import entity.Cntas;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author henry
 */
public class CntasDAO {

    private CntasJpaController cntasJpaController = new CntasJpaController();
    private Cntas cntas = new Cntas();
    private String mensaje;

    public String insertarCuentas(Date fchaCrcion, String idBnco, String nmroIdntfcion, String idMnda, double sldo) {
        try {
            cntas.setIdCnta(Integer.BYTES);
            cntas.setFchaCrcion(fchaCrcion);
            cntas.setIdBnco(idBnco);
            cntas.setNmroIdntfcion(nmroIdntfcion);
            cntas.setIdMnda(idMnda);
            cntas.setSldo(sldo);
            cntasJpaController.create(cntas);
            mensaje = "Datos Guardos";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Guardos correctamente.";
        }
        return mensaje;
    }

    public String actualizarCuentas(int IdCnta,Date fchaCrcion, String idBnco, String nmroIdntfcion, String idMnda, double sldo) {
        try {
            cntas.setIdCnta(IdCnta);
            cntas.setFchaCrcion(fchaCrcion);
            cntas.setIdBnco(idBnco);
            cntas.setNmroIdntfcion(nmroIdntfcion);
            cntas.setIdMnda(idMnda);
            cntas.setSldo(sldo);
            cntasJpaController.edit(cntas);
            mensaje = "Datos Actualizados";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Actualizados correctamente.";
        }
        return mensaje;
    }

    public String eliminarCuentas(int IdCnta) {
        try {
            cntasJpaController.destroy(IdCnta);
            mensaje = "Dato Borrado.";
        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Dato No fue Borrado correctamente.";
        }
        return mensaje;
    }
    
    
    public void listarCuentas(JTable tabla){
        DefaultTableModel model;
        
        String [] titulo = {"Numero Cuenta","Fecha Creacion","Banco","Cedula","Moneda","Saldo"};
        model = new DefaultTableModel(null,titulo);
        
        List <Cntas> datos = cntasJpaController.findCntasEntities();
        
        String [] datosCuenta = new String[6];
        for (Cntas cntas:datos ){
        
            datosCuenta[0] = cntas.getIdCnta()+"";
            datosCuenta[1] = cntas.getFchaCrcion()+"";
            datosCuenta[2] = cntas.getIdBnco()+"";
            datosCuenta[3] = cntas.getNmroIdntfcion()+"";
            datosCuenta[4] = cntas.getIdMnda()+"";
            datosCuenta[5] = cntas.getSldo()+"";
            
            model.addRow(datosCuenta);
        }
        
        tabla.setModel(model);
        
        
        
    }
    
    
        public Cntas buscarCuentasId(int idCnta){
        Cntas cntas;
        EntityManager entityManager = cntasJpaController.getEntityManager();
        
        Query query = entityManager.createQuery("SELECT c FROM Cntas c WHERE c.idCnta = :idCnta");
        query.setParameter("idCnta", idCnta);
        
        cntas=(Cntas) query.getSingleResult();
        return cntas;
        
    }
    
    
    

}
