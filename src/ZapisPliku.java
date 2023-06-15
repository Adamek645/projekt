import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ZapisPliku{

    ZapisPliku()throws IOException {
        try{
            File dane = new File("dane.txt");
            if (dane.createNewFile()) {
                System.out.println("Plik stworzony: " + dane.getName());
            } else {
                dane.delete();
                dane.createNewFile();
                System.out.println("Plik już istnieje więc został wyczyszczony");
            }
        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void zapis(int a, double b, double c)  {
        try{
                FileWriter writer = new FileWriter("dane.txt", true);
                writer.write("Number of vehicles: "+ a + "\n");
                writer.write("Number of points: " + b + "\n");
                writer.write("Time: " + c + "\n");
                writer.close();
                System.out.println("Dane zostały zapisane.");

        } catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
