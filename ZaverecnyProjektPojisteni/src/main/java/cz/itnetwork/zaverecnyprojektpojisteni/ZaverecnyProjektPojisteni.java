/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cz.itnetwork.zaverecnyprojektpojisteni;

import static cz.itnetwork.zaverecnyprojektpojisteni.KomunikaceSUzivatelem.zadejJmeno;
import static cz.itnetwork.zaverecnyprojektpojisteni.KomunikaceSUzivatelem.zadejPrijmeni;
import static cz.itnetwork.zaverecnyprojektpojisteni.KomunikaceSUzivatelem.zadejTelefonniCislo;
import static cz.itnetwork.zaverecnyprojektpojisteni.KomunikaceSUzivatelem.zadejVek;

/**
 * Tento projekt byl vytvořen v rámci kurzu Java Basics, a proto nemusí obsahovat veškeré funkčnosti v souladu s best practices.
 * Jakožto autor rozumím tomu, že tento program obsahuje některé věci (prevážně kontroly), které v realné praxi nepoužiji, např. formátu čísla
 * nebo jména. Tento program avšak slouží převážně k prezentaci toho, co dokáži a proto jsem do něm zaimplementoval některé metody navíc, abych měl 
 * co ukázat, převážně z toho důvodu, že z časových důvodů již nestihnu dokončit pokročilý závěrečný projekt.
 * 
 * @author Kolbl
 */
public class ZaverecnyProjektPojisteni {

    public static void main(String[] args) {
        /*
        Instance tříd.
        Instance třídy KomunikaceSUzivatelem je tu proto, že se v ní nachází jedna nestatická metoda pro vytvoření pojištěnce.
        */
        Pojistenec pojistenec;
        KomunikaceSUzivatelem komunikace = new KomunikaceSUzivatelem();
        DatabazePojistenych databaze = new DatabazePojistenych();
        
        /*
        Cyklus ovládající kontrukci switch
        */
        String volba;
        do {
            //Výpis možností (menu)
            KomunikaceSUzivatelem.vypisMenu();
            //Vyvolání metody pro zadání volby programu
            volba = KomunikaceSUzivatelem.zadejVolbuProgramu(4);
            System.out.println();
            
            String jmeno = "";
            String prijmeni = "";
            int vek = 0;
            String telCislo = "";
            
            //Následně program přiřadí volbu k možnosti ze switch          
            switch (volba) {
                case "1":
                    //Vyzve k zadání jména
                    jmeno = zadejJmeno();
                    //Vyzve k zadání příjmení
                    prijmeni = zadejPrijmeni();
                    //Vyzve k zadání věku
                    vek = zadejVek();
                    //Vyzve k zadání tel. čísla
                    telCislo = zadejTelefonniCislo();
                    //Vytvoření nového pojištěnce
                    pojistenec = komunikace.vytvorPojistence(jmeno, prijmeni, vek, telCislo);
                    //přidá vytvořeného pojistěnce do množiny
                    databaze.pridejPojistence(pojistenec);
                    //Zkontroluje jestli se pojištěnec opravdu vložil do množiny a výsledek vypíše
                    System.out.println("\n" + databaze.kontrolaUlozeniPojistence(pojistenec));
                    KomunikaceSUzivatelem.pokracujteKlavesou();
                    break;
                case "2":
                    //Vypíše všechny pojištěnce v množině
                    System.out.println(databaze.vypisVsechnyPojistence());
                    KomunikaceSUzivatelem.pokracujteKlavesou();
                    break;
                case "3":
                    //Vyzve k zadání jména
                    jmeno = zadejJmeno();
                    //Vyzve k zadání příjmení
                    prijmeni = zadejPrijmeni();
                    //vypíše pojištěnce, který se nachází pod danným klíčem
                    System.out.println("\n" + databaze.getDanehoPojistence(jmeno, prijmeni) + "\n");
                    KomunikaceSUzivatelem.pokracujteKlavesou();
                    break;
                case "4":
                    volba = "konec";
            }
        //Volba čtyři ukončí program
        } while(!volba.equals("konec"));
    }
}
