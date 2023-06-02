import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Sciezka {
    private int drogaWe;
    private int slotWe;
    private int drogaWy;
    private int slotWy;
    private double dlugosc;
    Sciezka (int drogaWe, int slotWe, int drogaWy, int slotWy, double dlugosc) {
        this.drogaWe = drogaWe;
        this.slotWe = slotWe;
        this.drogaWy = drogaWy;
        this.slotWy = slotWy;
        this.dlugosc = dlugosc;
    }
    public int getDrogaWe() {
        return drogaWe;
    }
    public int getSlotWe() {
        return slotWe;
    }
    public int getDrogaWy() {
        return drogaWy;
    }
    public int getSlotWy() {
        return slotWy;
    }
    public double getPoz(Skrzyzowanie skrzyzowanie, int droga, int pole) {
        return skrzyzowanie.getDrogi(droga, pole);
    }
    public double dlugoscSciezki(Skrzyzowanie skrzyzowanie, Sciezka sciezka) {
        double rotWe = getPoz(skrzyzowanie, sciezka.getDrogaWe(), 3);
        double rotWy = getPoz(skrzyzowanie, sciezka.getDrogaWy(), 3);
        double moveWe = -1.5 + slotWe*3;
        double moveWy = -1.5 + slotWy*3;
        double x1 = getPoz(skrzyzowanie, sciezka.getDrogaWe(), 1);
        double x2 = getPoz(skrzyzowanie, sciezka.getDrogaWy(), 1);
        double y1 = getPoz(skrzyzowanie, sciezka.getDrogaWe(), 1);
        double y2 = getPoz(skrzyzowanie, sciezka.getDrogaWy(), 1);
        if(rotWe == 90) {
            y1 = y1 + moveWe;
        } else if (rotWe == 180) {
            x1 = x1 - moveWe;
        } else if (rotWe == 270) {
            y1 = y1 - moveWe;
        } else if (rotWe == 0) {
            x1 = x1 + moveWe;
        }
        if(rotWy == 90) {
            y2 = y2 + moveWy;
        } else if (rotWy == 180) {
            x2 = x2 - moveWy;
        } else if (rotWy == 270) {
            y2 = y2 - moveWy;
        } else if (rotWy == 0) {
            x2 = x2 + moveWy;
        }
        if(x1 != x2) {
            if (y1 == y2) {
                if (x1 <= 0 && x2 > 0)
                    return abs(x1) + x2;
                else if (x1 > 0 && x2 > 0)
                    return abs(x2 - x1);
                else if (x1 <= 0 && x2 < 0)
                    return abs(x2 - x1);
            }
            if (y1 != y2) { // dodatkowo uwzględniono współczynnik zmieniający kształt, docelowo będzie obliczany
                double xsqrt = 0;
                double ysqrt = 0;
                if (x1 <= 0 && x2 > 0)
                    xsqrt = (abs(x1) + x2) * (abs(x1) + x2);
                else if (x1 > 0 && x2 > 0)
                    xsqrt = (abs(x2 - x1) * abs(x2 - x1));
                else if (x1 <= 0 && x2 < 0)
                    xsqrt = (abs(x2 - x1) * abs(x2 - x1));
                if (y1 <= 0 && y2 > 0)
                    xsqrt = (abs(y1) + y2) * (abs(y1) + y2);
                else if (x1 > 0 && x2 > 0)
                    xsqrt = (abs(y2 - y1) * abs(y2 - y1));
                else if (x1 <= 0 && x2 < 0)
                    xsqrt = (abs(y2 - y1) * abs(y2 - y1));
                return sqrt(xsqrt + ysqrt) * 1.3;
            }
        } else if (x1 == x2) {
            if (y1 == y2)
                return 0;
            else {
                if (y1 <= 0 && y2 > 0)
                    return abs(y1) + y2;
                else if (y1 > 0 && y2 > 0)
                    return abs(y2 - y1);
                else if (y1 <= 0 && x2 < 0)
                    return abs(y2 - y1);
            }
        }
        return 0;
    }
}
