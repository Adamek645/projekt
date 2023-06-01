import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Symulacja {
    static ZapisPliku save;
     static {
        try {
            save = new ZapisPliku();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Samochod samochod = new Samochod(50);
    Ciezarowka ciezarowka = new Ciezarowka(50);
    Autobus autobus = new Autobus(40);
    public static void symulacja(Skrzyzowanie skrzyzowanie){

    }
    public static void generowanieRuchu(int s){
        int v,ilosc;
        double suma = 0,time = 0;
        Random random = new Random();
        Samochod.generowanie_listy(20);
        Autobus.generowanie_listy(5);
        Ciezarowka.generowanie_listy(10);
        ilosc = random.nextInt(20)+10;
        for(int i = 0; i < ilosc; i++){
                if(random.nextInt(3) == 0){
                    v = Samochod.list.get(random.nextInt(Samochod.list.size()-1)).vmax;
                } else if (random.nextInt(3) == 1) {
                    v = Autobus.list.get(random.nextInt(Autobus.list.size()-1)).vmax;
                }else v = Ciezarowka.list.get(random.nextInt(Ciezarowka.list.size()-1)).vmax;
                suma = suma + v;
                time = time + zliczanie(s,v);
        }
        System.out.println("Number of vehicles: "+ ilosc);
        System.out.println("Average speed(m/s): "+ Math.round((suma/(ilosc-1))));
        System.out.println("Time(s): "+ Math.round(time));
        save.zapis(ilosc,Math.round((suma/(ilosc-1))), Math.round(time));
    }
    public static double zliczanie(int dldrogi, int v){
        return ((double)dldrogi/(double)v);
    }
    public static void kontrolaKolizji(){}
}
