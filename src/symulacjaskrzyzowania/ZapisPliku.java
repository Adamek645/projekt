package symulacjaskrzyzowania;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasa umożliwiająca zapis danych wygenerowanych przez program do pliku tekstowego.
 */
public class ZapisPliku {
    static int cykl = 1;

    /**
     * Konstruktor sprawdzający istnienie pliku
     */
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

    /**
     * Funkcja umożlwiająca zapis uzyskanych danych z jednego cyklu do pliku.
     * @param a Liczba pojazdów, która została wygenerowana w jednym cyklu.
     * @param b Wartość pojazdów umownych w ciągu danego cyklu.
     * @param c Czas przebiegu cyklu.
     */
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

    /**
     * Funkcja umożliwia wpisanie danych końcowych do pliku tekstowego.
     * @param a Liczba pojazdów, która została wygenerowana w trakcie uruchomienia programu.
     * @param b Wartość pojazdów umownych w trakcie trwania programu (w tym przypadku E/h).
     * @param c Czas wszystkich cykli razem.
     * @param d Mimnimalna przepustowość w jednym cyklu odnotowana w trakcie działania programu.
     * @param f Maksymalna przepustowość w jednym cyklu odnotowana w trakcie działania programu.
     */
    public static void zapisCalosci(int a, double b, double c, double d, double f) {
        try {
            FileWriter writer = new FileWriter("dane.txt", true);

            writer.write("Liczba pojazdów w godzinę: " + a + "\n");
            writer.write("Przepustowość skrzyżowania: " + b / 100 + " E/h\n");
            writer.write("Czas pełnego przebiegu: " + c / 10 + " s\n\n");
            writer.write("Minimalna przepustowość w trakcie jednego cyklu: " + d / 100 + " E/h\n");
            writer.write("Maksymalna przepustowość w trakcie jednego cyklu: " + f / 100 + " E/h\n");
            writer.close();
            System.out.println("Dane zostały zapisane.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
