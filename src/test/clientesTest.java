/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.ClntesDAO;

/**
 *
 * @author henry
 */
public class clientesTest {
    
     public static void main(String[] args) {
         ClntesDAO clntesDAO = new ClntesDAO();
        //System.out.println(clntesDAO.insertarClientes("1010179161","Henry","Puentes","Colombia","henry"));
        System.out.println(clntesDAO.actualizarClientes(1,"1010179161", "Henry", "Puentes Gonzalez", "Colombia", "henry.puentesg@hotmail.com"));
          
//          System.out.println(clntesDAO.eliminarClientes(2));
//          System.out.println(clntesDAO.eliminarClientes(3));
//          System.out.println(clntesDAO.eliminarClientes(4));
    }
    
    
}
