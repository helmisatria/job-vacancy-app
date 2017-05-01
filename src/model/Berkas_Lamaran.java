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
    private String idPerusahaan;
    private String bagian;
    private String idPelamar;
    
    public Berkas_Lamaran(String idPelamar, String bagian, String idPerusahaan){
        this.idPelamar = idPelamar;
        this.idPerusahaan = idPerusahaan;
        this.bagian= bagian;
    }

    public String getIdPerusahaan() {
        return idPerusahaan;
    }

    public String getBagian() {
        return bagian;
    }

    public String getIdPelamar() {
        return idPelamar;
    }
    
}
