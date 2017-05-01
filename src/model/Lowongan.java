/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.*;
/**
 *
 * @author KNF
 */
public class Lowongan {
    private String id;
    private String idPerusahaan;
    private String nama;
    private int jumlahLowongan;
    
    public Lowongan(String id, String nama, int jumlahLowongan, String idPerusahaan){
        this.id = id;
        this.nama=nama;
        this.jumlahLowongan = jumlahLowongan;
        this.idPerusahaan = idPerusahaan;
    }
    
    public String getNama(){
        return nama;
    }
    public String getId(){
        return id;
    }
    public int getJumlahLowongan(){
        return jumlahLowongan;
    }
        public String getIdPerusahaan(){
        return idPerusahaan;
    }
    
}
