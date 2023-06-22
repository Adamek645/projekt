package symulacjaskrzyzowania;

/**
 * Klasa będąca rozszerzeniem klasy symulacjaskrzyzowania.Pojazd - reprezentuje ona autobus.
 */
public class Autobus extends Pojazd {
    /**
     * Konstruktor autobusu
     * @param vmax Prędkość maksymalna
     * @param droga Przypisana ścieżka
     */
    Autobus(int vmax, int droga[][]) {
        super(vmax, droga);
        setVmax(vmax);
        setDroga(droga);
    }
}
