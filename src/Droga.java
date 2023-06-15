import java.util.List;
import java.util.Scanner;

public class Droga {
    private int id;
    private int pozx;
    private int pozy;
    private int rotate;
    private List<Slot> sloty;

    Droga(int id, int pozx, int pozy, int rotate, List<Slot> sloty) {
        this.id = id;
        this.pozx = pozx;
        this.pozy = pozy;
        this.rotate = rotate;
        this.sloty = sloty;
    }

    public static void dodanie_slot(Scanner in, List<Slot> sloty) {
        for (int left = 0; left == 0; ) {
            if (in.hasNext()) {
                in.nextLine();
                in.nextLine();
            } else {
                break;
            }
            if (in.hasNext() && in.nextLine().equals("[slot]")) {

                Slot slot = new Slot(in.nextInt(), in.nextInt(), in.nextInt());
                sloty.add(slot);
            } else {
                left++;
            }
        }
    }

    public int getId() {
        return id;
    }

    public int getPozx() {
        return pozx;
    }

    public int getPozy() {
        return pozy;
    }

    public int getRotate() {
        return rotate;
    }

    public int getSloty(int slot, int pole) {
        if (pole == 0) {
            return sloty.get(slot).getSlotId();
        }
        if (pole == 1) {
            return sloty.get(slot).getSlotRodzaj();
        }
        if (pole == 2) {
            return sloty.get(slot).getSlotKierunek();
        }
        return 0;
    }
}
