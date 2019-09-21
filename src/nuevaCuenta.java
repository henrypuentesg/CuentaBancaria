import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class nuevaCuenta extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textAreaNombre;
    private JTextArea textAreaCuenta;
    private JTextArea textAreaSaldo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textAreaInstrucciones;
    private JTextField textField3;

    public int numeroCuenta;
    public String nombreCuenta;
    public int saldo;

    public nuevaCuenta() throws SQLException {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        //Los datos de ingreso se guardan en variables
        String numeroCuenta = textField1.getText();
        String nombreCuenta = textField2.getText();
        String saldo = textField3.getText();


        //Este Botón ingresa los datos en la BD
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Este Botón cierra la ventana
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            Conexion conn = new Conexion();
            Connection conexion = conn.Conexion();
            String sql = "INSERT INTO CUENTAS VALUES (?, ?, ?)";
            String query = "insert into CUENTAS (NUMERO, NOMBRE, SALDO)"+
                    " values (?, ?, ?)";
            PreparedStatement ps =conexion.prepareStatement(query);


        });
    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame("nuevaCuenta");
        frame.setContentPane(new nuevaCuenta().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}



