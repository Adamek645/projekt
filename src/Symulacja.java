import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Symulacja {
  /*  static ZapisPliku save;
     static {
        try {
            save = new ZapisPliku();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
    public static void symulacja(Skrzyzowanie skrzyzowanie){
    }

    public static Pojazd generowaniePojazdu(int scierzka[][]){
        Random random = new Random();
        int los = random.nextInt(10);
        if(los < 4) {
            Pojazd.List.add(new Samochod((random.nextInt(2) + 3), scierzka));
        }
        else if(los < 6) {
            Pojazd.List.add(new Autobus((random.nextInt(2) + 1), scierzka));
        }
        else {
            Pojazd.List.add(new Ciezarowka((random.nextInt(2) + 2), scierzka));
        }
        return Pojazd.List.get(Pojazd.List.size()-1);
    }
    public static double zliczanie(int dldrogi, int v){
        return ((double)dldrogi/(double)v);
    }
    public static void kontrolaKolizji(){}
}
