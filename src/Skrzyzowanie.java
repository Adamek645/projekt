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
    public void nwm() throws FileNotFoundException {
        File skrzyz = new File("skrzyzowanie.txt");
        Scanner in = new Scanner(skrzyz);
        dodanie_drog(in);
    }
    public void dodanie_drog(Scanner in) {
        if(in.nextLine().equals("[skrzyzowanie]")){
            {
                in.nextLine();
                for (int left = 0; left == 0; ) {
                    if(in.hasNext()) {
                        if (in.nextLine().equals("[droga]")) {
                            List<Slot> slots = new ArrayList<Slot>();
                            Droga drogs = new Droga(in.nextInt(), in.nextDouble(), in.nextDouble(), in.nextInt(), slots);
                            Droga.dodanie_slot(in, slots);
                            drogi.add(drogs);
                            /* System.out.println("Dodano droge nr " + drogi.get(drogi.size() - 1).getId() +
                                    " o pozycji x/y:\nx: " + drogi.get(drogi.size() - 1).getPozx()
                                    + "\ny: " + drogi.get(drogi.size() - 1).getPozy() + "\npod katem: " +
                                    drogi.get(drogi.size() - 1).getRotate() + "\nze slotami: ");
                            for (int i = 0; i < slots.size(); i++) {
                                System.out.println("Slot nr " + i + " z id " + drogi.get(drogi.size() - 1).getSloty(i,0));
                                for (int j = 1; j < 3; j++) {
                                    if (j == 1) {
                                        System.out.print("rodzaj: ");
                                    } else if (j == 2) {
                                        System.out.print("kierunek: ");
                                    }
                                    System.out.println(drogi.get(drogi.size() - 1).getSloty(i,j));
                                }
                            } */
                        } else {
                            left++;
                            System.out.println("tak");
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }
    public double getDrogi (int droga, int pole) {
        if (pole == 0) {
            return drogi.get(droga).getId();
        }
        if (pole == 1) {
            return drogi.get(droga).getPozx();
        }
        if (pole == 2) {
            return drogi.get(droga).getPozy();
        }
        if (pole == 3) {
            return drogi.get(droga).getRotate();
        }
        return 0;
    }
    public double getSloty (int droga, int slot, int pole) {
        return drogi.get(droga).getSloty(slot, pole);
    }
}
