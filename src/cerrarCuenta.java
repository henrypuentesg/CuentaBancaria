import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cerrarCuenta extends JDialog {
    private JPanel contentPane;
    private JButton buttonBORRAR;
    private JButton buttonCancel;
    private JTextArea estaSeguroDeQueTextArea;
    private JPanel textAreaTitulo;
    private JTextArea textAreaCuenta;
    private JTextField textFieldCuenta;

    public cerrarCuenta() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);


        buttonBORRAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        cerrarCuenta dialog = new cerrarCuenta();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
