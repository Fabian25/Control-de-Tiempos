/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import GUI.Main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan
 */
public class Gestor {
    
    BaseDatos.Acceso cc = new BaseDatos.Acceso();
    DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar cal1 = Calendar.getInstance();
    String datetime = cal1.get(Calendar.YEAR) + "-" + cal1.get(Calendar.MONTH) + "-" + cal1.get(Calendar.DAY_OF_MONTH) +" " + cal1.get(Calendar.HOUR) + ":" + cal1.get(Calendar.MINUTE) + ":" + cal1.get(Calendar.SECOND);    
    public static String numberlogin;
    
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
    
    public void AddTechnician (JTextField txtEmNo1, JTextField txtEmNo, JPasswordField txtPass, JTextField txtDep){
        if (txtEmNo1.getText().length() != 0 && txtEmNo.getText().length() != 0 && txtPass.getPassword().length != 0){
            Connection cn = cc.conexion();

            try {
                java.sql.PreparedStatement pst = cn.prepareStatement("Insert into Rework.Tecnico values (?,?,?,?,?)");
                pst.setString(1, txtEmNo.getText());
                pst.setString(2, txtEmNo1.getText());
                pst.setInt(3, 1);
                pst.setString(4, new String(txtPass.getPassword()));
                pst.setString(5, txtDep.getText());

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
    
    public void AddProdNo(JComboBox cmbDep, JTextField txtProd){
        if (cmbDep.getSelectedIndex() >= 0 && txtProd.getText().length() != 0){
            Connection cn = cc.conexion();

            try {
                java.sql.PreparedStatement pst = cn.prepareStatement("Insert into Rework.ProdNo values (?,?)");
                pst.setString(1, txtProd.getText());
                pst.setString(2, cmbDep.getSelectedItem().toString());
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
                java.sql.PreparedStatement pst = cn.prepareStatement("Insert into Rework.Departamento values (?,?)");
                pst.setString(1, txtDep.getText());
                pst.setString(2, cmbArea.getSelectedItem().toString());
                

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
                        numberlogin = datos[0];
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
                        numberlogin = datos[0];
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
    
    public void BussinesUnit (JComboBox cmbBU) {
        Connection cn= cc.conexion();
        String sql = "Select * from Rework.BusinessUnit";
        String datos = new String();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                datos=rs.getString(1);
                cmbBU.addItem(datos);
            }
        } catch (SQLException ex) {
        }
    }

    public void AreaBU(JComboBox cmbArea, JComboBox cmbBu){
        Connection cn= cc.conexion();
        String sql = "Select ara_Id from Rework.Area where bu_Id = '" + cmbBu.getSelectedItem().toString() + "'";
        String datos = new String();
        cmbArea.removeAllItems();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                datos=rs.getString(1);
                cmbArea.addItem(datos);
            }
        } catch (SQLException ex) {
        }
    }
    
    public void depPN (JComboBox cmbDep){
        Connection cn= cc.conexion();
        String sql = "Select * from Rework.Departamento";
        String datos = new String();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                datos=rs.getString(1);
                cmbDep.addItem(datos);
            }
        } catch (SQLException ex) {
        }
    }
    
    public void LoadTech (JComboBox cmbTech, JComboBox cmbProdNo, JComboBox cmbRType){
        cmbTech.addItem(numberlogin);
        
        Connection cn= cc.conexion();
        String sql = "SELECT PN.idProdNo FROM Rework.ProdNo PN, Rework.Tecnico T where T.tec_dep = PN.dep_Id and T.tec_Id = '" + numberlogin + "';";
        String datos = new String();
        cmbProdNo.removeAllItems();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                datos=rs.getString(1);
                cmbProdNo.addItem(datos);
            }
        } catch (SQLException ex) {
        }
        
        sql = "SELECT * FROM Rework.ReworkType;";
        datos = new String();
        cmbRType.removeAllItems();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                datos=rs.getString(1);
                cmbRType.addItem(datos);
            }
        } catch (SQLException ex) {
        }
    }
    
    public void SaveTech (JComboBox cmbTech, JComboBox cmbProdNo, JComboBox cmbRType,JTextField txtSerie, JTextArea txtComment){
        
        if (cmbProdNo.getSelectedIndex() >= 0 && cmbRType.getSelectedIndex() >= 0 && txtSerie.getText().length() != 0 && txtComment.getText().length() != 0){
            Connection cn = cc.conexion();

            try {
                java.sql.PreparedStatement pst = cn.prepareStatement("Insert into Rework.Reporte values (?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1, null);
                pst.setString(2, numberlogin);
                pst.setString(3, cmbProdNo.getSelectedItem().toString());
                pst.setString(4, txtSerie.getText());
                pst.setString(5, cmbRType.getSelectedItem().toString());
                pst.setString(6, txtComment.getText());
                pst.setString(7, null);
                pst.setString(8, datetime);
                pst.setString(9, null);
                pst.setString(10, null);
                int upd = pst.executeUpdate();
                if (upd > 0){
                    JOptionPane.showMessageDialog(null, "Updated Registry");
                }
                else {
                    
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }
    }

    public void LoadRwk (JTable tableG, JComboBox cmbReworker){
        cmbReworker.addItem(numberlogin);
        Connection cn= cc.conexion();
        String sql = "SELECT * FROM Rework.Reporte;";
        
        String [] columnas = {"Id","Technician", "Prod No", "Serial No", "Rwk Type", "Description", "Reworker", "Idle_STime", "Act_STime", "Act_ETime" };
        DefaultTableModel modelo = new DefaultTableModel(null, columnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
      
        String datos[] = new String[10];
        Object [] fila=new Object[10];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                if (rs.getString(10) == null){
                    datos[0]=rs.getString(1);
                    fila[0] = datos [0];
                    datos[1]=rs.getString(2);
                    fila[1] = datos [1];
                    datos[2]=rs.getString(3);
                    fila[2] = datos [2];
                    datos[3]=rs.getString(4);
                    fila[3] = datos [3];
                    datos[4]=rs.getString(5);
                    fila[4] = datos [4];
                    datos[5]=rs.getString(6);
                    fila[5] = datos [5];
                    datos[6]=rs.getString(7);
                    fila[6] = datos [6];
                    datos[7]=rs.getString(8);
                    fila[7] = datos [7];
                    datos[8]=rs.getString(9);
                    fila[8] = datos [8];
                    datos[9]=rs.getString(10);
                    fila[9] = datos [9];
                    modelo.addRow(fila);
                    tableG.setModel(modelo);
                }
            }
        } catch (SQLException ex) {
        }
    }
    
    public void SAT(int id){
        if (id != 0){
            Connection cn = cc.conexion();
            try {
                java.sql.PreparedStatement pst = cn.prepareStatement("Update Rework.Reporte Set rwk_Id = ?, Idle_E_A_S_Time = ? Where idReporte = ?;");
                pst.setString(1, numberlogin);
                pst.setString(2, datetime);
                pst.setString(3, String.valueOf(id));
                int upd = pst.executeUpdate();
                if (upd > 0){
                    JOptionPane.showMessageDialog(null, "Updated Registry");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    public void EAT(int id){
        if (id != 0){
            Connection cn = cc.conexion();
            try {
                java.sql.PreparedStatement pst = cn.prepareStatement("Update Rework.Reporte Set Activity_E_Time = ? Where idReporte = ?;");
                pst.setString(1, datetime);
                pst.setString(2, String.valueOf(id));
                int upd = pst.executeUpdate();
                if (upd > 0){
                    JOptionPane.showMessageDialog(null, "Updated Registry");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
}
