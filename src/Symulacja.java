import java.util.Random;
public class Symulacja {
    static int sumaPkt = 0;
    static int sumaV = 0, count = 0;

    public static void symulacja(Skrzyzowanie skrzyzowanie) {
    }

    public static Pojazd generowaniePojazdu(int sciezka[][]) {
        Random random = new Random();
        int los = random.nextInt(10);
        if (los < 8) {
            Pojazd.List.add(new Samochod(14, sciezka));
            sumaPkt = sumaPkt + 100;
        } else if (los < 9) {
            Pojazd.List.add(new Autobus(13, sciezka));
            sumaPkt = sumaPkt + 200;
        } else {
            Pojazd.List.add(new Ciezarowka(12, sciezka));
            sumaPkt = sumaPkt + 160;
        }
        count = count + 1;
        sumaV = sumaV + Pojazd.List.get(Pojazd.List.size() - 1).vmax;
        return Pojazd.List.get(Pojazd.List.size() - 1);
    }
}
