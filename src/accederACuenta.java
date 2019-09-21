import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class accederACuenta extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextArea textAreaNombre;
    private JLabel labelNombre;
    private JTextArea textAreaSaldo;
    private JLabel labelSaldo;
    private JTextArea textAreaAgregarMonto;
    private JTextField textFieldAgregarMonto;
    private JTextArea textAreaRetirarMonto;
    private JTextField textField1;
    private JButton buttonAgregarMonto;
    private JButton buttonRetirarMonto;
    private JTextArea textAreaTransferencia;
    private JTextField textFieldTransferenciaCuenta;
    private JTextField textFieldTransferenciaMonto;
    private JButton buttonTransferencia;

    public accederACuenta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }

    public static void main(String[] args) {
        accederACuenta dialog = new accederACuenta();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
