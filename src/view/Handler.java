/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.PelamarController;
import controllers.PelamarController;
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
import models.Aplikasi;
import models.Database;
import models.Lowongan;
import models.Pelamar;
import models.Perusahaan;
import view.View;

/**
 *
 * @author BASISDATA
 */
public class Handler implements ActionListener{
    
    private Aplikasi model;
    private View view;
    private Database db = new Database();
    PelamarController PelamarControl = new PelamarController();
    
    public Handler(){
        model = new Aplikasi();
        view = new View();
        view.setVisible(true);
        view.addActionListener(this);
        view.show_pelamarlist_in_table(getPelamarList());
        view.show_pelamarlist_in_berkas(getPelamarList());
        view.show_perusahaanlist_in_table(getPerusahaanList());
        view.show_perusahaanlist_in_lowongan();
//        view.show_pelamarlist_in_table(view.getLowonganList(perusahaan));
    }
//    ---------------------PELAMAR--------------------------------
//    -------------------------LOWONGAN---------------------------
    
    public boolean checkInputPelamar() {
        return !("".equals(view.getTxtNamaPelamar().getText())
                || "".equals(view.getTxtAlamatPelamar())
                || "".equals(view.getTxtEmailPelamar().getText())
                || "".equals(view.getTxtNohpPelamar().getText()));
    }

    public boolean checkIdInputPelamar() {
        return !"".equals(view.getTxtIdPelamar().getText());
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
    
    public void insertPelamar(){
        
        if (checkInputPelamar()) {
                try {
                    Connection con = db.getConnection();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO Pelamar(Nama, Alamat, Email, Nohp) values (?,?,?,?)");
                    ps.setString(1, view.getTxtNamaPelamar().getText());
                    ps.setString(2, view.getTxtAlamatPelamar());
                    ps.setString(3, view.getTxtEmailPelamar().getText());
                    ps.setString(4, view.getTxtNohpPelamar().getText());
                    ps.executeUpdate();

                    view.show_pelamarlist_in_table(getPelamarList());
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "One or More fields are Empty!");
            }
    }
    public void updatePelamar(){
        if (checkInputPelamar() && checkIdInputPelamar()) {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = db.getConnection();

            UpdateQuery = "UPDATE pelamar SET nama = ?, alamat = ?, email = ?, nohp = ? where id = ?";
            try {
                ps = con.prepareStatement(UpdateQuery);

                ps.setString(1, view.getTxtNamaPelamar().getText());
                ps.setString(2, view.getTxtAlamatPelamar());
                ps.setString(3, view.getTxtEmailPelamar().getText());
                ps.setString(4, view.getTxtNohpPelamar().getText());
                ps.setInt(5, Integer.parseInt(view.getTxtIdPelamar().getText()));

                ps.executeUpdate();

                view.show_pelamarlist_in_table(getPelamarList());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please fill in all of the fields");
        }
    }
    
    public void deletePelamar(){
        if (checkIdInputPelamar()) {
            try {
                Connection con = db.getConnection();
                String DeleteQuery = "DELETE FROM Pelamar where id = ?";
                PreparedStatement ps = null;
                ps = con.prepareStatement(DeleteQuery);

                ps.setInt(1, Integer.parseInt(view.getTxtIdPelamar().getText()));
                ps.executeUpdate();

                view.show_pelamarlist_in_table(getPelamarList());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Pelamar id: " + view.getTxtIdPelamar().getText() + " not deleted");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please input the Pelamar id");
        }
    }
//    --------------------- END PELAMAR--------------------------------
//    ----------------------- PERUSAHAAN ---------------------------
    private boolean checkInputPerusahaan() {
        return !("".equals(view.getTxtNamaPerusahaan().getText()) || "".equals(view.getTxtLokasiPerusahaan().getText()));
    }

    public boolean checkIdInputPerusahaan() {
        return !"".equals(view.getTxtIdPerusahaan().getText());
    }
    
    public Perusahaan getPerusahaan(String id){
        
        Perusahaan p = null;
        Connection con = db.getConnection();
        String query = "SELECT * from Perusahaan where id="+id;
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            
            while(rs.next()){
                p = new Perusahaan(rs.getString("id"), rs.getString("nama"), rs.getString("lokasi"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
         return p;
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
    private void insertPerusahaan() {
        if (checkInputPerusahaan()) {
            try {
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO Perusahaan(Nama, Lokasi) values (?,?)");
                ps.setString(1, view.getTxtNamaPerusahaan().getText());
                ps.setString(2, view.getTxtLokasiPerusahaan().getText());
                ps.executeUpdate();

                view.show_perusahaanlist_in_table(getPerusahaanList());
                view.show_perusahaanlist_in_lowongan();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or More fields are Empty!");
        }
    }

    private void updatePerusahaan() {
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

                view.show_perusahaanlist_in_table(getPerusahaanList());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please fill in all of the fields");
        }
    }

    private void deletePerusahaan() {
         if (checkIdInputPerusahaan()) {
            try {
                Connection con = db.getConnection();
                String DeleteQuery = "DELETE FROM Perusahaan where id = ?";
                PreparedStatement ps = null;
                ps = con.prepareStatement(DeleteQuery);

                ps.setInt(1, Integer.parseInt(view.getTxtIdPerusahaan().getText()));
                ps.executeUpdate();
                
                view.show_perusahaanlist_in_table(getPerusahaanList());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Perusahaan id: " + view.getTxtIdPerusahaan().getText() + " not deleted");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please input the Perusahaan id");
        }
    }
//    ------------------------ END PERUSAHAAN ------------------------
//    ----------------------- LOWONGAN ------------------------------
    
    public boolean checkInputLowongan() {
        return !("".equals(view.getTxtNamaLowongan().getText()) || "".equals(view.getTxtJumlahLowongan().getText()) || "".equals(view.getTxtIdPerusahaanLowongan().getText()));
    }

    public boolean checkIdInputLowongan() {
        return !"".equals(view.getTxtIdLowongan().getText());
    }
    private void insertLowongan() {
        if (checkInputLowongan()) {
            try {
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO Lowongan(Nama, jumlah_lowongan, idperusahaan) values (?,?,?)");
                ps.setString(1, view.getTxtNamaLowongan().getText());
                ps.setString(2, view.getTxtJumlahLowongan().getText());
                ps.setString(3, view.getTxtIdPerusahaanLowongan().getText());
                System.out.println(ps);
                ps.executeUpdate();
                Perusahaan p = getPerusahaan(view.getTxtIdPerusahaanLowongan().getText());
                view.show_lowonganlist(p);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Perusahaan tidak ditemukan!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or More fields are Empty!");
        }
    }
    private void updateLowongan() {
        if (checkInputLowongan()&& checkIdInputLowongan()) {
            String UpdateQuery = null;
            PreparedStatement ps = null;
            Connection con = db.getConnection();

            UpdateQuery = "UPDATE Lowongan SET nama = ?, jumlah_lowongan = ?, idperusahaan = ? where id = ?";
            try {
                ps = con.prepareStatement(UpdateQuery);

                ps.setString(1, view.getTxtNamaLowongan().getText());
                ps.setString(2, view.getTxtJumlahLowongan().getText());
                ps.setString(3, view.getTxtIdPerusahaanLowongan().getText());
                ps.setInt(4, Integer.parseInt(view.getTxtIdLowongan().getText()));

                ps.executeUpdate();

                view.show_perusahaanlist_in_table(getPerusahaanList());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please fill in all of the fields");
        }
    }

    private void deleteLowongan() {
         if (checkIdInputLowongan()) {
            try {
                Connection con = db.getConnection();
                String DeleteQuery = "DELETE FROM Lowongan where id = ?";
                PreparedStatement ps = null;
                ps = con.prepareStatement(DeleteQuery);

                ps.setInt(1, Integer.parseInt(view.getTxtIdLowongan().getText()));
                ps.executeUpdate();
                
                view.show_perusahaanlist_in_lowongan();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Lowongan id: " + view.getTxtIdLowongan().getText() + " not deleted");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select the Lowongan row");
        }
    }
//    ------------------------ END LOWONGAN ---------------------------------
    

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
//        JOptionPane.showMessageDialog(null, source);
        if (source.equals(view.getBtnInsertPelamar())){
            insertPelamar();
        } else if (source.equals(view.getBtnUpdatePelamar())){
            updatePelamar();
//            view.getBtnUpdatePelamar().setVisible(true);
        } else if (source.equals(view.getBtnDeletePelamar())){
            deletePelamar();
        } else if (source.equals(view.getBtnInsertPerusahaan())){
            insertPerusahaan();
        } else if (source.equals(view.getBtnUpdatePerusahaan())){
            updatePerusahaan();
        } else if (source.equals(view.getBtnDeletePerusahaan())){
            deletePerusahaan();
        } else if (source.equals(view.getBtnInsertLowongan())){
            insertLowongan();
        } else if (source.equals(view.getBtnUpdateLowongan())){
            updateLowongan();
        } else if (source.equals(view.getBtnDeleteLowongan())){
            deleteLowongan();
        } 
    }

    
}
