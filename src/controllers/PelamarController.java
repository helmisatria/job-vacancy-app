/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    View view = new View(); 
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
        DefaultTableModel model = (DefaultTableModel) tablePelamar.getModel();
        
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
        DefaultTableModel model = (DefaultTableModel) tablePelamarOnBerkas.getModel();
        
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
        
    }
    
}
