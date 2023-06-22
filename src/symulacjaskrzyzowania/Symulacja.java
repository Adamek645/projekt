package symulacjaskrzyzowania;

import java.util.Random;

/**
 * Klasa odpowiada za powstawanie pojazdów na mapie.
 */
public class Symulacja {
    static int sumaPkt = 0;
    static int sumaV = 0, count = 0;

    /**
     *
     * @param sciezka ścieżka na której generowany jest ruch
     * @param wspolczynnik współczynnik trwania świateł rosnący wraz z upływem czasu
     * @return Funkcja zwraca ostatni pojazd z listy - utworzony w metodzie
     */
    public static Pojazd generowaniePojazdu(int sciezka[][], double wspolczynnik) {
        Random random = new Random();
        int los = random.nextInt(10);
        if (los < 8) {
            Pojazd.List.add(new Samochod((int) (10 * (0.7 + wspolczynnik * 0.3)), sciezka));
            sumaPkt = sumaPkt + 100;
        } else if (los < 9) {
            Pojazd.List.add(new Autobus((int) (8 * (0.5 + wspolczynnik * 0.5)), sciezka));
            sumaPkt = sumaPkt + 200;
        } else {
            Pojazd.List.add(new Ciezarowka((int) (7 * (0.5 + wspolczynnik * 0.5)), sciezka));
            sumaPkt = sumaPkt + 160;
        }
        count = count + 1;
        sumaV = sumaV + Pojazd.List.get(Pojazd.List.size() - 1).vmax;
        return Pojazd.List.get(Pojazd.List.size() - 1);
    }
}
