package symulacjaskrzyzowania;

/**
 * Klasa będąca rozszerzeniem klasy symulacjaskrzyzowania.Pojazd - reprezentuje ona cięzarówkę.
 */
public class Ciezarowka extends Pojazd {
    /**
     * Konstruktor ciężarówki
     * @param vmax Prędkość maksymalna
     * @param droga Przypisana ścieżka
     */
    Ciezarowka(int vmax, int droga[][]) {
        super(vmax, droga);
        setVmax(vmax);
        setDroga(droga);
    }
}
