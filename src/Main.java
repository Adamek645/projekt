import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            ZapisPliku save = new ZapisPliku();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Droga> drogi = new ArrayList<>();
        List<Sciezka> sciezki = new ArrayList<>();
        List<PunktKolizji> punktyKolizji = new ArrayList<>();
        Skrzyzowanie skrzyzowanie = new Skrzyzowanie(drogi, sciezki, punktyKolizji);
        skrzyzowanie.nwm();
        Sciezka.dodanieSciezki(skrzyzowanie, sciezki);
        PunktKolizji.wyznaczaniePunktow(punktyKolizji, sciezki);
        int[][] sciezka = Skrzyzowanie.getSciezka(0);
        /* Symulacja symulacja = new Symulacja();
        Symulacja.symulacja(skrzyzowanie); */
        int czasSwiatel = 1200;
        int m,x,y,a = 0,b = 1,time = czasSwiatel,pojazdlimit = 30, zasieg = 100;
        Random rand = new Random();
        Map mapa = new Map(601,601);
        for(int iteracja = 0; iteracja < 4; iteracja++){
        for(int cykl = 0; cykl < 3;cykl++){
            czasSwiatel = 1200;
            time = czasSwiatel;
            while (czasSwiatel > 0 || Map.mapContents()) {
                time = time + 1;
                if (rand.nextInt(100) < 40 && pojazdlimit > 0 && czasSwiatel > 0) {
                    pojazdlimit--;
                    if (rand.nextInt(2) == 1) {
                        x = Skrzyzowanie.getSciezka(a)[0][0];
                        y = Skrzyzowanie.getSciezka(a)[0][1];
                        if (mapa.getMap(x, y) == null) {
                            Symulacja.generowaniePojazdu(Skrzyzowanie.getSciezka(a));
                            mapa.setMap(Pojazd.List.get(Pojazd.List.size() - 1).x, Pojazd.List.get(Pojazd.List.size() - 1).y, Pojazd.List.get(Pojazd.List.size() - 1));
                        } else {
                            x = Skrzyzowanie.getSciezka(b)[0][0];
                            y = Skrzyzowanie.getSciezka(b)[0][1];
                            if (mapa.getMap(x, y) == null) {
                                Symulacja.generowaniePojazdu(Skrzyzowanie.getSciezka(b));
                                mapa.setMap(Pojazd.List.get(Pojazd.List.size() - 1).x, Pojazd.List.get(Pojazd.List.size() - 1).y, Pojazd.List.get(Pojazd.List.size() - 1));
                            }
                        }
                    }
                }
                if (Pojazd.List.size() != 0) {
                    for (int l = 0; l < Pojazd.List.size(); l++) {
                        m = Pojazd.List.get(l).vmax;
                        while (m > 0) {

                            if (((Pojazd.List.get(l).C) + 1) == Pojazd.List.get(l).droga.length) {
                                mapa.setMap(Pojazd.List.get(l).x, Pojazd.List.get(l).y, null);
                                m = 0;
                            }else
                            Pojazd.List.get(l).ruchPojazdu();
                            m--;
                        }
                        }
                }
                if (pojazdlimit <= 0 && Pojazd.List.size() > 0 && mapa.getMap(Pojazd.List.get(Pojazd.List.size() - 1).x, Pojazd.List.get(Pojazd.List.size() - 1).y) == null) {
                    mapa.mapClear();
                    break;
                }
                czasSwiatel--;
            }
            Pojazd.clearList();
            a += 2;
            b += 2;
        }
            System.out.println("Suma Punktów: " + Symulacja.sumaPkt);
            System.out.println("Ilość pojazdów w symulacji: " + Symulacja.count);
            System.out.println("Średnia prędkość: " + (double) Symulacja.sumaV / Symulacja.count);
            System.out.println("Czas symulacji: " + time);
            ZapisPliku.zapis(Symulacja.count,Symulacja.sumaPkt,time);
            Symulacja.sumaPkt = 0;
            Symulacja.count = 0;
            Symulacja.sumaV = 0;
            time = 0;
            pojazdlimit = 30;
            a = 0;
            b = 1;
        }
    }
}
/*
if (Arrays.deepEquals(Pojazd.List.get(l).droga, Skrzyzowanie.getSciezka(a))) {
                                if (Skrzyzowanie.getPierwszenstwo(Skrzyzowanie.getPierwszenstwo(b)) > Skrzyzowanie.getPierwszenstwo(a)) {
                                    int i = 0, j = 0, xk = punktyKolizji.get(a).getPozx(), yk = punktyKolizji.get(a).getPozy();
                                    while (i < (Skrzyzowanie.getSciezka(a).length)) {
                                        if (Skrzyzowanie.getSciezka(a)[i][0] == xk || Skrzyzowanie.getSciezka(a)[i][1] == yk) {
                                            break;
                                        }
                                        i++;
                                    }
                                    j = i - zasieg;
                                    while (j < i) {
                                        if (mapa.getMap(Skrzyzowanie.getSciezka(a)[j][0], Skrzyzowanie.getSciezka(a)[j][1]) == Pojazd.List.get(l)) {
                                            j = i + zasieg;
                                            while (i <= j && mapa.getMap(Skrzyzowanie.getSciezka(a)[j][0], Skrzyzowanie.getSciezka(a)[j][1]) == null)
                                                i++;
                                            if (j == i) {
                                                Pojazd.List.get(l).ruchPojazdu();
                                            }
                                            break;
                                        }
                                        j++;
                                    }
                                } else if (Arrays.deepEquals(Pojazd.List.get(l).droga, Skrzyzowanie.getSciezka(b))) {
                                    if (Skrzyzowanie.getPierwszenstwo(Skrzyzowanie.getPierwszenstwo(a)) > Skrzyzowanie.getPierwszenstwo(b)) {
                                        int i = 0, j = 0, xk = punktyKolizji.get(b).getPozx(), yk = punktyKolizji.get(b).getPozy();
                                        while (i < (Skrzyzowanie.getSciezka(a).length)) {
                                            if (Skrzyzowanie.getSciezka(b)[i][0] == xk || Skrzyzowanie.getSciezka(b)[i][1] == yk) {
                                                break;
                                            }
                                            i++;
                                        }
                                        j = i - zasieg;
                                        while (j < i) {
                                            if (mapa.getMap(Skrzyzowanie.getSciezka(b)[j][0], Skrzyzowanie.getSciezka(b)[j][1]) == Pojazd.List.get(l)) {
                                                j = i + zasieg;
                                                while (i <= j && mapa.getMap(Skrzyzowanie.getSciezka(b)[j][0], Skrzyzowanie.getSciezka(b)[j][1]) == null)
                                                    i++;
                                                if (j == i) {
                                                    Pojazd.List.get(l).ruchPojazdu();
                                                }
                                                break;
                                            }
                                            j++;
                                        }
                                    }
                                }
                            }
 */