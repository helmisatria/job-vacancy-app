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
public abstract class Orang {
    private String nama;
    private static int id;

    public Orang(String nama) {
        this.nama = nama;
        id++;
    }

    public String getNama() {
        return nama;
    }

    public static int getId() {
        return id;
    }
    
}
