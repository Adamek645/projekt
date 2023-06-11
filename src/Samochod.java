public class Samochod extends Pojazd {
    int kx, ky;

    Samochod(int vmax, int kx, int ky) {
        super(vmax);
        setVmax(vmax);
        this.kx = kx;
        this.ky = ky;
    }
/*
    public void ruch() {
        z obecnych koordynatów pojazdu oraz jego prędkości przemieść się do przodu o taką ilość koordynatów na liście
    }
    public void tura(plus sprawdzenie kolizji)(){
        if(koordnynaty pojazdu + tyle ile przebędzie ze swoją prędkością są zajęte !! Są puste)
        to zatrzymaj się do koordynatu najbliższego co do zajętego
        W przeciwnym wypadku wykonaj ruch
    }
 */
}