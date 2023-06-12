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
    public static <P> void setMap(int x, int y, P obiekt){
        if (!istnieje(x, y))
            return;
        mapa[x][y] = (Pojazd)obiekt;
    }
    public static Pojazd getMap(int x, int y){
        if (!istnieje(x, y))
            return null;
        return mapa[x][y];
    }
    public static void see(){
        for(int i = 0; i < wielX; i++){
            for (int j = 0; j < wielY; j++){
                if(getMap(i,j)== null)
                    System.out.print(" O ");
                else System.out.print(" X ");
            }
            System.out.println("");
        }
    }

    public static Boolean mapContents(){
        for(int i = 0; i < wielX; i++){
            for (int j = 0; j < wielY; j++){
                if(getMap(i,j)!= null)
                    return true;
            }
        }
        return false;
    }
}