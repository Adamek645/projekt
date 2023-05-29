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
        File skrzyz = new File("skrzyzowanie.txt");
        Scanner in = new Scanner(skrzyz);
        dodanie_drog(in, skrzyzowanie);
    }
    public void dodanie_drog(Scanner in, Skrzyzowanie skrzyzowanie) {
        if(in.nextLine().equals("[skrzyzowanie]")){
            {
                in.nextLine();
                for (int left = 0; left == 0; ) {
                    if(in.hasNext()) {
                        if (in.nextLine().equals("[droga]")) {
                            List<Slot> slots = new ArrayList<Slot>();
                            Droga drogs = new Droga(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), slots);
                            Droga.dodanie_slot(in, slots);
                            drogi.add(drogs);
                            System.out.println("Dodano droge nr " + drogi.get(drogi.size() - 1).getId() +
                                    " o pozycji x/y:\nx: " + drogi.get(drogi.size() - 1).getPozx()
                                    + "\ny: " + drogi.get(drogi.size() - 1).getPozy() + "\npod katem: " +
                                    drogi.get(drogi.size() - 1).getRotate() + "\nze slotami: " + drogi.get(drogi.size()-1).getSloty());

                        } else {
                            left++;
                            System.out.println("tak");
                        }
                    } else {
                        break;
                    }
                }
            }
            /* for (int i = 0; i < drogi.size(); i++) {
                System.out.println("Dodano droge nr " + drogi.get(i).getId() + " o pozycji x/y:\nx: " + drogi.get(i).getPozx()
                        + "\ny: " + drogi.get(i).getPozy() + "\npod katem: " + drogi.get(i).getRotate());
            } */
            Sciezka sciezka = new Sciezka();
            PunktKolizji punktKolizji = new PunktKolizji();
        }
    }

}
