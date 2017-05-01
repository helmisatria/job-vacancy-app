/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.ArrayList;
/**
 *
 * @author KNF
 */
public class Perusahaan extends Orang{
    
    private String lokasi;
    private static int jmlPelamar;
    private Lowongan lowongan;
    private ArrayList<Lowongan> daftarLowongan = new ArrayList<>();     

    public Perusahaan(String id, String nama, String lokasi) {
        super(id, nama);
        this.lokasi = lokasi;
        daftarLowongan = new ArrayList<>(); 
    }
    public String getLokasi(){
        return lokasi;
    }
    public ArrayList<Lowongan> getDaftarLowongan(){
        return daftarLowongan;
    }
//    public void addLowongan(String namaBagian){
//        lowongan = new Lowongan(namaBagian);
//        daftarLowongan.add(lowongan);
//    }
      
}
