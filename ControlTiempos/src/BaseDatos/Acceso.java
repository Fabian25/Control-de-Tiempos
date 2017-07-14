/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class Acceso {
    Connection conectar = null;
    public Connection conexion() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/rework","root","Jcastro2696");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        } catch (ClassNotFoundException ex) {
            return conectar;
        }
        return conectar;
    }
}
