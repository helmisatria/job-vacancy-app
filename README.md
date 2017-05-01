# job-vacancy-app
Job Vacancy Application for PBO Assignment using Java

db:

Pelamar{
  id int NOT NULL UNIQUE,
  alamat, email, nohp : String,
  berkas : String
}


Berkas_Lamaran : {
  perusahaan_dituju : Perusahaan,
  bagian : String,
  pelamar : Pelamar
}

..........................

Pelamar {
  alamat, email, nohp : string,
  berkas : Berkas_Lamaran
}

Berkas_Lamaran : {
  perusahaan_dituju : Perusahaan,
  bagian : String,
  pelamar : Pelamar
}

Perusahaan {
  lokasi : String,
  jmlPelamar, jmlLowongan : int,
  daftarLowongan[]: Lowongan
}
