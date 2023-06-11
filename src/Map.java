public class Map{
    private static Pojazd[][] mapa;
    private static int wielX, wielY;
    Map(int wielX, int wielY){
        mapa = new Pojazd[wielX][wielY];
        Map.wielX = wielX;
        Map.wielY = wielY;
    }
    public static Boolean istnieje(int x, int y){
        if ((x < 0) || (x >= wielX) || (y < 0) || (y >= wielY))
            return false;
        return true;
    }
    public static <T> void setMap(int x, int y, T obiekt){
        if (!istnieje(x, y))
            return;
        mapa[x][y] = (Pojazd)obiekt;
    }
    public static Pojazd getMap(int x, int y){
        if (!istnieje(x, y))
            return null;
        return mapa[x][y];
    }
}