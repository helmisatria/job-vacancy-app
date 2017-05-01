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
public class Pelamar extends Orang {
    private String alamat;
    private String email;
    private String no_hp;
//    
    public Pelamar(String id, String nama, String alamat, String email, String no_hp) {
        super(id, nama);
        this.alamat=alamat;
        this.email=email;
        this.no_hp=no_hp;
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
