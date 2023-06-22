package symulacjaskrzyzowania;

/**
 * Klasa odpowiada za wczytywanie slotów przypisanych do danej drogi
 */
public class Slot {
    private int id;
    private int rodzaj;
    private int kierunek;

    /**
     * Konstruktor slotu
     * @param id Numer slotu
     * @param rodzaj Rodzaj slotu
     * @param kierunek Kierunek slotu (wpuszczanie/opuszczanie)
     */
    Slot(int id, int rodzaj, int kierunek) {
        this.id = id;
        this.rodzaj = rodzaj;
        this.kierunek = kierunek;
    }

    /**
     * Funkcja zwraca numer slotu
     * @return Numer slotu
     */
    public int getSlotId() {
        return id;
    }
    /**
     * Funkcja zwraca rodzaj slotu
     * @return Rodzaj slotu
     */
    public int getSlotRodzaj() {
        return rodzaj;
    }
    /**
     * Funkcja zwraca kierunek slotu
     * @return Kierunek slotu
     */
    public int getSlotKierunek() {
        return kierunek;
    }
}
