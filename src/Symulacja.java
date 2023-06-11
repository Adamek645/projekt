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
    Map mapa = new Map(60, 60);
    public static void generowaniePojazdu(int x, int y){
        Random random = new Random();
        int los = random.nextInt(10);
        if(los < 4)
            Map.setMap(x,y,Pojazd.List.add(new Samochod((random.nextInt(2) + 3))));
        else if(los < 6)
            Map.setMap(x,y,Pojazd.List.add(new Autobus((random.nextInt(2) + 1))));
        else
            Map.setMap(x,y,Pojazd.List.add(new Ciezarowka((random.nextInt(2) + 2))));
    }
    public static double zliczanie(int dldrogi, int v){
        return ((double)dldrogi/(double)v);
    }
    public static void kontrolaKolizji(){}
}
