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
        for(int i = 0; i<2;i++) {
            for (int j = 0; j < 6; j++) {
                if(Map.getMap(0,0) == null && czasSwiatel > 0)
                    Symulacja.generowaniePojazdu(0,0);
            }
            Pojazd.clearList();
        }
    }
}