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
    private String nama;
    private ArrayList<Berkas_Lamaran> berkasMasuk = new ArrayList<>();
    private ArrayList<Berkas_Lamaran> berkasDiterima = new ArrayList<>();
    
    public Lowongan(String nama){
        this.nama=nama;
    }
    
    public void addBerkas(Berkas_Lamaran berkas){
        berkasMasuk.add(berkas);
    }
    public void terimaBerkas (Berkas_Lamaran berkas){
        berkasDiterima.add(berkas);
    }
    public String getNama(){
        return nama;
    }
    public String getId(){
        return id;
    }
    public ArrayList<Berkas_Lamaran> getBerkasMasuk(){
        return berkasMasuk;
    }
    public ArrayList<Berkas_Lamaran> getBerkasDiterima(){
        return berkasDiterima;
    }
    
}
