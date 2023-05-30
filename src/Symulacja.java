import java.util.ArrayList;
import java.util.Random;
public class Symulacja {
    Samochod samochod = new Samochod(50);
    Ciezarowka ciezarowka = new Ciezarowka(50);
    Autobus autobus = new Autobus(40);
    public static void symulacja(Skrzyzowanie skrzyzowanie){

    }
    public static void generowanieRuchu(){
        int v;
        Random random = new Random();
        Samochod.generowanie_listy(10);
        Autobus.generowanie_listy(5);
        Ciezarowka.generowanie_listy(15);
        for(int i = 0; i < 20; i++){
                if(random.nextInt(3) == 0){
                    v = Samochod.list.get(random.nextInt(Samochod.list.size()-1)).vmax;
                } else if (random.nextInt(3) == 1) {
                    v = Autobus.list.get(random.nextInt(Autobus.list.size()-1)).vmax;
                }else v =Ciezarowka.list.get(random.nextInt(Ciezarowka.list.size()-1)).vmax;
        }
    }
    public static void zliczanie(){}
    public static void kontrolaKolizji(){}
}
