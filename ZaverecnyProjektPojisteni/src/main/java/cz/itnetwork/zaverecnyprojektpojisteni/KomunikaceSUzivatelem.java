/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.zaverecnyprojektpojisteni;

import java.util.Scanner;

/**
 * Třída převážně statických pomocných metod a metody pro vytvoření pojištěnce
 * Třída slouží pro metody, které jsou určeny pro komunikaci s uživatelem přes konzoli a zároveň kontrolu zadaných hodnot
 * @author Kolbl
 */
public class KomunikaceSUzivatelem {
    private static Scanner scanner = new Scanner(System.in, "Windows-1250");
    
    /*
    Metoda pro zadání číselné vobly do switch
    Je stavěná univerzálně pro použití ve více (různě dlouhých) switch stavbách
    Obsahuje kontroly pro správnost zadání
    */
    public static String zadejVolbuProgramu(int pocetMoznosti) {
        String volba = "";
        boolean jeVolbaPlatna = false;
        do {
            volba = scanner.nextLine().trim();
        
            // Kontrola platnosti volby
            int cisloVolby;
            try {
                cisloVolby = Integer.parseInt(volba);
                if (cisloVolby >= 1 && cisloVolby <= pocetMoznosti) {
                    jeVolbaPlatna = true;
                } else {
                    System.out.println("Zadal jste neplatnou volbu, zadejte ji prosím znovu: ");
                    jeVolbaPlatna = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Zadal jste neplatnou volbu, zadejte ji prosím znovu: ");
                jeVolbaPlatna = false;
            }
        } while(!jeVolbaPlatna);
    
        return volba;
    }
    
    /*
    Metoda pro zadání jména, které následně vrací
    */
    public static String zadejJmeno() {
        boolean obsahujeJenPismena = false;
        String jmeno = "";
        
        do {
        System.out.println("Zadejte křestní jméno pojištěného: ");
        jmeno = scanner.nextLine().trim().toLowerCase();
        jmeno = upravJmeno(jmeno);
        obsahujeJenPismena = jeJenZPismen(jmeno);
        } while (!obsahujeJenPismena);
        return jmeno;
    }
    
    /*
    Metoda pro zadání příjmení, které následně vrací
    */
    public static String zadejPrijmeni() {
        boolean obsahujeJenPismena = false;
        String prijmeni = "";
        
        do {
        System.out.println("Zadejte příjmení pojištěného: ");
        prijmeni = scanner.nextLine().trim().toLowerCase();
        prijmeni = upravJmeno(prijmeni);
        obsahujeJenPismena = jeJenZPismen(prijmeni);
        } while (!obsahujeJenPismena);
        return prijmeni;           
    }
    
    /*
    Metoda vyzve uživatele k zadání věku a zkontroluje jestli neobsahuje jiné znaky než čísla
    */
    public static int zadejVek() {
        boolean jeVekSpravne;
        int vek = 0;
        do {
            System.out.println("Zadejte věk pojištěného: ");
            String zadanyVek = scanner.nextLine().trim();
            try {
                vek = Integer.parseInt(zadanyVek);
                jeVekSpravne = true;
            } catch (NumberFormatException e) {
                System.out.println("Vámi zadaný věk obsahuje nepovolené znaky. Zadejte pouze s čísly!");
                jeVekSpravne = false;
            }
            //kontrola délky hodnoty věku (žádný člověk nemůže mít věk dělší než tři znaky
            if (zadanyVek.length() > 3) {
                System.out.println("Vámi zadaný věk je příliž dlouhý!");
                jeVekSpravne = false;
            }
        } while (!jeVekSpravne);
        
        return vek;
    }
    
    /*
    Pomocná metoda zadejTelefonniCislo. Nechá uživatele zadat tel. číslo pro vytvoření pojištěnce a zároveň ověří i jestli je 
    tel. číslo správného formátu
    */
    public static String zadejTelefonniCislo() {
        /*
        pomocné proměnné pro zadání telefoního čísla.
        */
        boolean jeTelPlatny = false;
        String zadaneTelCislo;
        String telefonniCislo = "";  
        int kontrolaCisla = 0;
        /*
        Uživatel v cyklu zadá telefoní číslo pojištěnce.
        Cyklus kontroly, jestli je telefonní číslo opravdu z čísel a také jestli je správně dlouhé.
        */
        do {
            System.out.println("Zadejte telefoní číslo pojištěného bez předvolby a bez mezer: ");
            zadaneTelCislo = scanner.nextLine();
            //Pokud uživatel zadal tel. i s předvolbou
            if (zadaneTelCislo.startsWith("+420")) {
                telefonniCislo = zadaneTelCislo.substring(4); // Odstranění předvolby "+420" a vložení správného formátu čísla do proměnné upravenyTel
            } else {
                telefonniCislo = zadaneTelCislo;
            }
            
            try{
                //Pokud je telefonní číslo celé složené z čísel cyklus skončí a hodnota se uloží
                kontrolaCisla = Integer.parseInt(telefonniCislo.trim());
                jeTelPlatny = true;
            } catch (NumberFormatException e) {
                //pokud se v telefonním čísle nachází jiný znak než číslo změní boolean na false a cyklus pokračuje znovu
                System.out.println("Zadané telefoní číslo není celé složeno z čísel!");
                jeTelPlatny = false;
            }  
                //pokud uživatel zadal nekompletní nebo příliž douhé tel. číslo
            if (telefonniCislo.length() != 9) {
                System.out.println("Vámi zadané telefoní číslo je přílíž dlouhé nebo příliž krátké a nebo jste použili mezery!\n");
                //změní boolean na false a cyklus běží znovu
                jeTelPlatny = false;
            }
        
        } while (!jeTelPlatny);
        //vrací string
        return telefonniCislo;
    }
    
    /*
    Metoda upraví jméno zadané uživatelem do formátu např. Jiří (první písmeno velké, zbytek malý)
    */
    private static String upravJmeno(String text) {
        String upraveneJmeno = text.substring(0, 1).toUpperCase() + text.substring(1);
        return upraveneJmeno;
    }
    
    /*
    Metoda zkontroluje jestli se jméno skládá pouze z písmen
    */
    private static boolean jeJenZPismen(String text) {
        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c)) {
                System.out.println("Váš text obsahuje nepovolené znaky!");
                return false;
            }
        } return true;
    } 
    
    /*
    Metoda pouze pro konzolovou aplikaci aby si uživatel mohu odkliknout, že chce pokračovat, když je k tomu připraven
    */
    public static void pokracujteKlavesou() {
        System.out.println("Pokračujte libovolnou klávesou...");
        scanner.nextLine();
    }
    
    /*
    Metoda pro výpis struktury menu, které se vypíše před každou akcí
    */
    public static void vypisMenu() {
        System.out.println("---------------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("---------------------------------------------\n");
        
        System.out.println("Vyberte si akci: \n"
                            + "1 - Přidat nového pojištěného\n"
                            + "2 - Vypsat všechny pojištěné\n"
                            + "3 - Vyhledat pojištěného\n"
                            + "4 - Konec");
    }
    
    /*
    Metoda vytvoří pojištěnce, kde jako parametry bere vstupní hodnoty ze kterých se pojištěnec skládá, pojištěnce následně vrací
    */
    public Pojistenec vytvorPojistence(String jmeno, String prijmeni, int vek, String telCislo) {
        Pojistenec pojistenec = new Pojistenec(jmeno, prijmeni, vek, telCislo);
        return pojistenec;
    }
}
