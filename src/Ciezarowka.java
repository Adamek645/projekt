import java.util.ArrayList;
import java.util.Random;

public class Ciezarowka extends Pojazd {
    static ArrayList<Ciezarowka> list;
    static ArrayList<Ciezarowka> getList() {
        return list;
    }
     static ArrayList<Ciezarowka> generowanie_listy(int ilosc){
        ArrayList<Ciezarowka> list = new ArrayList<>();
        Random generator = new Random();
        for(int i = 0;i<ilosc;i++){
            list.add(new Ciezarowka(generator.nextInt(30)+20));
        }
        return Ciezarowka.list = list;
    }
    Ciezarowka(int vmax){
        super(vmax);
        setVmax(vmax);
    }
}
