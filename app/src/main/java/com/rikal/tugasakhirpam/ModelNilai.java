package com.rikal.tugasakhirpam;

public class ModelNilai {
    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ModelNilai(String nilai, String key) {
        this.nilai = nilai;
        this.key = key;
    }

    private String nilai;
    private String key;
}
