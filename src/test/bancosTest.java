/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.BncosDAO;

/**
 *
 * @author henry
 */
public class bancosTest {
    
    public static void main(String[] args) {
        BncosDAO bncosDAO = new BncosDAO();
        System.out.println(bncosDAO.insertarBanco("Banco Popular"));
        //System.out.println(bncosDAO.actualizarBanco(1,"Banco Popular 2"));
        //System.out.println(bncosDAO.eliminarBanco(1));
    }
    
}
