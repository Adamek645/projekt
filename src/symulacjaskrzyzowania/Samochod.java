package symulacjaskrzyzowania;

/**
 * Klasa będąca rozszerzeniem klasy symulacjaskrzyzowania.Pojazd - reprezentuje ona samochód.
 */
public class Samochod extends Pojazd {
    /**
     * Konstruktor samochodu
     * @param vmax Prędkość maksymalna
     * @param droga Przypisana ścieżka
     */
    Samochod(int vmax, int droga[][]) {
        super(vmax, droga);
        setVmax(vmax);
        setDroga(droga);
    }
}