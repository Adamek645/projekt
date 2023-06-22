package symulacjaskrzyzowania;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 * Klasa odpowiadająca za działanie programu i wykonywanie głównej warstwy symulacyjnej.
 */
public class Main {
    /**
     * Metoda główna, odpowiadająca za działanie programu
     * @throws FileNotFoundException Zabezpieczenie w przypadku braku plików
     */
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
        Scanner in = new Scanner(System.in);
        System.out.print("Wpisz czas wpuszczania pojazdów dla jednej drogi (w s, 30/40/50): "); // Czas wpuszczania - czas trwania sygnału zielonego jest o 8 sekund krótszy.
        int czasSwiatelSt = in.nextInt() * 10;
        int liczbaCykli = 36000 / (czasSwiatelSt * 3);
        int m, x, y, a = 0, b = 1, time = 0, timeC = 0, pojazdlimit = 50, zasieg = 100, pop = 0, pojPop = 0, sumaPkt = 0, count = 0, sumaPktMin = 100000, sumaPktMax = 0;
        Random rand = new Random();
        Map mapa = new Map(601, 601);
        for (int iteracja = 0; iteracja < liczbaCykli; iteracja++) {
            for (int cykl = 0; cykl < 3; cykl++) {
                int czasSwiatel = czasSwiatelSt;
                while (czasSwiatel > 0 || Map.mapContents()) {
                    time = time + 1;
                    double wspolczynnik = (double) (czasSwiatelSt - czasSwiatel) / (czasSwiatelSt);
                    if (rand.nextInt(100) < 30 && pojazdlimit > 0 && czasSwiatel > 80 && (time - pop) * (int) (7 * (0.5 + wspolczynnik * 0.5)) >= pojPop) {
                        pojazdlimit--;
                        if (rand.nextInt(2) == 1) {
                            x = Skrzyzowanie.getSciezka(a)[0][0];
                            y = Skrzyzowanie.getSciezka(a)[0][1];
                            if (mapa.getMap(x, y) == null) {
                                Symulacja.generowaniePojazdu(Skrzyzowanie.getSciezka(a), wspolczynnik);
                                pop = time;
                                if (Pojazd.List.get(Pojazd.List.size() - 1).vmax == (int) (7 * (0.5 + wspolczynnik * 0.5))) {
                                    pojPop = 230;
                                } else if (Pojazd.List.get(Pojazd.List.size() - 1).vmax == (int) (8 * (0.5 + wspolczynnik * 0.5))) {
                                    pojPop = 170;
                                } else if (Pojazd.List.get(Pojazd.List.size() - 1).vmax == (int) (10 * (0.7 + wspolczynnik * 0.3))) {
                                    pojPop = 110;
                                }
                                mapa.setMap(Pojazd.List.get(Pojazd.List.size() - 1).x, Pojazd.List.get(Pojazd.List.size() - 1).y, Pojazd.List.get(Pojazd.List.size() - 1));
                            } else {
                                x = Skrzyzowanie.getSciezka(b)[0][0];
                                y = Skrzyzowanie.getSciezka(b)[0][1];
                                if (mapa.getMap(x, y) == null) {
                                    Symulacja.generowaniePojazdu(Skrzyzowanie.getSciezka(b), wspolczynnik);
                                    pop = time;
                                    if (Pojazd.List.get(Pojazd.List.size() - 1).vmax == (int) (7 * (0.5 + wspolczynnik * 0.5))) {
                                        pojPop = 230;
                                    } else if (Pojazd.List.get(Pojazd.List.size() - 1).vmax == (int) (8 * (0.5 + wspolczynnik * 0.5))) {
                                        pojPop = 170;
                                    } else if (Pojazd.List.get(Pojazd.List.size() - 1).vmax == (int) (10 * (0.7 + wspolczynnik * 0.3))) {
                                        pojPop = 110;
                                    }
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
                                } else
                                    Pojazd.List.get(l).ruchPojazdu();
                                m--;
                            }
                        }
                    }
                    if (czasSwiatel < 2 && Pojazd.List.size() > 0 && mapa.getMap(Pojazd.List.get(Pojazd.List.size() - 1).x, Pojazd.List.get(Pojazd.List.size() - 1).y) == null) {
                        mapa.mapClear();
                        pojazdlimit = 50;
                        pop = 0;
                        pojPop = 0;
                        break;
                    }
                    czasSwiatel--;
                }
                Pojazd.clearList();
                a += 2;
                b += 2;
            }
            sumaPkt = sumaPkt + Symulacja.sumaPkt;
            count = count + Symulacja.count;
            timeC = timeC + time;
            if (Symulacja.sumaPkt < sumaPktMin) {
                sumaPktMin = Symulacja.sumaPkt;
            }
            if (Symulacja.sumaPkt > sumaPktMax) {
                sumaPktMax = Symulacja.sumaPkt;
            }
            System.out.println("Wartość przepustowości E/cykl: " + (float) Symulacja.sumaPkt / 100);
            System.out.println("Liczba pojazdów w cyklu: " + Symulacja.count);
            System.out.println("Średnia prędkość: " + (float) Symulacja.sumaV / Symulacja.count);
            System.out.println("Czas symulacji cyklu w sekundach: " + time / 10);
            ZapisPliku.zapis(Symulacja.count, Symulacja.sumaPkt, time);
            Symulacja.sumaPkt = 0;
            Symulacja.count = 0;
            Symulacja.sumaV = 0;
            time = 0;
            pojazdlimit = 50;
            a = 0;
            b = 1;
        }
        System.out.println("Przepustowość skrzyżowania E/h: " + sumaPkt / 100);
        System.out.println("Liczba pojazdów w ciagu godziny: " + count + "\n");
        System.out.println("Minimalna przepustowość (E/cykl) w badaniu: " + (double) sumaPktMin / 100);
        System.out.println("Maksymalna przepustowość (E/cykl) w badaniu: " + (double) sumaPktMax / 100);
        ZapisPliku.zapisCalosci(count, sumaPkt, timeC, sumaPktMin, sumaPktMax);
    }
}