import java.util.List;

public class PunktKolizji {
    private int sciezka1;
    private int sciezka2;
    private int pozx;
    private int pozy;
    PunktKolizji (int sciezka1, int sciezka2, int pozx, int pozy) {
        this.sciezka1 = sciezka1;
        this.sciezka2 = sciezka2;
        this.pozx = pozx;
        this.pozy = pozy;
    }
    public static void wyznaczaniePunktow(List<PunktKolizji> punktyKolizji, List<Sciezka> sciezki) {
        for (int i = 0; i < sciezki.size(); i++) {
            for (int j = 1; j < sciezki.size(); j++) {
                if(sciezki.get(j).getDrogaWe() == sciezki.get(i).getDrogaWe() || sciezki.get(j).getDrogaWy() == sciezki.get(i).getDrogaWy()) {

                } else {
                    for (int k = 0; k < sciezki.get(i).getSciezka().length; k++) {
                        for (int l = 0; l < sciezki.get(j).getSciezka().length; l++) {
                            int w1x = sciezki.get(i).getSciezka()[k][0];
                            int w1y = sciezki.get(i).getSciezka()[k][1];
                            int w2x = sciezki.get(j).getSciezka()[l][0];
                            int w2y = sciezki.get(j).getSciezka()[l][1];
                            if(w1x == w2x && w1y == w2y) {
                                for(int o = 0; o < punktyKolizji.size(); o++) {
                                    if (punktyKolizji.get(o).sciezka1 == i && punktyKolizji.get(o).sciezka2 == j) {
                                        break;
                                    } else {
                                        PunktKolizji pkt = new PunktKolizji(i, j, w1x, w1y);
                                        punktyKolizji.add(pkt);
                                        System.out.println("Stworzono punkt kolizji o koordynatach: x: " + sciezki.get(i).getSciezka()[k][0] + " y: " + sciezki.get(i).getSciezka()[k][1]);
                                    }
                                }
                                if (punktyKolizji.size() < 1) {
                                    PunktKolizji pkt = new PunktKolizji(i, j, w1x, w1y);
                                    punktyKolizji.add(pkt);
                                    System.out.println("Stworzono punkt kolizji o koordynatach: x: " + sciezki.get(i).getSciezka()[k][0] + " y: " + sciezki.get(i).getSciezka()[k][1]);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
