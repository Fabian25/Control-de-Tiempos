/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jonathan
 */
public class Gestor {
    
    BaseDatos.Acceso cc = new BaseDatos.Acceso();
    public static ArrayList arrBU = new ArrayList();
    
    public void AddReworker (JTextField txtEmName, JTextField txtEmNo, JPasswordField txtPass){
        if (txtEmName.getText().length() != 0 && txtEmNo.getText().length() != 0 && txtPass.getPassword().length != 0){
            Connection cn = cc.conexion();

            try {
                java.sql.PreparedStatement pst = cn.prepareStatement("Insert into Rework.Rework values (?,?,?,?)");
                pst.setString(1, txtEmNo.getText());
                pst.setString(2, txtEmName.getText());
                pst.setInt(3, 1);
                pst.setString(4, new String(txtPass.getPassword()));

                int upd = pst.executeUpdate();
                if (upd > 0){
                    JOptionPane.showMessageDialog(null, "Updated Registry");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
            }
            txtEmNo.setText("");
            txtEmName.setText("");
            txtPass.setText("");
        }
        else {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }
    }
    
    public void AddTechnician (JTextField txtEmNo1, JTextField txtEmNo, JPasswordField txtPass){
        if (txtEmNo1.getText().length() != 0 && txtEmNo.getText().length() != 0 && txtPass.getPassword().length != 0){
            Connection cn = cc.conexion();

            try {
                java.sql.PreparedStatement pst = cn.prepareStatement("Insert into Rework.Tecnico values (?,?,?,?)");
                pst.setString(1, txtEmNo.getText());
                pst.setString(2, txtEmNo1.getText());
                pst.setInt(3, 1);
                pst.setString(4, new String(txtPass.getPassword()));

                int upd = pst.executeUpdate();
                if (upd > 0){
                    JOptionPane.showMessageDialog(null, "Updated Registry");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
            }
            txtEmNo.setText("");
            txtEmNo1.setText("");
            txtPass.setText("");
        }
        else {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }
    }
    
    public void AddProdNo(JComboBox cmbArea, JTextField txtProd){
        if (cmbArea.getSelectedIndex() >= 0 && txtProd.getText().length() == 0){
            Connection cn = cc.conexion();

            try {
                java.sql.PreparedStatement pst = cn.prepareStatement("Insert into Rework.ProdNo values (?,?)");
                pst.setString(1, cmbArea.getSelectedItem().toString());
                pst.setString(2, txtProd.getText());

                int upd = pst.executeUpdate();
                if (upd > 0){
                    JOptionPane.showMessageDialog(null, "Updated Registry");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
            }
            txtProd.setText("");
        }
        else {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }
    }
    
    public void AddDepartment (JComboBox cmbBU, JComboBox cmbArea, JTextField txtDep){
        if (cmbBU.getSelectedIndex() >= 0 && cmbArea.getSelectedIndex() >= 0 && txtDep.getText().length() != 0){
            Connection cn = cc.conexion();

            try {
                java.sql.PreparedStatement pst = cn.prepareStatement("Insert into Rework.Rework values (?,?)");
                pst.setString(1, cmbArea.getSelectedItem().toString());
                pst.setString(2, txtDep.getText());

                int upd = pst.executeUpdate();
                if (upd > 0){
                    JOptionPane.showMessageDialog(null, "Updated Registry");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
            }
            txtDep.setText("");
        }
        else {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }
    }
    
    public void LogTech (JTextField txtuser, JPasswordField txtpass){
        if (txtuser.getText().length() == 0 || txtpass.getPassword().length == 0){
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        }
        else {
            Connection cn= cc.conexion();
            String pass = new String (txtpass.getPassword());
            String sql = "SELECT * FROM Rework.Tecnico where tec_Id = " + txtuser.getText() + " and tec_Pass = '" + pass + "';" ;
            String[] datos = new String[4];
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[3] = rs.getString(4);
                }
                if (datos[0] != null){
                    if (datos[0].equals(txtuser.getText()) && datos[3].equals(pass)){
                    GUI.TechnicianUI tui = new GUI.TechnicianUI();
                    tui.setLocationRelativeTo(null);
                    tui.setVisible(true);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong User or password");
                }
            } catch (SQLException ex) {
                   ex.printStackTrace();
            }
        }
    }
    
    public void LogRWK (JTextField txtuser, JPasswordField txtpass){
        if (txtuser.getText().length() == 0 || txtpass.getPassword().length == 0){
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        }
        else {
            Connection cn= cc.conexion();
            String pass = new String (txtpass.getPassword());
            String sql = "SELECT * FROM Rework.Rework where rwk_Id = " + txtuser.getText() + " and rwk_Pass = '" + pass + "';" ;
            String[] datos = new String[4];
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()) {
                    datos[0] = rs.getString(1);
                    datos[3] = rs.getString(4);
                }
                if (datos[0] != null){
                    if (datos[0].equals(txtuser.getText()) && datos[3].equals(pass)){
                    GUI.ReworkUI rui = new GUI.ReworkUI();
                    rui.setLocationRelativeTo(null);
                    rui.setVisible(true);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong User or password");
                }
            } catch (SQLException ex) {
                   ex.printStackTrace();
            }
        }
    }
    
    public void BussinesUnit () {
        Connection cn= cc.conexion();
        String sql = "Select * from Rework.BusinessUnit";
        String datos = new String();
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                datos=rs.getString(1);
                arrBU.add(datos);
            }
        } catch (SQLException ex) {
        }
    }
}
