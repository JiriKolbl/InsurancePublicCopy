/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.zaverecnyprojektpojisteni;

import java.util.HashMap;
import java.util.Map;

/**
 * Ukládání do HashMapy jsem zvolil proto, že vyhledávání v ní je podle klíče a proto jednoduší a možná i rychlejší, avšak vím, že vzhledem k tomu,
 * že tímto způsobem do ní již nemám možnost ukládat více stejnojmenných osob. Bohužel již nemám dostatek času toto rozhodnutí změnit a zároveň
 * si myslím, že v reálu se nebude v takovémto programu vyhledávat podle jména a příjmení, ale spíše podle rodného čísla, nebo čísla Občasnkého
 * průkazu a za takových okolností může (zřejmě) HashMapa být dobrou volbou.
 * @author Kolbl
 */
public class DatabazePojistenych {
    Map<String, Pojistenec> pojistenci = new HashMap<>();
    
    /*
    Metoda uloží vytvořeného pojištěnce do množiny (switch volba č. 1)
    */
    public void pridejPojistence(Pojistenec pojistenec) {
        pojistenci.put(pojistenec.getJmeno() + pojistenec.getPrijmeni(), pojistenec);
    }
    
    /*
    Metoda pro výpis všech pojištěnců vyvolávaná v metodě program ve switch (volba č. "2")
    */
    public String vypisVsechnyPojistence() {
        String vypis = "";
        //Cyklus projde všechny pojištěnce a vypíše je na nový řádek.
        for (Pojistenec poj : pojistenci.values()) {
            vypis += poj + ("\n");
        }
        return vypis;
    }
    
    /*
    Metoda vrátí pojištěnce podle klíče (switch volba č. 3)
    */
    public Pojistenec getDanehoPojistence(String jmeno, String prijmeni) {
        return pojistenci.get(jmeno + prijmeni);
    }
    
    /*
    Metoda zkontroluje jestli se podařilo pojištěnce uložit, tedy jestli se v množině nachází (switch volba č. 1)
    */
    public String kontrolaUlozeniPojistence(Pojistenec pojistenec) {
        String odpovedUlozeni = "";
        
        /*
        Podmínka kontroluje jestli se podařilo pojištence uložit tím, že zkontroluje jestli množina obsahuje právě ukládaného pojištěnce
        */
        
        if (pojistenci.containsKey(pojistenec.getJmeno() + pojistenec.getPrijmeni()) && pojistenci.get(pojistenec.getJmeno() + pojistenec.getPrijmeni()).equals(pojistenec)) {
            odpovedUlozeni = "Data byla uložena...";
        } else {
            odpovedUlozeni = "Data se nepodařilo uložit...";
        }
        
        return odpovedUlozeni;
    }
}
