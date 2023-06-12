import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Pojazd {
        int vmax;
        protected int x,y,C;
        int droga[][];
        float v;
        static List<Pojazd> List= new LinkedList<>();
        Pojazd(int vmax,int droga [][]){
                this.vmax = vmax;
                this.droga = droga;
                this.x = droga[0][0];
                this.y = droga[1][0];
                this.C = 0;
        }
        static List<Pojazd> getList() {
                return List;
        }
        public static void clearList(){
                List.clear();
        }
        public void ruchPojazdu(){
                if(this.kolizjaPojazdu()) {
                        Map.setMap(this.droga[0][this.C + 1], this.droga[1][this.C + 1], Map.getMap(this.x, this.y));
                        Map.setMap(this.x, this.y, null);
                        this.C++;
                        this.x = this.droga[0][this.C];
                        this.y = this.droga[1][this.C];
                }
        }
        public Boolean kolizjaPojazdu(){
                if(Map.getMap(this.droga[0][this.C + 1],this.droga[1][this.C + 1]) == null)
                        return true;
                return false;
        }
        public void setVmax(int vmax) {
                if (vmax >= 0) {
                        this.vmax = vmax;
                }
        }
        public void  setDroga(int droga[][]){
                this.droga = droga;
        }
}
