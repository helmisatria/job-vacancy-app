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
import models.Lowongan;
import models.Perusahaan;
import view.View;

/**
 *
 * @author BASISDATA
 */
public class LowonganController implements ActionListener{
    
    View view;
    Database db;
    PerusahaanController perusahaanControl;
    public boolean checkInputLowongan() {
        return !("".equals(view.getTxtNamaLowongan().getText()) || "".equals(view.getTxtJumlahLowongan().getText()) || "".equals(view.getTxtIdPerusahaanLowongan().getText()));
    }

    public boolean checkIdInputLowongan() {
        return !"".equals(view.getTxtIdLowongan().getText());
    }

    public void show_lowonganlist(Perusahaan perusahaan) {
        ArrayList<Lowongan> list = getLowonganList(perusahaan);
        DefaultTableModel model = (DefaultTableModel) view.getTableLowongan().getModel();

//        CLEAR TABLE
        model.setRowCount(0);
//        JOptionPane.showMessageDialog(null, list.size());
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getNama();
            row[2] = list.get(i).getJumlahLowongan();
            row[3] = list.get(i).getIdPerusahaan();

            model.addRow(row);
        }
    }

    public ArrayList<Lowongan> getLowonganList(Perusahaan perusahaan) {
//            ArrayList<Lowongan> lowonganList = new ArrayList<>();
        ArrayList<Lowongan> lowonganList = perusahaan.getDaftarLowongan();
        Connection con = db.getConnection();
        String query = "SELECT * from Lowongan where idPerusahaan = " + perusahaan.getId();
//            JOptionPane.showMessageDialog(null, query);
        Statement st;
        ResultSet rs;
        try {

            st = con.createStatement();
            rs = st.executeQuery(query);
            Lowongan lowongan;

            while (rs.next()) {
                lowongan = new Lowongan(rs.getString("id"), rs.getString("nama"), rs.getInt("jumlah_lowongan"), rs.getString("idperusahaan"));
                lowonganList.add(lowongan);
            }

        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lowonganList;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == view.getBtnInsertLowongan()){
            if (checkInputLowongan()) {
                try {
                    Connection con = db.getConnection();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO Lowongan(Nama, jumlah_lowongan, idperusahaan) values (?,?,?)");
                    ps.setString(1, view.getTxtNamaLowongan().getText());
                    ps.setString(2, view.getTxtJumlahLowongan().getText());
                    ps.setString(3, view.getTxtIdPerusahaanLowongan().getText());
                    ps.executeUpdate();

//                    show_perusahaanlist_in_table();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Perusahaan tidak ditemukan!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "One or More fields are Empty!");
            }
        }
    }
    
}
