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
import models.Perusahaan;
import view.View;

/**
 *
 * @author BASISDATA
 */
public class PerusahaanController implements ActionListener{
    
    Database db;
    View view; 
    
    private boolean checkInputPerusahaan() {
        return !("".equals(view.getTxtNamaPerusahaan().getText()) || "".equals(view.getTxtLokasiPerusahaan().getText()));
    }

    public boolean checkIdInputPerusahaan() {
        return !"".equals(view.getTxtIdPerusahaan().getText());
    }

    public ArrayList<Perusahaan> getPerusahaanList() {

        ArrayList<Perusahaan> perusahaanList = new ArrayList<>();
        Connection con = db.getConnection();
        String query = "SELECT * from Perusahaan";

        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(query);
            Perusahaan perusahaan;

            while (rs.next()) {
                perusahaan = new Perusahaan(rs.getString("id"), rs.getString("nama"), rs.getString("lokasi"));
                perusahaanList.add(perusahaan);
            }

        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perusahaanList;
    }

    public void show_perusahaanlist_in_table() {
    }

    public void showEachPerusahaan(int index) {
        view.setTxtIdPerusahaan(Integer.toString(getPerusahaanList().get(index).getId()));
        view.setTxtNamaPerusahaan(getPerusahaanList().get(index).getNama());
        view.setTxtLokasiPerusahaan(getPerusahaanList().get(index).getLokasi());
    }
    public void show_perusahaanlist_in_lowongan() {
        ArrayList<Perusahaan> list = getPerusahaanList();
        DefaultTableModel model = (DefaultTableModel) view.getTablePerusahaanOnLowongan().getModel();

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
        
        if (source == view.getBtnInsertPerusahaan()){
            if (checkInputPerusahaan()) {
                try {
                    Connection con = db.getConnection();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO Perusahaan(Nama, Lokasi) values (?,?)");
                    ps.setString(1, view.getTxtNamaPerusahaan().getText());
                    ps.setString(2, view.getTxtLokasiPerusahaan().getText());
                    ps.executeUpdate();

                    show_perusahaanlist_in_table();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "One or More fields are Empty!");
            }
        } else if (source == view.getBtnUpdatePerusahaan()){
            if (checkInputPerusahaan() && checkIdInputPerusahaan()) {
                String UpdateQuery = null;
                PreparedStatement ps = null;
                Connection con = db.getConnection();

                UpdateQuery = "UPDATE Perusahaan SET nama = ?, lokasi = ? where id = ?";
                try {
                    ps = con.prepareStatement(UpdateQuery);

                    ps.setString(1, view.getTxtNamaPerusahaan().getText());
                    ps.setString(2, view.getTxtLokasiPerusahaan().getText());
                    ps.setInt(3, Integer.parseInt(view.getTxtIdPerusahaan().getText()));

                    ps.executeUpdate();

                    show_perusahaanlist_in_table();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill in all of the fields");
            }
        } else if (source == view.getBtnDeletePerusahaan()){
            if (checkIdInputPerusahaan()) {
                try {
                    Connection con = db.getConnection();
                    String DeleteQuery = "DELETE FROM Perusahaan where id = ?";
                    PreparedStatement ps = null;
                    ps = con.prepareStatement(DeleteQuery);

                    ps.setInt(1, Integer.parseInt(view.getTxtIdPerusahaan().getText()));
                    ps.executeUpdate();

                    show_perusahaanlist_in_table();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Perusahaan id: " + view.getTxtIdPerusahaan().getText() + " not deleted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please input the Perusahaan id");
            }
        }
    }
}
