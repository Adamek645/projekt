package symulacjaskrzyzowania;

import java.util.List;

/**
 * Klasa odpowiada za powstawanie punktów kolizji
 */
public class PunktKolizji {
    private int sciezka1;
    private int sciezka2;
    private int pozx;
    private int pozy;

    /**
     * Konstruktor punktu kolizji
     * @param sciezka1 Jedna ze ścieżek mająca wspólny punkt na mapie współrzędnych
     * @param sciezka2 Druga ze ścieżek mająca wspólny punkt na mapie współrzędnych
     * @param pozx Pozycja x punktu kolizji
     * @param pozy Pozycja y punktu kolizji
     */
    PunktKolizji(int sciezka1, int sciezka2, int pozx, int pozy) {
        this.sciezka1 = sciezka1;
        this.sciezka2 = sciezka2;
        this.pozx = pozx;
        this.pozy = pozy;
    }

    /**
     * Funkcja wyznacza punkty kolizji na mapie 600x600 porówując do siebie każdy punkt ścieżek po kolei.
     * @param punktyKolizji Lista punktów kolizji
     * @param sciezki Lista ścieżek
     */
    public static void wyznaczaniePunktow(List<PunktKolizji> punktyKolizji, List<Sciezka> sciezki) {
        for (int i = 0; i < sciezki.size(); i++) {
            for (int j = 1; j < sciezki.size(); j++) {
                if (sciezki.get(j).getDrogaWe() == sciezki.get(i).getDrogaWe()) {
                } else {
                    if (sciezki.get(i).getDrogaWy() == sciezki.get(j).getDrogaWy()) {
                        for (int k = 0; k < sciezki.get(i).getSciezka().length; k++) {
                            int test = 0;
                            for (int l = 0; l < sciezki.get(j).getSciezka().length; l++) {
                                int w1x = sciezki.get(i).getSciezka()[k][0];
                                int w1y = sciezki.get(i).getSciezka()[k][1];
                                int w2x = sciezki.get(j).getSciezka()[l][0];
                                int w2y = sciezki.get(j).getSciezka()[l][1];
                                if (w1x == w2x && w1y == w2y) {
                                    for (int o = 0; o < punktyKolizji.size(); o++) {
                                        test = 0;
                                        int p1k = punktyKolizji.get(o).getSciezka1();
                                        int p2k = punktyKolizji.get(o).getSciezka2();
                                        int px = punktyKolizji.get(o).getPozx();
                                        int py = punktyKolizji.get(o).getPozy();
                                        if ((((p1k == i && p2k == j) || (p1k == j && p2k == i)) ||
                                                (px == w1x && py == w1y))) {
                                            break;
                                        }
                                        test = 1;
                                    }
                                    if (test == 1) {
                                        PunktKolizji pkt = new PunktKolizji(i, j, w1x, w1y);
                                        punktyKolizji.add(pkt);
                                        break;
                                    }
                                }
                            }
                            if (test == 1)
                                break;
                        }
                    } else {
                        for (int k = 0; k < sciezki.get(i).getSciezka().length; k++) {
                            for (int l = 0; l < sciezki.get(j).getSciezka().length; l++) {
                                int w1x = sciezki.get(i).getSciezka()[k][0];
                                int w1y = sciezki.get(i).getSciezka()[k][1];
                                int w2x = sciezki.get(j).getSciezka()[l][0];
                                int w2y = sciezki.get(j).getSciezka()[l][1];
                                int test = 0;
                                if (w1x == w2x && w1y == w2y) {
                                    for (int o = 0; o < punktyKolizji.size(); o++) {
                                        test = 0;
                                        int p1k = punktyKolizji.get(o).getSciezka1();
                                        int p2k = punktyKolizji.get(o).getSciezka2();
                                        int px = punktyKolizji.get(o).getPozx();
                                        int py = punktyKolizji.get(o).getPozy();
                                        if ((((p1k == i && p2k == j) || (p1k == j && p2k == i)) ||
                                                (px == w1x && py == w1y))) {
                                            break;
                                        }
                                        test = 1;
                                    }
                                    if (test == 1) {
                                        PunktKolizji pkt = new PunktKolizji(i, j, w1x, w1y);
                                        punktyKolizji.add(pkt);
                                    }
                                    if (punktyKolizji.size() < 1) {
                                        PunktKolizji pkt = new PunktKolizji(i, j, w1x, w1y);
                                        punktyKolizji.add(pkt);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Funkcja zwraca pozycję punktu kolizji w osi x
     * @return Pozycja w osi x
     */
    public int getPozx() {
        return pozx;
    }
    /**
     * Funkcja zwraca pozycję punktu kolizji w osi y
     * @return Pozycja w osi y
     */
    public int getPozy() {
        return pozy;
    }
    /**
     * Funkcja zwraca pierwszą ścieżkę punktu kolizji
     * @return Pierwsza ścieżka kolizji
     */
    public int getSciezka1() {
        return sciezka1;
    }
    /**
     * Funkcja zwraca drugą ścieżkę punktu kolizji
     * @return Druga ścieżka kolizji
     */
    public int getSciezka2() {
        return sciezka2;
    }
}
