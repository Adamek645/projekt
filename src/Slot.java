public class Slot {
    private int id;
    private int rodzaj;
    private int kierunek;
    Slot(int id, int rodzaj, int kierunek){
        this.id = id;
        this.rodzaj = rodzaj;
        this.kierunek = kierunek;
    }
    public int getId() { return id; }
    public int getRodzaj() { return rodzaj; }
    public int getKierunek() { return kierunek; }
}
