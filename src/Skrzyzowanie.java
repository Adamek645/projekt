import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Skrzyzowanie {
    private List<Droga> drogi;
    Skrzyzowanie(List<Droga> drogi) {
        this.drogi = drogi;
    }
    public void nwm(Skrzyzowanie skrzyzowanie) throws FileNotFoundException {
        File plik = new File("skrzyzowanie.txt");
        Scanner in = new Scanner(plik);
        dodanie_drog(in, skrzyzowanie);
    }
    public void dodanie_drog(Scanner in, Skrzyzowanie skrzyzowanie) {
        if(in.nextLine().equals("[skrzyzowanie]")){
            {
                for (int left = 0; left == 0; ) {
                    in.nextLine();
                    if (in.nextLine().equals("[droga]")) {
                        Droga droga = new Droga(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                        Droga.dodanie_slot(in);
                        drogi.add(droga);
                    } else {
                        left++;
                    }
                }
            }
            Sciezka sciezka = new Sciezka();
            PunktKolizji punktKolizji = new PunktKolizji();
        }
    }

}
