import java.awt.*;
import java.io.File;

public class WyborPliku {
    public static String plik() {
        Frame wybor = new Frame ("Okno macierzyste");
        wybor.setBounds(20,20,400,500);
        wybor.setVisible(false);
        FileDialog fd = new FileDialog(wybor,"Wczytaj", FileDialog.LOAD);
        fd.setVisible(true);
        return fd.getFile();
    }
}
