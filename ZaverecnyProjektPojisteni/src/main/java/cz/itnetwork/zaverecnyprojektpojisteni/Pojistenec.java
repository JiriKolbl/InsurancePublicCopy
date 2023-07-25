/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.zaverecnyprojektpojisteni;

/**
 * Základní třída pojištěnce
 * @author Kolbl
 */
public class Pojistenec {
    
    /*
    Atributy pojištěnce
    */
    private String telefoniCislo;
    private String jmeno;
    private String prijmeni;
    private int vek;
    
    /*
    Konstruktor pojištěnce
    */
    public Pojistenec(String krestniJmeno, String prijmeni, int vek, String telefoniCislo) {
        this.jmeno = krestniJmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefoniCislo = telefoniCislo;
    }
    
    /*
    Stringový výpiš pojištěnce
    */
    @Override
    public String toString() {
        return String.format("%s   %s   %d   %s", jmeno, prijmeni, vek, telefoniCislo);
    }
    
    /*
    Gettery atributů pojištěnce
    */
    public String getTelefoniCislo() {
        return telefoniCislo;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getVek() {
        return vek;
    }
    
    
}