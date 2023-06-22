package symulacjaskrzyzowania;

/**
 * Klasa tworząca mapę i weryfikująca położenie pojazdów na niej
 */
public class Map {
    private static Pojazd[][] mapa;
    private static int wielX, wielY;

    /**
     * Konstruktor mapy
     * @param wielX Wielkość mapy w osi x
     * @param wielY Wielkość mapy w osi y
     */
    Map(int wielX, int wielY) {
        mapa = new Pojazd[wielX + 1][wielY + 1];
        Map.wielX = wielX;
        Map.wielY = wielY;
    }

    /**
     * Sprawdzenie istnienie pojazdu na danej pozycji
     * @param x Pozycja x
     * @param y Pozycja y
     * @return Weryfikacja istnienia mapy
     */
    public static Boolean istnieje(int x, int y) {
        if ((x < 0) || (x > wielX) || (y < 0) || (y > wielY)) {
            return false;
        }
        return true;
    }

    /**
     * Funkcja odpowiadająca za położenie nowego pojazdu na mapie
     * @param x Pozycja x na której ma zostać wygenerowany pojazd
     * @param y Pozycja y na której ma zostać wygenerowany pojazd
     * @param obiekt org.projektsymulacyjny.skryzowanie.symulacjaskrzyzowania.Pojazd, który powstał
     * @param <P> Klasa obiektu
     */
    public static <P> void setMap(int x, int y, P obiekt) {
        if (!istnieje(x, y)) {
            return;
        }
        mapa[x][y] = (Pojazd) obiekt;
    }

    /**
     * Funkcja zwracająca pozycję pojazdu
     * @param x Pozycja x
     * @param y Pozycja y
     * @return Pozycja pojazdu na mapie
     */
    public static Pojazd getMap(int x, int y) {
        if (!istnieje(x, y))
            return null;
        return mapa[x][y];
    }

    /**
     * Funkcja czyszcząca mapę
     */
    public static void mapClear() {
        for (int i = 0; i <= wielX; i++) {
            for (int j = 0; j <= wielY; j++) {
                setMap(i, j, null);
            }
        }
    }

    /**
     * Funkcja sprawdzająca czy na mapie są jeszcze pojazdy
     * @return Wynik funkcji
     */
    public static Boolean mapContents() {
        for (int i = 0; i < wielX; i++) {
            for (int j = 0; j < wielY; j++) {
                if (getMap(i, j) != null) {
                    return true;
                }
            }
        }
        return false;
    }
}