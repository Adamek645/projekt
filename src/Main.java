import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Droga> drogi = new ArrayList<>();
        List<Sciezka> sciezki = new ArrayList<>();
        Skrzyzowanie skrzyzowanie = new Skrzyzowanie(drogi, sciezki);
        skrzyzowanie.nwm();
        Sciezka.dodanieSciezki(skrzyzowanie, sciezki);
        /* Symulacja symulacja = new Symulacja();
        Symulacja.symulacja(skrzyzowanie); */
        int czasSwiatel = 60;
        int [][] scierzka = { {1, 1, 1, 1,1,1,1}, {1, 2, 3, 4,5,6,7} };
        int m,x,y;
        Map mapa = new Map(60,60);
         //   while(czasSwiatel > 0 || Map.mapContents()){
                x = scierzka[0][0];
                y = scierzka[0][1];
                if(mapa.getMap(x,y) == null && czasSwiatel > 0)
                    Symulacja.generowaniePojazdu(scierzka);
                    mapa.setMap(Pojazd.List.get(Pojazd.List.size()-1).x,Pojazd.List.get(Pojazd.List.size()-1).y,Pojazd.List.get(Pojazd.List.size()-1));
                for(int l = 0; l < Pojazd.List.size(); l++) {
                    m = Pojazd.List.get(l).vmax;
                    while (m > 0){
                        Pojazd.List.get(l).ruchPojazdu();
                        m--;
                    }
                }
                czasSwiatel--;
          //  }

            Pojazd.clearList();

    }
}