# job-vacancy-app
Job Vacancy Application for PBO Assignment using Java

Pelamar {
  alamat, email, nohp : string,
  berkas : Berkas_Lamaran
}

Perusahaan {
  lokasi : String,
  jmlPelamar, jmlLowongan : int,
  daftarLowongan[]: Lowongan
}

Berkas_Lamaran : {
  perusahaan_dituju : Perusahaan,
  bagian : String,
  pelamar : Pelamar
}
