package symulacjaskrzyzowania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Klasa odpowiadająca za uzupełnienie obiektu skrzyżowania o kolejne obiekty od niego zależne.
 */
public class Skrzyzowanie {
    private List<Droga> drogi;
    private static List<Sciezka> sciezki;
    private static List<PunktKolizji> punktyKolizji;

    /**
     * Konstruktor skrzyżowania
     * @param drogi Lista dróg przypisana do skrzyżowania
     * @param sciezki Lista ścieżek przypisana do skrzyzowania
     * @param punktyKolizji Lista punktów kolzji w danym skrzyżowaniu
     */
    Skrzyzowanie(List<Droga> drogi, List<Sciezka> sciezki, List<PunktKolizji> punktyKolizji) {
        this.drogi = drogi;
        this.sciezki = sciezki;
        this.punktyKolizji = punktyKolizji;
    }

    /**
     * Funkcja umożliwiająca wczytanie pliku odpowiadającego za wczytanie skrzyżowania i nadająca funkcję dodającą drogi do niego
     */
    public void nwm() throws FileNotFoundException { // wczytanie pliku
        File skrzyz = new File("skrzyzowanie.txt");
        /* wczytany plik składa się z segmentów, z których odczytuje dane dla drogi i slotów:
         * drogi - numer (na chwilę obecną w celach testowych, docelowo bez), pozycja w osi x, pozycja w osi y, obrót
         * sloty - numer (na chwilę obecną w celach testowych, docelowo bez), rodzaj transportu (samochod, transport zbiorowy), kierunek (1 wejście, 2 wyjście) */
        Scanner in = new Scanner(skrzyz);
        dodanie_drog(in);
    }

    /**
     * Funkcja służy do wczytania z pliku tekstowego dróg przypisanych do danego skrzyżowania.
     * @param in Obiekt klasy Scanner wczytujący unikalne wartości danych dróg
     */
    public void dodanie_drog(Scanner in) {
        if (in.nextLine().equals("[skrzyzowanie]")) {
            in.nextLine();
            for (int left = 0; left == 0; ) {
                if (in.hasNext()) {
                    if (in.nextLine().equals("[droga]")) {
                        List<Slot> slots = new ArrayList<Slot>();
                        Droga drogs = new Droga(in.nextInt(), in.nextInt() * 10, in.nextInt() * 10, in.nextInt(), slots);
                        Droga.dodanie_slot(in, slots);
                        drogi.add(drogs);
                    } else {
                        left++;
                        System.out.println("tak");
                    }
                } else {
                    break;
                }
            }
        }
    }

    /**
     * Funkcja umożliwia uzyskanie z drogi określonego parametru
     * @param droga Numer drogi
     * @param pole Numer parametru
     * @return Wartość parametru
     */
    public int getDrogi(int droga, int pole) {
        if (pole == 0) {
            return drogi.get(droga).getId();
        }
        if (pole == 1) {
            return drogi.get(droga).getPozx();
        }
        if (pole == 2) {
            return drogi.get(droga).getPozy();
        }
        if (pole == 3) {
            return drogi.get(droga).getRotate();
        }
        return 0;
    }

    /**
     * Funkcja umożliwia wczytanie ścieżki
     * @param sciezka Numer ścieżki
     * @return Wczytana ścieżka o zadanym numerze
     */
    public static int[][] getSciezka(int sciezka) {
        return sciezki.get(sciezka).getSciezka();
    }

    /**
     * Funkcja umożlwiająca odczytanie parametru w podanej pozycji określonego slotu
     * @param droga Numer drogi
     * @param slot Numer slotu
     * @param pole Numer pola
     * @return Wartość pola nadanego dla slotu dla danej drogi
     */
    public int getSloty(int droga, int slot, int pole) {
        return drogi.get(droga).getSloty(slot, pole);
    }
}
