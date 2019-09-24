/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.CntasDAO;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author henry
 */
public class CuentasTest {
    public static void main(String[] args) throws ParseException {
        
        CntasDAO cntasDAO = new CntasDAO();        
        System.out.println(cntasDAO.insertarCuentas(new Date(20190101), "Bancolombia", "1010179161", "COP",100000));
       // System.out.println(cntasDAO.actualizarCuentas(1,new Date(01/01/2019), "1", "1010179161", "1",150000));
     
    //    SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
   //         java.util.Date objDate = new java.util.Date();
   //         java.util.Date fecha_Actual = objSDF.parse(objDate.toString());
   //         java.util.Date dt_1 = objSDF.parse("20-08-1981");
   //         java.util.Date dt_2 = objSDF.parse("12-10-2012");
        
    //        System.out.println("Fecha Actual " + fecha_Actual);
            
    //     java.util.Date objDate = new java.util.Date(); // Sistema actual La fecha y la hora se asignan a objDate 
 
        //Este Funciona
        //System.out.println(objDate); 
      //  String strDateFormat = "dd-MM-YYYY"; // El formato de fecha está especificado  
      //  SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
        //de formato de fecha  
        //        System.out.println(objSDF.format(objDate)); 
            
    }
 

}
