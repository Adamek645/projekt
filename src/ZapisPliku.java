import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ZapisPliku {
    static int cykl = 1;

    ZapisPliku() throws IOException {
        try {
            File dane = new File("dane.txt");
            if (dane.createNewFile()) {
                System.out.println("Plik stworzony: " + dane.getName());
            } else {
                dane.delete();
                dane.createNewFile();
                System.out.println("Plik już istnieje, więc został wyczyszczony");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void zapis(int a, double b, double c) {
        try {
            FileWriter writer = new FileWriter("dane.txt", true);
            writer.write("Cykl nr " + cykl + "\n");
            writer.write("Liczba pojazdów: " + a + "\n");
            writer.write("Wartość pojazdów umownych w cyklu: " + b / 100 + " E/cykl\n");
            writer.write("Czas pełnego cyklu świateł: " + c / 10 + " s\n\n");
            writer.close();
            cykl++;
            System.out.println("Dane zostały zapisane.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void zapisCalosci(int a, double b, double c, double d, double f) {
        try {
            FileWriter writer = new FileWriter("dane.txt", true);

            writer.write("Liczba pojazdów w godzinę: " + a + "\n");
            writer.write("Przepustowość skrzyżowania: " + b / 100 + " E/h\n");
            writer.write("Czas pełnego przebiegu: " + c / 10 + " s\n\n");
            writer.write("Minimalna przepustowość w trakcie jednego cyklu: " + d / 100 + " s\n");
            writer.write("Maksymalna przepustowość w trakcie jednego cyklu: " + f / 100 + " s\n");
            writer.close();
            System.out.println("Dane zostały zapisane.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
