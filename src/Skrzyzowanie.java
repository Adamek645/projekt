import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Skrzyzowanie {
    public void test() throws FileNotFoundException {
        File plik = new File("skrzyzowanie.txt");
        Scanner in = new Scanner(plik);
        if(in.nextLine().equals("[skrzyzowanie]")){
            {
                in.nextLine();
                List<Droga> drogi = new ArrayList<Droga>();
                if(in.nextLine().equals("[droga]")){
                    Droga droga = new Droga(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                    drogi.add(droga);
                } else if (drogi.size() == 0){

                }
            }

            Sciezka sciezka = new Sciezka();
            PunktKolizji punktKolizji = new PunktKolizji();
        }
    }

}
