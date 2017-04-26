/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author KNF
 */
public class Pelamar extends Orang {
    private String alamat;
    private String email;
    private String no_hp;
    private Berkas_Lamaran berkas;

    public Pelamar(String nama) {
        super(nama);
    }
//    
    public Pelamar(String nama, String alamat, String email, String no_hp) {
        super(nama);
        this.alamat=alamat;
        this.email=email;
        this.no_hp=no_hp; 
    }

   public void createBerkas(Pelamar pelamar, Perusahaan p, String bagian){
       int found=p.find(p.getDaftarLowongan(),bagian);
       
       if (found==-1){
           System.out.println(bagian +" Not Found!");
           
       }else{
           berkas=new Berkas_Lamaran(pelamar, p, bagian);
           p.getDaftarLowongan().get(0).addBerkas(berkas);
       }
   }
    public void setBerkas(Berkas_Lamaran berkas){
        this.berkas=berkas;
    }
    public void setAlamat(String alamat){
        this.alamat=alamat;
    }
    public void setNo_hp(String no_hp){
        this.no_hp=no_hp;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public Berkas_Lamaran getBerkas(){
        return berkas;
    }
    public String getAlamat(){
        return alamat;
    }
    public String getNo_hp(){
        return no_hp;
    }
     public String getEmail(){
        return email;
    }
}
//    void createBerkas(Pelamar pelamar1, Perusahaan p1, String developer) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    void createBerkas(Pelamar pelamar1, Perusahaan p1, String developer) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
