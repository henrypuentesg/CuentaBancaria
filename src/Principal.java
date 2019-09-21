import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Principal {
    private JButton borrarCuenta;
    private JButton crearCuenta;
    private JButton accederCuenta;
    private JPanel principal;
    private JTextArea esteEsUnCajeroTextArea;
    private JTextArea textAreaIngresarCuenta;
    private JTextField textFieldNumeroDeCuenta;


    public Principal() {

        //Botón para crear cuenta
        crearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nuevaCuenta dialog = new nuevaCuenta();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Botón para acceder a cuenta
        accederCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    accederACuenta dialog = new accederACuenta();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        //Botón para cerra la cuenta
        borrarCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cerrarCuenta dialog = new cerrarCuenta();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

    }


//En este lugar va el main
    public Conexion conexion;

    public static void main(String[] args)throws Exception {

            Conexion conn = new Conexion();
            Connection conexion = conn.Conexion();


        JFrame frame = new JFrame("Principal");
        frame.setContentPane(new Principal().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    //La llave es el fin del programa
}

/*
Esto va dentro de MAIN y es para crear la base de datos
 */
