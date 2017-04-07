/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;
/**/

/**
 *
 * @author Yulizar
 */
public class Berkas_lamaran {
    private Perusahaan perusahaan_dituju;
    private String bagian;
    private Pelamar pelamar;
    
    public Berkas_lamaran(Pelamar pelamar,Perusahaan P, String bagian) {
        this.pelamar = pelamar;
        perusahaan_dituju = P;
        this.bagian = bagian;
    }

    public Perusahaan getPerusahaan_dituju() {
        return perusahaan_dituju;
    }

    public void setPerusahaan_dituju(Perusahaan perusahaan_dituju) {
        this.perusahaan_dituju = perusahaan_dituju;
    }

    public String getBagian() {
        return bagian;
    }

    public void setBagian(String bagian) {
        this.bagian = bagian;
    }

    public Pelamar getPelamar() {
        return pelamar;
    }

    public void setPelamar(Pelamar pelamar) {
        this.pelamar = pelamar;
    }
    
}
