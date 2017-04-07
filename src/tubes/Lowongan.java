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
public class Lowongan {
    private String nama;
    private ArrayList<Berkas_lamaran> berkasMasuk = new ArrayList<>();
    private ArrayList<Berkas_lamaran> berkasDiterima = new ArrayList<>();
    private static int id = 1;

    public Lowongan(String nama) {
        this.nama = nama;
        id++;
    }
    public void addBerkas(Berkas_lamaran berkas){
        berkasMasuk.add(berkas);
    }
    
    public void terimaBerkas(Berkas_lamaran berkas){
        berkasDiterima.add(berkas);
    }

    public String getNama() {
        return nama;
    }

    public ArrayList<Berkas_lamaran> getBerkasMasuk() {
        return berkasMasuk;
    }

    public ArrayList<Berkas_lamaran> getBerkasDiterima() {
        return berkasDiterima;
    }

    public static int getId() {
        return id;
    }
    
}
