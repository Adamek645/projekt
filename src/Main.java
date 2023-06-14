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
        int[][] sciezka = Skrzyzowanie.getSciezka(1);
        /* Symulacja symulacja = new Symulacja();
        Symulacja.symulacja(skrzyzowanie); */
        int czasSwiatel = 10;
        int [][] scierzka = { {1, 1, 1, 1,1,1,1}, {1, 2, 3, 4,5,6,7} };
        int m,x,y,time = czasSwiatel;
        Random rand = new Random();
        Map mapa = new Map(60,60);
            while(czasSwiatel > 0 || Map.mapContents()){
                time = time + 1;
                x = scierzka[0][0];
                y = scierzka[0][1];
                if(rand.nextInt(100) < 40)
                    if(mapa.getMap(x,y) == null && czasSwiatel > 0) {
                        Symulacja.generowaniePojazdu(scierzka);
                        mapa.setMap(Pojazd.List.get(Pojazd.List.size() - 1).x, Pojazd.List.get(Pojazd.List.size() - 1).y, Pojazd.List.get(Pojazd.List.size() - 1));
                     }
                for(int l = 0; l < Pojazd.List.size(); l++) {
                    m = Pojazd.List.get(l).vmax;
                    while (m > 0){
                        if((Pojazd.List.get(l).C + 1) == Pojazd.List.get(l).droga.length) {
                            mapa.setMap(Pojazd.List.get(l).x,Pojazd.List.get(l).y,null);
                            m=0;
                        }
                        else Pojazd.List.get(l).ruchPojazdu();
                        m--;
                    }
                }
                czasSwiatel--;
            }
        System.out.println(Pojazd.List);
            Pojazd.clearList();
        System.out.println(Symulacja.sumaPkt);
        System.out.println(Symulacja.count);
        System.out.println((float)Symulacja.count / time);
        System.out.println(Symulacja.zliczanie(Symulacja.sumaV, time));
    }
}