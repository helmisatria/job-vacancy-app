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
    private int id;
    private String nama;
    
    public Orang(String id, String nama){
        this.nama=nama;
        this.id = Integer.parseInt(id);
    }
    public Orang(String nama){
        this.nama=nama;
    }
    
    public String getNama(){
        return nama;
    }
    public int getId(){
        return id;
    }
    
}
