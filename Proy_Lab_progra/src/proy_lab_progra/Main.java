
package proy_lab_progra;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Ingrese su usuario:");
        String password = JOptionPane.showInputDialog("Ingrese su contraseña:");

        try {
            if (MySQLConnection.authenticateUser(username, password)) {
                String miPerfilInfo = WebScraper.extractMiPerfilInfo(username, password);
                JOptionPane.showMessageDialog(null, "Información de Mi perfil:\n" + miPerfilInfo);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la página web: " + e.getMessage());
        }
    }
}