import java.util.LinkedList;
import java.util.List;

public class Pojazd {
        int vmax;
        protected int x,y;
        float v;
        static List<Pojazd> List= new LinkedList<>();
        Pojazd(int vmax){
                vmax = this.vmax;
        }
        static List<Pojazd> getList() {
                return List;
        }
        public static void clearList(){
                List.clear();
        }
        public void ruchPojazdu(int x, int y){
                Map.setMap(x, y, Map.getMap(this.x, this.y));
                Map.setMap(this.x, this.y, null);
                this.setPlace(x, y);
        }
        public Boolean kolizjaPojazdu(int x, int y){
                if(Map.getMap(x,y) == null)
                        return false;
                return true;
        }
        public void setVmax(int vmax) {
                if (vmax >= 0) {
                        this.vmax = vmax;
                }
        }
        public void setPlace(int x, int y) {
                this.x = x;
                this.y = y;
        }
}
