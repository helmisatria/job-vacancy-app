/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author KNF
 */
public class Berkas_Lamaran {
    private Perusahaan perusahaan_dituju;
    private String bagian;
    private Pelamar pelamar;
    
    public Berkas_Lamaran(Pelamar pelamar, Perusahaan p, String bagian){
        this.pelamar=pelamar;
        perusahaan_dituju = p;
        this.bagian= bagian;
    }
    
    public Perusahaan getPerusahaan_dituju(){
        return perusahaan_dituju;
    }
    public void setPerusahaan_dituju(Perusahaan perusahaan_dituju){
        this.perusahaan_dituju=perusahaan_dituju;
    }
    public void setBagian(String bagian){
        this.bagian=bagian;
    }
    public void setPelamar(Pelamar pelamar){
        this.pelamar=pelamar;
    }
    public String getBagian(){
        return bagian;
    }
    public Pelamar getPelamar(){
        return pelamar;
    }
    
}
