import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Sciezka {
    private int drogaWe;
    private int slotWe;
    private int drogaWy;
    private int slotWy;
    private int[][] sciezka;
    private int p;
    Sciezka (int drogaWe, int slotWe, int drogaWy, int slotWy, int[][] sciezka, int p) {
        this.drogaWe = drogaWe;
        this.slotWe = slotWe;
        this.drogaWy = drogaWy;
        this.slotWy = slotWy;
        this.sciezka = sciezka;
        this.p = p;
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
    public int[][] getSciezka() {return sciezka;}
    public int getP() {return p;}
    public static int getPoz(Skrzyzowanie skrzyzowanie, int droga, int pole) {
        return skrzyzowanie.getDrogi(droga, pole);
    }
    public static int getSlot(Skrzyzowanie skrzyzowanie, int droga, int slot, int pole) {
        return skrzyzowanie.getSloty(droga, slot, pole);
    }
    public static int rot(int x, int y, int rot, int move) {
        if(rot == 90) {
            return y - move;
        } else if (rot == 180) {
            return x - move;
        } else if (rot == 270) {
            return y + move;
        } else if (rot == 0) {
            return x + move;
        }
        return 0;
    }
    public static int[] poz1 (int x, int y) {
        return new int[]{x, y};
    }
    public static int[] poz21 (int x, int y, int rotWe, int rotWy, int x0, int y0, int r) {
        if(rotWe == 90) {
            if (rotWy == 180) {
                double yt = y0-sqrt(-x*x+2*x*x0-x0*x0+r*r);
                System.out.println(yt);
                y = (int)yt;
                System.out.println(y);
                return new int[]{x,y};
            }
            if (rotWy == 270) {
                return new int[]{x+1,y};
            }
            if (rotWy == 0) {
                double yt = y0+sqrt(-x*x+2*x*x0-x0*x0+r*r);
                y = (int)yt;
                return new int[]{x,y};
            }
        } else if(rotWe == 180) {
            if (rotWy == 90) {
                double xt = x0+sqrt(-y*y+2*y*y0-y0*y0+r*r);
                x = (int)xt;
                return new int[]{x,y};
            }
            if (rotWy == 0) {
                return new int[]{x, y-1};
            }
            if (rotWy == 270) {
                double xt = x0-sqrt(-y*y+2*y*y0-y0*y0+r*r);
                x = (int)xt;
                return new int[]{x,y};
            }
        } else if(rotWe == 270) {
            if (rotWy == 0) {
                double yt = y0 + sqrt(-x * x + 2 * x * x0 - x0 * x0 + r * r);
                y = (int) yt;
                return new int[]{x, y};
            }
            if (rotWy == 90) {
                return new int[]{x - 1, y};
            }
            if (rotWy == 180) {
                double yt = y0 - sqrt(-x * x + 2 * x * x0 - x0 * x0 + r * r);
                y = (int) yt;
                return new int[]{x, y};
            }
        } else if(rotWe == 0) {
            if (rotWy == 90) {
                double xt = x0+sqrt(-y*y+2*y*y0-y0*y0+r*r);
                x = (int)xt;
                return new int[]{x,y};
            }
            if (rotWy == 180) {
                return new int[]{x, y+1};
            }
            if (rotWy == 270) {
                double xt = x0-sqrt(-y*y+2*y*y0-y0*y0+r*r);
                x = (int)xt;
                return new int[]{x,y};
            }
        }
        return new int[]{0,0};
    }
    public static int[] poz22 (int x, int y, int rotWe, int rotWy, int x0, int y0, int r) {
        if(rotWe == 90) {
            if (rotWy == 180) {
                double xt = x0+sqrt(-y*y+2*y*y0-y0*y0+r*r);
                x = (int)xt;
                return new int[]{x,y};
            }
            if (rotWy == 0) {
                double xt = x0+sqrt(-y*y+2*y*y0-y0*y0+r*r);
                x = (int)xt;
                return new int[]{x,y};
            }
        }
        if(rotWe == 180) {
            if (rotWy == 90) {
                double yt = y0-sqrt(-x*x+2*x*x0-x0*x0+r*r);
                y = (int)yt;
                return new int[]{x,y};
            }
            if (rotWy == 270) {
                double yt = y0-sqrt(-x*x+2*x*x0-x0*x0+r*r);
                y = (int)yt;
                return new int[]{x,y};
            }
        }
        if(rotWe == 270) {
            if (rotWy == 180) {
                double xt = x0-sqrt(-y*y+2*y*y0-y0*y0+r*r);
                x = (int)xt;
                return new int[]{x,y};
            }
            if (rotWy == 0) {
                double xt = x0-sqrt(-y*y+2*y*y0-y0*y0+r*r);
                x = (int)xt;
                return new int[]{x,y};
            }
        }
        if(rotWe == 0) {
            if (rotWy == 90) {
                double yt = y0+sqrt(-x*x+2*x*x0-x0*x0+r*r);
                y = (int)yt;
                return new int[]{x,y};
            }
            if (rotWy == 270) {
                double yt = y0+sqrt(-x*x+2*x*x0-x0*x0+r*r);
                y = (int)yt;
                return new int[]{x,y};
            }
        }
        return new int[]{0,0};
    }
    public static void obliczanieSciezki(Skrzyzowanie skrzyzowanie, int drogaWe, int slotWe, int drogaWy, int slotWy, ArrayList<int[]> sciezka) {
        int rotWe = getPoz(skrzyzowanie, drogaWe, 3);
        int rotWy = getPoz(skrzyzowanie, drogaWy, 3);
        int moveWe = -15 + slotWe*30;
        int moveWy = -15 + slotWy*30;
        int x1 = getPoz(skrzyzowanie, drogaWe, 1);
        int x2 = getPoz(skrzyzowanie, drogaWy, 1);
        int y1 = getPoz(skrzyzowanie, drogaWe, 2);
        int y2 = getPoz(skrzyzowanie, drogaWy, 2);
        if(rotWe == 90 || rotWe == 270) {
            y1 = rot(x1,y1,rotWe,moveWe);
        } else if (rotWe == 0 || rotWe == 180) {
            x1 = rot(x1,y1,rotWe,moveWe);
        }
        if(rotWy == 90 || rotWy == 270) {
            y2 = rot(x2,y2,rotWy,moveWy);
        } else if (rotWy == 0 || rotWy == 180) {
            x2 = rot(x2,y2,rotWy,moveWy);
        }
        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 + " " + rotWe + " " + rotWy);
        int x = x1; int y = y1;
        int[] tab = new int[] {x1, y1};
        if(rotWe == 90) {
            for (; x < 149; x++) {
                    tab = poz1(x,y);
                    sciezka.add(tab);
            }
            if (rotWy == 180) {
                if (450-y1>x2-150) {
                    int r = x2-150; int x0 = 150; int y0 = y1-r;
                    double r2 = r*0.707;
                    int r3 = (int)r2;
                    for (; tab[0] < x0+r3; x++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y++;
                    for (; y <= y0; y++) {
                        tab = poz22(x,y,rotWe, rotWy, x0,y0,r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (450-y1 == x2-150) {
                    int r = x2-150; int x0 = 150; int y0 = 450;
                    double r2 = r*0.707;
                    int r3 = (int)r2;
                    for (; tab[0] < x0+r3; x++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y++;
                    for (; y <= y0; y++) {
                        tab = poz22(x,y,rotWe, rotWy, x0,y0,r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (450-y1<x2-150) {
                    int r = 450 - y1; int x0 = x2-r; int y0 = 450;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; x < x0; x++){
                        tab = poz1(x,y);
                        sciezka.add(tab);
                    }
                    System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                    for (; tab[0] < x0 + r3; x++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y++;
                    for (; y <= y0; y++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                for(; y < 601; y++) {
                    tab = poz1(x,y);
                    sciezka.add(tab);
                }
            }
            if (rotWy == 270) {
                for(; x < 601; x++) {
                    tab = poz1(x,y);
                    sciezka.add(tab);
                }
            }
            if (rotWy == 0) {
                if (y1-150>x2-150) {
                    int r = x2-150; int x0 = 150; int y0 = y1-r;
                    double r2 = r*0.707;
                    int r3 = (int)r2;
                    for (; tab[0] < x0+r3; x++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y--;
                    for (; y >= y0; y--) {
                        tab = poz22(x,y,rotWe, rotWy, x0,y0,r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (y1-150 == x2-150) {
                    int r = x2-150; int x0 = 150; int y0 = 150;
                    double r2 = r*0.707;
                    int r3 = (int)r2;
                    for (; tab[0] < x0+r3; x++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y--;
                    for (; y >= y0; y--) {
                        tab = poz22(x,y,rotWe, rotWy, x0,y0,r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                for(; y >= 0; y--) {
                    tab = poz1(x,y);
                    sciezka.add(tab);
                }
            }
        } else if (rotWe == 180) {
            for (; y > 450; y--) {
                tab = poz1(x,y);
                sciezka.add(tab);
            }
            if (rotWy == 270) {
                if (450 - y1 > 450 - x2) {
                    int r = 450 - y2;
                    int x0 = x1 + r;
                    int y0 = 450;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[1] > y0 - r3; y--) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y--;
                    for (; x <= x0; x++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (450 - y1 == 450 - x2) {
                    int r = x2 - (x1 + 150);
                    int x0 = 450;
                    int y0 = 450;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[1] < y0 - r3; y--) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y--;
                    for (; x <= x0; x++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (450 - y1 < 450 - x2) {
                    int r = x2 - (x1 + 150);
                    int x0 = 450;
                    int y0 = y1 - (y2 + 150);
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; y > y0; y--) {
                        tab = poz1(x, y);
                        sciezka.add(tab);
                    }
                    System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                    for (; tab[1] > y0 - r3; y--) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y--;
                    for (; x <= x0; x++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                for (; x < 601; x++) {
                    tab = poz1(x, y);
                    sciezka.add(tab);
                }
            }
            if (rotWy == 90) {
                    if (x1 - 150 > 450 - y2) {
                        int r = 450-y2;
                        int x0 = x1-r;
                        int y0 = 450;
                        double r2 = r * 0.707;
                        int r3 = (int) r2;
                        for (; tab[1] > y0 - r3; y--) {
                            tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                            x = tab[0];
                            System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                            sciezka.add(tab);
                        }
                        x--;
                        y--;
                        for (; x >= x0; x--) {
                            tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                            y = tab[1];
                            System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                            sciezka.add(tab);
                        }
                    }
                    if (x1 - 150 == 450 - y2) {
                        int r = x1 - 150;
                        int x0 = 150;
                        int y0 = 450;
                        double r2 = r * 0.707;
                        int r3 = (int) r2;
                        for (; tab[1] > y0 - r3; y--) {
                            tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                            x = tab[0];
                            System.out.println("2 | " + tab[0] + " " + tab[1] + " | " + x + " " + y);
                            sciezka.add(tab);
                        }
                        x--;
                        y--;
                        for (; x >= x0; x--) {
                            tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                            y = tab[1];
                            System.out.println("2b | " + tab[0] + " " + tab[1] + " | " + x + " " + y);
                            sciezka.add(tab);
                        }
                    }
                    if (x1 - 150 < 450 - y2) {
                        int r = x1 - 150;
                        int x0 = 150;
                        int y0 = y2 + r;
                        double r2 = r * 0.707;
                        int r3 = (int) r2;
                        for (; y > y0; y--) {
                            tab = poz1(x, y);
                            sciezka.add(tab);
                        }
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        for (; tab[1] > y0 - r3; y--) {
                            tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                            x = tab[0];
                            System.out.println("3a | " + tab[0] + " " + tab[1] + " | " + x + " " + y);
                            sciezka.add(tab);
                        }
                        x--;
                        y--;
                        for (; x >= x0; x--) {
                            tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                            y = tab[1];
                            System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                            sciezka.add(tab);
                        }
                    }
                    for (; x >= 0; x--) {
                        tab = poz1(x, y);
                        sciezka.add(tab);
                    }
                }
            if (rotWy == 0) {
                    for(; y >= 0; y--) {
                        tab = poz1(x,y);
                        sciezka.add(tab);
                    }
                }
        } else if (rotWe == 270) {
            for (; x > 450; x--) {
                tab = poz1(x,y);
                sciezka.add(tab);
            }
            if (rotWy == 180) {
                if (450 - y1 < 450 - x2) {
                    int r = x1 - (x2+150);
                    int x0 = 450;
                    int y0 = y1 + r;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[1] > x0 - r3; x--) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x--;
                    y++;
                    for (; y <= y0; y++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (450 - y1 == 450 - x2) {
                    int r = x1 - (x2 + 150);
                    int x0 = 450;
                    int y0 = 450;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[1] > x0 - r3; x--) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x--;
                    y++;
                    for (; y <= y0; y++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (450 - y1 > 450 - x2) {
                    int r = y2 - (y1 + 150);
                    int x0 = x2 - (r + 150);
                    int y0 = 450;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; x > x0; x--) {
                        tab = poz1(x, y);
                        sciezka.add(tab);
                    }
                    for (; tab[1] > x0 - r3; x--) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x--;
                    y++;
                    for (; y <= y0; y++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                for (; y < 601; y++) {
                    tab = poz1(x, y);
                    sciezka.add(tab);
                }
            }
            if (rotWy == 0) {
                if (y1 - 150 > 450 - x2) {
                    int r = 450-x2;
                    int x0 = 450;
                    int y0 = y1-r;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[0] < x0 - r3; x--) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x--;
                    y--;
                    for (; y >= y0; y--) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (y1 - 150 == 450 - x2) {
                    int r = y1 - 150;
                    int x0 = 450;
                    int y0 = 150;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[0] < x0 - r3; x--) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x--;
                    y--;
                    for (; y >= y0; y--) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (y1 - 150 < 450 - x2) {
                    int r = x1 - 150;
                    int x0 = 150;
                    int y0 = y2 + r;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; x > x0; x--) {
                        tab = poz1(x, y);
                        sciezka.add(tab);
                    }
                    for (; tab[0] < x0 - r3; x--) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x--;
                    y--;
                    for (; y >= y0; y--) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                for (; y >= 0; y--) {
                    tab = poz1(x, y);
                    sciezka.add(tab);
                }
            }
            if (rotWy == 90) {
                for(; x >= 0; x--) {
                    tab = poz1(x,y);
                    sciezka.add(tab);
                }
            }
        } else if (rotWe == 0) {
            for (; y < 149; y++) {
                tab = poz1(x,y);
                sciezka.add(tab);
            }
            if (rotWy == 90) {
                if (x1 - 150 > y2 - 150) {
                    int r = y2 - 150;
                    int x0 = x1 - r;
                    int y0 = 150;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[1] < y0 + r3; y++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x--;
                    y++;
                    for (; x >= x0; x--) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (x1 - 150 == y2 - 150) {
                    int r = x2-150;
                    int x0 = 150;
                    int y0 = 150;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[1] < y0 + r3; y++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x--;
                    y++;
                    for (; x >= x0; x--) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (x1 - 150 < y2 - 150) {
                    int r = y1-150;
                    int x0 = 150;
                    int y0 = y1-r;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; y > y0; y--) {
                        tab = poz1(x, y);
                        sciezka.add(tab);
                    }
                    System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                    for (; tab[1] < y0 + r3; y++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x--;
                    y++;
                    for (; x >= x0; x--) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                for (; x >= 0; x--) {
                    tab = poz1(x, y);
                    sciezka.add(tab);
                }
                }
            if (rotWy == 270) {
                if (450 - x1 > y2 - 150) {
                    int r = y2-150;
                    int x0 = x1+r;
                    int y0 = 150;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[1] > y0 + r3; y++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y++;
                    for (; x <= x0; x++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (450 - x1 == y2 - 150) {
                    int r = y2 - 150;
                    int x0 = 450;
                    int y0 = 150;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; tab[1] < y0 + r3; y++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y++;
                    for (; x <= x0; x++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                if (450 - x1 < y2 - 150) {
                    int r = 450 - x1;
                    int x0 = 450;
                    int y0 = y2 - r;
                    double r2 = r * 0.707;
                    int r3 = (int) r2;
                    for (; y > y0; y--) {
                        tab = poz1(x, y);
                        sciezka.add(tab);
                    }
                    System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                    for (; tab[1] > y0 + r3; y++) {
                        tab = poz21(x, y, rotWe, rotWy, x0, y0, r);
                        x = tab[0];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                    x++;
                    y++;
                    for (; x <= x0; x++) {
                        tab = poz22(x, y, rotWe, rotWy, x0, y0, r);
                        y = tab[1];
                        System.out.println(tab[0] + " " + tab[1] + " | " + x + " " + y);
                        sciezka.add(tab);
                    }
                }
                for (; x < 601; x++) {
                    tab = poz1(x, y);
                    sciezka.add(tab);
                }
            }
            if (rotWy == 0) {
                for(; y < 601; y++) {
                    tab = poz1(x,y);
                    sciezka.add(tab);
                }
            }
        }
    }
    public static void dodanieSciezki(Skrzyzowanie skrzyzowanie, List<Sciezka> sciezki) throws FileNotFoundException {
        Scanner wejscie = new Scanner(System.in);
        int drogaWe = 0;
        int slotWe = 0;
        int drogaWy = 0;
        int slotWy = 0;
        int p = 0;
        File plikSciezka = new File("sciezki.txt");
        Scanner in = new Scanner(plikSciezka);
        if(in.nextLine().equals("[sciezki]")){
            in.nextLine();
            for (int left = 0; left == 0; ) {
                if (in.hasNext()) {
                    if (in.nextLine().equals("[sciezka]")) {
                        drogaWe = in.nextInt();
                        slotWe = in.nextInt();
                        drogaWy = in.nextInt();
                        slotWy = in.nextInt();
                        p = in.nextInt();
                        ArrayList<int[]> listsciezka = new ArrayList<>();
                        obliczanieSciezki(skrzyzowanie, drogaWe, slotWe, drogaWy, slotWy, listsciezka);
                        int[][] tabsciezka = new int[listsciezka.size()][2];
                        listsciezka.toArray(tabsciezka);
                        Sciezka sciezka = new Sciezka(drogaWe, slotWe, drogaWy, slotWy, tabsciezka, p);
                        sciezki.add(sciezka);
                        if(in.hasNext())
                            in.nextLine();
                        if(in.hasNext())
                            in.nextLine();
                    } else {
                        System.out.println(in.nextLine());
                        left++;
                        System.out.println("tak");
                    }
                } else {
                    break;
                }
            }
            System.out.print("Czy chcesz zobaczyc liste sciezek? (Tak/Nie): ");
            String test;
            test = wejscie.nextLine();
            if (test.equals("Tak")) {
                for (int i = 0; i < sciezki.size(); i++)
                    System.out.println("Sciezka nr " + i + ":\nWejscie: droga " + sciezki.get(i).drogaWe + " slot " +
                            sciezki.get(i).slotWe + "\n" + "Wyjscie: droga " + sciezki.get(i).drogaWy +  " slot " + sciezki.get(i).slotWy + "\n o dlugosci " +
                            sciezki.get(i).sciezka.length);
                }
        }
    }
}