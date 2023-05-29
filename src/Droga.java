import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Droga {
    private int id;
    private int pozx;
    private int pozy;
    private int rotate;
    Droga(int id, int pozx, int pozy, int rotate) {
        this.id = id;
        this.pozx = pozx;
        this.pozy = pozy;
        this.rotate = rotate;
    }
    public static void dodanie_slot(Scanner in) {
        List<Slot> slots = new ArrayList<Slot>();
        for (int left = 0; left == 0; ) {
            in.nextLine();
            if (in.nextLine().equals("[slot]")) {
                Slot slot = new Slot(in.nextInt(), in.nextInt(), in.nextInt());
                Droga.dodanie_slot(in);
                slots.add(slot);
            } else {
                left++;
            }
        }
    }
}
