import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Pojazd {
        int vmax,kx,ky;
        float v;
        int id;
        float pojazdUmowny;
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
        public static void ruchPojazdu(){
        }

        public void setVmax(int vmax) {
                if (vmax >= 0) {
                        this.vmax = vmax;
                }
        }
}
