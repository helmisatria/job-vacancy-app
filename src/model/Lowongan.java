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
   private String nama;
    private ArrayList<Berkas_Lamaran> berkasMasuk = new ArrayList<>();
    private ArrayList<Berkas_Lamaran> berkasDiterima = new ArrayList<>();
    private static int id=1;
    
    public Lowongan(String nama){
        this.nama=nama;
        id++;
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
    public static int getId(){
        return id;
    }
    public ArrayList<Berkas_Lamaran> getBerkasMasuk(){
        return berkasMasuk;
    }
    public ArrayList<Berkas_Lamaran> getBerkasDiterima(){
        return berkasDiterima;
    }
    
}
