import java.util.ArrayList;
import java.util.Random;

public class Autobus extends Pojazd {
    static ArrayList<Autobus> list;
    static ArrayList<Autobus> getList() {
        return list;
    }
     static ArrayList<Autobus> generowanie_listy(int ilosc){
        ArrayList<Autobus> list = new ArrayList<>();
        Random generator = new Random();
        for(int i = 0;i<ilosc;i++){
            list.add(new Autobus(generator.nextInt(20)+20));
        }
        return Autobus.list = list;
    }
    Autobus(int vmax){
        super(vmax);
        setVmax(vmax);
    }
}
