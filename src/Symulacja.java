import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Symulacja {
    static double sumaPkt = 0;
    static int sumaV = 0, count = 0;
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

    public static Pojazd generowaniePojazdu(int sciezka[][]){
        Random random = new Random();
        int los = random.nextInt(10);
        if(los < 4) {
            Pojazd.List.add(new Samochod((random.nextInt(2) + 3), sciezka));
            sumaPkt = sumaPkt + 1;
        }
        else if(los < 6) {
            Pojazd.List.add(new Autobus((random.nextInt(2) + 1), sciezka));
            sumaPkt = sumaPkt + 2;
        }
        else {
            Pojazd.List.add(new Ciezarowka((random.nextInt(2) + 2), sciezka));
            sumaPkt = sumaPkt + 1.6;
        }
        count = count + 1;
        sumaV = sumaV + Pojazd.List.get(Pojazd.List.size()-1).vmax;
        return Pojazd.List.get(Pojazd.List.size()-1);
    }
    public static double zliczanie(int sumav, int time){
        sumaV = 0;
        count = 0;
        sumaPkt = 0;
        return ((double)sumav/(double)time);
    }
    public static void kontrolaKolizji(){}
}
