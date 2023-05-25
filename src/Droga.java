public class Droga {
    private int id;
    private int pozx;
    private int pozy;
    private int rotate;
    Slot slot = new Slot();
    Droga(int id, int pozx, int pozy, int rotate) {
        this.id = id;
        this.pozx = pozx;
        this.pozy = pozy;
        this.rotate = rotate;
    }
}
