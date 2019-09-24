/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controlador.MndasJpaController;
import entity.Mndas;

/**
 *
 * @author henry
 */
public class MndasDAO {
    
    private MndasJpaController mndasJpaController = new MndasJpaController();
    private Mndas mndas = new Mndas();
    private String mensaje;
    
    public String insertarMndas(String dscMnda) {

        try {            
            mndas.setIdMnda(Integer.BYTES);
            mndas.setDscMnda(dscMnda);
            mndasJpaController.create(mndas);
            mensaje = "Datos Guardos";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Guardos correctamente.";
        }
        return mensaje;
    }

    public String actualizarMndas(int idMnda,String dscMnda) {
        try {
            mndas.setIdMnda(idMnda);
            mndas.setDscMnda(dscMnda);
            mndasJpaController.edit(mndas);
            mensaje = "Datos Actualizados";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Actualizados correctamente.";
        }
        return mensaje;
    }

    public String eliminarMndas(int idMnda) {
        try {
            mndasJpaController.destroy(idMnda);
            mensaje = "Dato Borrado.";
        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Dato No fue Borrado correctamente.";
        }
        return mensaje;
    }
    
    
}
