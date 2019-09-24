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

}
