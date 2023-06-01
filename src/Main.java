import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Droga> drogi = new ArrayList<Droga>();
        Skrzyzowanie skrzyzowanie = new Skrzyzowanie(drogi);
        skrzyzowanie.nwm();
        System.out.println(skrzyzowanie.getSloty(2,1,2));
        /* Symulacja symulacja = new Symulacja();
        Symulacja.symulacja(skrzyzowanie); */
        // generowanie ruchu dla 2 cyklów symulacji (światła)
        for(int i = 0; i<2;i++)
            for (int j = 0; j < 3; j++)
                Symulacja.generowanieRuchu(50); // id drogi + 1  z iteracji (później)
    }
}