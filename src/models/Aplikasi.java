/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.View;


public class Aplikasi {
  
    /**
     * @param args the command line arguments
     */
    Database db;
    
    public Aplikasi(){
        db = new Database();
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
}
