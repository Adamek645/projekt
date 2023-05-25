import java.io.File;

public class Main {

    public static void main(String[] args) {
        Skrzyzowanie skrzyzowanie = new Skrzyzowanie();
        Symulacja symulacja = new Symulacja();
        Symulacja.symulacja(skrzyzowanie);
    }
}