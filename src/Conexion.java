import java.sql.*;
import java.util.Scanner;

public class Conexion {

    public Connection Conexion() {
        Connection con = null;
        String url_db = "jdbc:h2:c:/temp/cuentaBancaria";
        String db = "cuentaBancaria";
        String driver = "org.h2.Driver";
        String user = "user";
        String pass = "clave";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url_db + db, user, pass);
            if (con == null) {
                System.out.println("No se ha podido conectar");
            }
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
