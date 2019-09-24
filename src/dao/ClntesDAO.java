/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controlador.ClntesJpaController;
import entity.Clntes;

/**
 *
 * @author henry
 */
public class ClntesDAO {

    private ClntesJpaController clntesJpaController = new ClntesJpaController();
    private Clntes clntes = new Clntes();
    private String mensaje;

    public String insertarClientes(String nmroIdntfcion, String nmbreClnte, String aplldoClnte, String paisClnte, String crreoClnte) {

        try {
            clntes.setIdClnte(Integer.BYTES);
            clntes.setNmroIdntfcion(nmroIdntfcion);
            clntes.setNmbreClnte(nmbreClnte);
            clntes.setAplldoClnte(aplldoClnte);
            clntes.setPaisClnte(paisClnte);
            clntes.setCrreoClnte(crreoClnte);
            clntesJpaController.create(clntes);
            mensaje = "Datos Guardos";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Guardos correctamente.";
        }
        return mensaje;
    }

    public String actualizarClientes(int idClnte,String nmroIdntfcion, String nmbreClnte, String aplldoClnte, String paisClnte, String crreoClnte) {
        try {
            clntes.setIdClnte(idClnte);
            clntes.setNmroIdntfcion(nmroIdntfcion);
            clntes.setNmbreClnte(nmbreClnte);
            clntes.setAplldoClnte(aplldoClnte);
            clntes.setPaisClnte(paisClnte);
            clntes.setCrreoClnte(crreoClnte);
            clntesJpaController.edit(clntes);
            mensaje = "Datos Actualizados";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Actualizados correctamente.";
        }
        return mensaje;
    }

    public String eliminarClientes(int idClnte) {
        try {
            clntesJpaController.destroy(idClnte);
            mensaje = "Dato Borrado.";
        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Dato No fue Borrado correctamente.";
        }
        return mensaje;
    }

}
