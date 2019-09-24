/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controlador.MndasJpaController;
import controlador.MvmtosCntasJpaController;
import entity.Mndas;
import entity.MvmtosCntas;
import java.sql.Date;

/**
 *
 * @author henry
 */
public class MvmtosCntasDAO {

    private MvmtosCntasJpaController mvmtosCntasJpaController = new MvmtosCntasJpaController();
    private MvmtosCntas mvmtosCntas = new MvmtosCntas();
    private String mensaje;

    public String insertarMvmntosCntas(int idCnta, Date fchaMvmnto, double vlor) {
        try {
            mvmtosCntas.setIdMvmnto(Integer.BYTES);
            mvmtosCntas.setIdCnta(idCnta);
            mvmtosCntas.setFchaMvmnto(fchaMvmnto);
            mvmtosCntas.setVlor(vlor);
            mvmtosCntasJpaController.create(mvmtosCntas);
            mensaje = "Datos Guardos";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Guardos correctamente.";
        }
        return mensaje;
    }

    public String actualizarMvmntosCntas(int idMvmnto, int idCnta, Date fchaMvmnto, double vlor) {
        try {
            mvmtosCntas.setIdMvmnto(idMvmnto);
            mvmtosCntas.setIdCnta(idCnta);
            mvmtosCntas.setFchaMvmnto(fchaMvmnto);
            mvmtosCntas.setVlor(vlor);
            mvmtosCntasJpaController.edit(mvmtosCntas);
            mensaje = "Datos Actualizados";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Actualizados correctamente.";
        }
        return mensaje;
    }

    public String eliminarMvmntosCntas(int idMvmnto) {
        try {
            mvmtosCntasJpaController.destroy(idMvmnto);
            mensaje = "Dato Borrado.";
        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Dato No fue Borrado correctamente.";
        }
        return mensaje;
    }
}
