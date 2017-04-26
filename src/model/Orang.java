/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author KNF
 */
public abstract class Orang {
    private static int id;
    private  String nama;
    
    public Orang(String nama){
        this.nama=nama;
        id++;
    }
    public String getNama(){
        return nama;
    }
    public static int getId(){
        return id;
    }
    
}
