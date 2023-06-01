import java.util.ArrayList;
import java.util.Random;
public class Samochod extends Pojazd {
    static ArrayList<Samochod> list;
    static ArrayList<Samochod> getList() {
        return list;
    }
    static ArrayList<Samochod> generowanie_listy(int ilosc){
        ArrayList<Samochod> list = new ArrayList<>();
        Random generator = new Random();
        for(int i = 0;i<ilosc;i++){
            list.add(new Samochod(generator.nextInt(20)+30));
        }
        return  Samochod.list = list;
    }
    Samochod(int vmax){
        super(vmax);
        setVmax(vmax);
    }
}
