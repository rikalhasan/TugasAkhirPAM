package com.rikal.tugasakhirpam;

public class ModelPengguna {
    private String nama;
    private String kelas;
    private String key;


    public ModelPengguna(){

    }

    public ModelPengguna(String nama, String kelas) {
        this.nama = nama;
        this.kelas = kelas;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
