/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.MndasDAO;

/**
 *
 * @author henry
 */
public class MonedasTest {
    
    public static void main(String[] args) {
        
        MndasDAO mndasDAO = new MndasDAO();
        System.out.println(mndasDAO.insertarMndas("USD"));
        System.out.println(mndasDAO.insertarMndas("CAD"));
        System.out.println(mndasDAO.actualizarMndas(1, "COP"));
        System.out.println(mndasDAO.eliminarMndas(2));
    }
    
}
