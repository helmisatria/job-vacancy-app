/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Database;
import models.Pelamar;
import view.View;

/**
 *
 * @author BASISDATA
 */
public class PelamarController implements ActionListener{

    Database db;
    View view; 
    
    public boolean checkInputPelamar() {
        return !("".equals(view.getTxtNamaPelamar().getText())
                || "".equals(view.getTxtAlamatPelamar().getText())
                || "".equals(view.getTxtEmailPelamar().getText())
                || "".equals(view.getTxtNohpPelamar().getText()));
    }

    public boolean checkIdInputPelamar() {
        return !"".equals(view.getTxtIdPelamar().getText());
    }
    
    public void showEachPelamar(int index) {
        
        view.setTxtIdPelamar(Integer.toString(getPelamarList().get(index).getId()));
        view.setTxtNamaPelamar(getPelamarList().get(index).getNama());
        view.setTxtAlamatPelamar(getPelamarList().get(index).getAlamat());
        view.setTxtEmailPelamar(getPelamarList().get(index).getEmail());
        view.setTxtNohpPelamar(getPelamarList().get(index).getNo_hp());
    }
    
    public ArrayList<Pelamar> getPelamarList(){
        
            ArrayList<Pelamar> pelamarList = new ArrayList<>();
            Connection con = db.getConnection();
            String query = "SELECT * from Pelamar";

            Statement st;
            ResultSet rs;
        try {
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            Pelamar pelamar;
            
            while (rs.next()) {
                pelamar = new Pelamar(rs.getString("id"), rs.getString("nama"), rs.getString("alamat"),rs.getString("email"), rs.getString("nohp"));
                pelamarList.add(pelamar);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pelamarList;
    }
    
    public void show_pelamarlist_in_table(){
        ArrayList<Pelamar> list = getPelamarList();
        DefaultTableModel model = (DefaultTableModel) view.getTablePelamar().getModel();
        
//        CLEAR TABLE
        model.setRowCount(0);
        
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getNama();
            row[2] = list.get(i).getAlamat();
            row[3] = list.get(i).getEmail();
            row[4] = list.get(i).getNo_hp();
            
            model.addRow(row);
        }
    }
    public void show_pelamarlist_in_berkas(){
        ArrayList<Pelamar> list = getPelamarList();
        DefaultTableModel model = (DefaultTableModel) view.getTablePelamarOnBerkas().getModel();
        
//        CLEAR TABLE
        model.setRowCount(0);
        
        Object[] row = new Object[2];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getNama();
            
            model.addRow(row);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == view.getBtnInsertPelamar()){
            if (checkInputPelamar()) {
                try {
                    Connection con = db.getConnection();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO Pelamar(Nama, Alamat, Email, Nohp) values (?,?,?,?)");
                    ps.setString(1, view.getTxtNamaPelamar().getText());
                    ps.setString(2, view.getTxtAlamatPelamar().getText());
                    ps.setString(3, view.getTxtEmailPelamar().getText());
                    ps.setString(4, view.getTxtNohpPelamar().getText());
                    ps.executeUpdate();

                    show_pelamarlist_in_table();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "One or More fields are Empty!");
            }
        } else if (source == view.getBtnUpdatePelamar()){
            
            if (checkInputPelamar() && checkIdInputPelamar()) {
                String UpdateQuery = null;
                PreparedStatement ps = null;
                Connection con = db.getConnection();

                UpdateQuery = "UPDATE pelamar SET nama = ?, alamat = ?, email = ?, nohp = ? where id = ?";
                try {
                    ps = con.prepareStatement(UpdateQuery);

                    ps.setString(1, view.getTxtNamaPelamar().getText());
                    ps.setString(2, view.getTxtAlamatPelamar().getText());
                    ps.setString(3, view.getTxtEmailPelamar().getText());
                    ps.setString(4, view.getTxtNohpPelamar().getText());
                    ps.setInt(6, Integer.parseInt(view.getTxtIdPelamar().getText()));

                    ps.executeUpdate();

                    show_pelamarlist_in_table();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill in all of the fields");
            }
        } else if (source == view.getBtnDeletePelamar()){
            if (checkIdInputPelamar()) {
                try {
                    Connection con = db.getConnection();
                    String DeleteQuery = "DELETE FROM Pelamar where id = ?";
                    PreparedStatement ps = null;
                    ps = con.prepareStatement(DeleteQuery);

                    ps.setInt(1, Integer.parseInt(view.getTxtIdPelamar().getText()));
                    ps.executeUpdate();

                    show_pelamarlist_in_table();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Pelamar id: " + view.getTxtIdPelamar().getText() + " not deleted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please input the Pelamar id");
            }
        }
    }
    
}
