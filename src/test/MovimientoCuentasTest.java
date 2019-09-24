/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.MvmtosCntasDAO;
import java.sql.Date;

/**
 *
 * @author henry
 */
public class MovimientoCuentasTest {    
    
    public static void main(String[] args) {
        MvmtosCntasDAO mvmtosCntasDAO = new MvmtosCntasDAO();
        System.out.println(mvmtosCntasDAO.insertarMvmntosCntas(1,new Date(01/01/2019), 100000));
        System.out.println(mvmtosCntasDAO.insertarMvmntosCntas(1,new Date(01/01/2019), 200000));
        System.out.println(mvmtosCntasDAO.actualizarMvmntosCntas(1,1,new Date(01/01/2019), 400000));
        System.out.println(mvmtosCntasDAO.eliminarMvmntosCntas(1));
        
    }
    
    
}
