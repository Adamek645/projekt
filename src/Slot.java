public class Slot {
    private int id;
    private int rodzaj;
    private int kierunek;
    Slot(int id, int rodzaj, int kierunek){
        this.id = id;
        this.rodzaj = rodzaj;
        this.kierunek = kierunek;
    }
    public int getSlotId() { return id; }
    public int getSlotRodzaj() { return rodzaj; }
    public int getSlotKierunek() { return kierunek; }
}
