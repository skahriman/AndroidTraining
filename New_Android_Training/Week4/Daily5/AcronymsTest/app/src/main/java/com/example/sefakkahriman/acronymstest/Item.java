package com.example.sefakkahriman.acronymstest;

public class Item {

    int freq;
    String lf;

    public Item(int freq, String lf) {
        this.freq = freq;
        this.lf = lf;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public String getLf() {
        return lf;
    }

    public void setLf(String lf) {
        this.lf = lf;
    }

    @Override
    public String toString() {
        return "Item{" +
                "freq=" + freq +
                ", lf='" + lf + '\'' +
                '}';
    }
}
