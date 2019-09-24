package dao;

import controlador.BncosJpaController;
import entity.Bncos;

/**
 *
 * @author henry
 */
public class BncosDAO {

    private BncosJpaController bncosJpaController = new BncosJpaController();
    private Bncos bncos = new Bncos();
    private String mensaje;

    public String insertarBanco(String nmbreBnco) {
        try {
            bncos.setIdBnco(Integer.BYTES);
            bncos.setNmbreBnco(nmbreBnco);
            bncosJpaController.create(bncos);
            mensaje = "Datos Guardos";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Guardos correctamente.";
        }
        return mensaje;
    }
    
    

    public String actualizarBanco(int idBnco,String nmbreBnco) {
    try {
            bncos.setIdBnco(idBnco);
            bncos.setNmbreBnco(nmbreBnco);
            bncosJpaController.edit(bncos);
            mensaje = "Datos Actualizados";

        } catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Datos No fueron Actualizados correctamente.";
        }
        return mensaje;
    }

    public String eliminarBanco(int idBnco) {
        try{
        bncosJpaController.destroy(idBnco);
        mensaje = "Dato Borrado.";
        }catch (Exception ex) {
            System.out.println("Mensaje en Guardar: " + ex.getMessage());
            ex.printStackTrace();
            mensaje = "Dato No fue Borrado correctamente.";
        }
        return mensaje;
    }
}