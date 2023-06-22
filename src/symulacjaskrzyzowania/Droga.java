package symulacjaskrzyzowania;

import java.util.List;
import java.util.Scanner;

/**
 * Klasa odpowiada za stworzenie drogi przypisanej do skrzyżowania
 */
public class Droga {
    private int id;
    private int pozx;
    private int pozy;
    private int rotate;
    private List<Slot> sloty;

    /**
     * Konstruktor drogi
     * @param id Numer drogi
     * @param pozx Pozycja w osi x
     * @param pozy Pozycja w osi y
     * @param rotate Obrót drogi
     * @param sloty Lista slotów przypisanych do drogi
     */
    Droga(int id, int pozx, int pozy, int rotate, List<Slot> sloty) {
        this.id = id;
        this.pozx = pozx;
        this.pozy = pozy;
        this.rotate = rotate;
        this.sloty = sloty;
    }

    /**
     * Funkcja służy do wczytania z pliku tekstowego slotów przypisanych do danej drogi.
     * @param in Obiekt klasy Scanner wczytujący unikalne wartości danych slotów
     * @param sloty Lista slotów przypisanych do danej drogi (wlotu skrzyżowania)
     */
    public static void dodanie_slot(Scanner in, List<Slot> sloty) {
        for (int left = 0; left == 0; ) {
            if (in.hasNext()) {
                in.nextLine();
                in.nextLine();
            } else {
                break;
            }
            if (in.hasNext() && in.nextLine().equals("[slot]")) {

                Slot slot = new Slot(in.nextInt(), in.nextInt(), in.nextInt());
                sloty.add(slot);
            } else {
                left++;
            }
        }
    }

    /**
     * Funkcja zwraca numer drogi
     * @return Numer drogi
     */
    public int getId() {
        return id;
    }

    /**
     * Funkcja zwraca pozycję drogi w osi x
     * @return Pozycja w osi x
     */
    public int getPozx() {
        return pozx;
    }
    /**
     * Funkcja zwraca pozycję drogi w osi y
     * @return Pozycja w osi y
     */
    public int getPozy() {
        return pozy;
    }
    /**
     * Funkcja zwraca obrót drogi
     * @return Obrót drogi
     */
    public int getRotate() {
        return rotate;
    }

    /**
     * Funkcja zwraca parametr przypisany do wybranego slotu dla dlogi.
     * @param slot Numer slotu
     * @param pole Pole w liście slotu
     * @return Wartość pola w liście slotu
     */
    public int getSloty(int slot, int pole) {
        if (pole == 0) {
            return sloty.get(slot).getSlotId();
        }
        if (pole == 1) {
            return sloty.get(slot).getSlotRodzaj();
        }
        if (pole == 2) {
            return sloty.get(slot).getSlotKierunek();
        }
        return 0;
    }
}
