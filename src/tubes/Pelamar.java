/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author Yulizar
 */
public class Pelamar extends Orang{
    
    private Berkas_lamaran berkas;
    private String alamat;
    private String no_hp;
    
    public Pelamar(String nama, String alamat, String no_hp) {
        super(nama);
        this.alamat = alamat;
        this.no_hp = no_hp;
    }
    public void createBerkas(Pelamar pelamar, Perusahaan P, String bagian){
        int found = P.find(P.getDaftarLowongan(), bagian);
        
        if (found == -1) {
            System.out.println(bagian + " Not found!");
        } else {
            berkas = new Berkas_lamaran(pelamar, P, bagian);
            P.getDaftarLowongan().get(0).addBerkas(berkas);
        }
    }
    public void setBerkas(Berkas_lamaran berkas) {
        this.berkas = berkas;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public Berkas_lamaran getBerkas() {
        return berkas;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNo_hp() {
        return no_hp;
    }
    
    
}
