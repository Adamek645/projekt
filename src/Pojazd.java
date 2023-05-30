public class Pojazd {
        int vmax;
        float v;
        static int id;
        float pojazdUmowny;
        Pojazd(int vmax){
                vmax = this.vmax;
        }
        public void setVmax(int vmax) {
                if (vmax >= 0) {
                        this.vmax = vmax;
                }
        }
}
