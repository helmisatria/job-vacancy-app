/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;

/**
 *
 * @author Yulizar
 */
public class Perusahaan extends Orang{
    
    private String lokasi;
    private static int jmlPelamar;
    private static int jmlLowongan;
    private ArrayList<Lowongan> daftarLowongan = new ArrayList<>();
    
    public Perusahaan(String nama, String lokasi) {
        super(nama);
        this.lokasi = lokasi;
        daftarLowongan = new ArrayList<>();
    }
    
    public void createLowongan(String nama){
        jmlLowongan++;
        daftarLowongan.add(new Lowongan(nama));
    }

    public String getLokasi() {
        return lokasi;
    }

    public int getJmlLowongan() {
        return jmlLowongan;
    }

    public ArrayList<Lowongan> getDaftarLowongan() {
        return daftarLowongan;
    }
    
    public int find( ArrayList<Lowongan> a, String target){
        int found = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getNama().equals(target)){
                found = i;
                break;
            }
        }
        return found;
    }
    public void printAllPelamar(){
        for (Lowongan x : daftarLowongan) {
            for (Berkas_lamaran y : x.getBerkasMasuk()){
                System.out.println(y.getPelamar().getNama());
            }
        }
    }
}
