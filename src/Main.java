import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Droga> drogi = new ArrayList<>();
        List<Sciezka> sciezki = new ArrayList<>();
        Skrzyzowanie skrzyzowanie = new Skrzyzowanie(drogi, sciezki);
        skrzyzowanie.nwm();
        Sciezka.dodanieSciezki(skrzyzowanie, sciezki);
        int[][] sciezka = Skrzyzowanie.getSciezka(0);
        /* Symulacja symulacja = new Symulacja();
        Symulacja.symulacja(skrzyzowanie); */
        int czasSwiatel = 600;
        int m,x,y,a = 0,b = 1,time = czasSwiatel,pojazdlimit = 30;
        Random rand = new Random();
        Map mapa = new Map(601,601);
       // for(int cykl = 0; cykl < 3;cykl++) {
            while (czasSwiatel > 0 || Map.mapContents()) {
                time = time + 1;
                if (rand.nextInt(100) < 40 && pojazdlimit > 0) {
                    pojazdlimit--;
                        if (rand.nextInt(2) == 1) {
                            x = Skrzyzowanie.getSciezka(a)[0][0];
                            y = Skrzyzowanie.getSciezka(a)[0][1];
                            if (mapa.getMap(x, y) == null && czasSwiatel > 0){
                                Symulacja.generowaniePojazdu(Skrzyzowanie.getSciezka(a));
                                mapa.setMap(Pojazd.List.get(Pojazd.List.size() - 1).x, Pojazd.List.get(Pojazd.List.size() - 1).y, Pojazd.List.get(Pojazd.List.size() - 1));
                            }
                        /*    else {
                                x = Skrzyzowanie.getSciezka(b)[0][0];
                                y = Skrzyzowanie.getSciezka(b)[0][1];
                                    if (mapa.getMap(x, y) == null && czasSwiatel > 0) {
                                        Symulacja.generowaniePojazdu(Skrzyzowanie.getSciezka(b));
                                        mapa.setMap(Pojazd.List.get(Pojazd.List.size() - 1).x, Pojazd.List.get(Pojazd.List.size() - 1).y, Pojazd.List.get(Pojazd.List.size() - 1));
                                    }
                             }
                        }*/
                        }
                }
                if(Pojazd.List.size() != 0) {
                    for (int l = 0; l < Pojazd.List.size(); l++) {
                        m = Pojazd.List.get(l).vmax;
                        while (m > 0) {
                            if (((Pojazd.List.get(l).C) + 1) == Pojazd.List.get(l).droga.length) {
                                mapa.setMap(Pojazd.List.get(l).x, Pojazd.List.get(l).y, null);
                                m = 0;
                            }// else if (){
                            // m = 0;
                            //  }
                            else {
                                Pojazd.List.get(l).ruchPojazdu();
                            }
                            m--;
                        }
                    }
                    if(mapa.getMap(Pojazd.List.get(Pojazd.List.size()-1).x, Pojazd.List.get(Pojazd.List.size()-1).y) == null)
                        mapa.mapClear();
                }
                czasSwiatel--;
            }
            System.out.println(Pojazd.List);
            Pojazd.clearList();
            System.out.println(Symulacja.sumaPkt);
            System.out.println(Symulacja.count);
            System.out.println((float) Symulacja.count / time);
            System.out.println(Symulacja.zliczanie(Symulacja.sumaV, time));
            a=+2;
            b=+2;
      //  }
    }
}