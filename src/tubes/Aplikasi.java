/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author BASISDATA
 */
public class Aplikasi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Perusahaan p1 = new Perusahaan("Suka Maju", "Yogyakarta");
        p1.createLowongan("Developer");
        p1.createLowongan("CEO");
        
        System.out.println("Hasil cari bagian: " + "Developer" + " adalah : " + p1.find(p1.getDaftarLowongan(), "Developer"));
        System.out.println("Hasil cari bagian: " + "CEO" + " adalah : " + p1.find(p1.getDaftarLowongan(), "CEO"));
        System.out.println("---");
        
        Pelamar pelamar1 = new Pelamar("Helmi", "Condong Catur", "085799977788");
        Pelamar pelamar2 = new Pelamar("Kartini Nurfalah", "Cilacap", "085789123456");
        
        pelamar1.createBerkas(pelamar1, p1, "Developer");
        pelamar2.createBerkas(pelamar2, p1, "Developer");
        
        System.out.println("Berkas pelamar : " + pelamar1.getBerkas().getBagian());
        System.out.println("Jumlah lowongan ada : " + p1.getJmlLowongan() + " bagian");
        System.out.println("Nama perusahaan: " + p1.getNama());
        System.out.println("Pelamar 1 : " + pelamar1.getNama());
        System.out.println("  - Submit di : " + pelamar1.getBerkas().getPerusahaan_dituju().getNama());
        System.out.println("--------");
        
        System.out.println(p1.getDaftarLowongan().get(0).getBerkasMasuk().get(0).getPelamar().getNama());
        System.out.println("---");
        
        System.out.println("Pelamar yang terdaftar di Perusahaan : " + p1.getNama());
        p1.printAllPelamar();
    }
    
}
