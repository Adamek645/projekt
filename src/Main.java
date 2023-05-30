import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Droga> drogi = new ArrayList<Droga>();
        Skrzyzowanie skrzyzowanie = new Skrzyzowanie(drogi);
        skrzyzowanie.nwm(skrzyzowanie);
        /* Symulacja symulacja = new Symulacja();
        Symulacja.symulacja(skrzyzowanie); */
        Symulacja.generowanieRuchu();
    }
}