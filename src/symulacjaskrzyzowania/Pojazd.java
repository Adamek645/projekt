package symulacjaskrzyzowania;

import java.util.LinkedList;
import java.util.List;
/**
 * Klasa odpowiadająca za generowanie pojazdów o zadanych parametrach.
 */
public class Pojazd {
    int vmax;
    protected int x, y, C;
    int[][] droga;
    float v;
    static List<Pojazd> List = new LinkedList<>();

    /**
     * Konstruktor pojazdu
     * @param vmax Prędkość maksymalna
     * @param droga Przypisana ścieżka
     */
    Pojazd(int vmax, int droga[][]) {
        this.vmax = vmax;
        this.droga = droga;
        this.x = droga[0][0];
        this.y = droga[0][1];
        this.C = 0;
    }

    /**
     * Funkcja odpowiadająca za czyszczenie listy pojazdów
     */
    public static void clearList() {
        List.clear();
    }

    /**
     * Funkcja pozwalająca na symulację ruchu pojazdu w jednej jednostce czasowej
     */
    public void ruchPojazdu() {
        if (this.kolizjaPojazdu()) {
            Map.setMap(this.droga[this.C + 1][0], this.droga[this.C + 1][0], Map.getMap(this.x, this.y));
            Map.setMap(this.x, this.y, null);
            this.C++;
            this.x = this.droga[this.C][0];
            this.y = this.droga[this.C][1];
        }
    }

    /**
     * Funkcja weryfikująca kolizję
     * @return Czy jest kolizja?
     */
    public Boolean kolizjaPojazdu() {
        if (Map.getMap(this.droga[this.C + 1][0], this.droga[this.C + 1][1]) == null)
            return true;
        return false;
    }

    /**
     * Funkcja przypisująca prędkość maksymalną
     * @param vmax Prędkość maksymalna pojazdu
     */
    public void setVmax(int vmax) {
        if (vmax >= 0) {
            this.vmax = vmax;
        }
    }

    /**
     * Funkcja przypisująca ścieżkę do pojazdu
     * @param droga Ścieżka po której się porusza pojazd
     */
    public void setDroga(int droga[][]) {
        this.droga = droga;
    }
}
