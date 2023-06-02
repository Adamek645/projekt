import java.util.List;
import java.util.Scanner;

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
    public static double getPoz(Skrzyzowanie skrzyzowanie, int droga, int pole) {
        return skrzyzowanie.getDrogi(droga, pole);
    }
    public static double getSlot(Skrzyzowanie skrzyzowanie, int droga, int slot, int pole) {
        return skrzyzowanie.getSloty(droga, slot, pole);
    }
    public static double dlugoscSciezki(Skrzyzowanie skrzyzowanie, int drogaWe, int slotWe, int drogaWy, int slotWy) { // nie uwzględniamy przypadku, gdy x i y są na różnych wyskościach, ale w tą samą stronę
        double rotWe = getPoz(skrzyzowanie, drogaWe, 3);
        double rotWy = getPoz(skrzyzowanie, drogaWy, 3);
        double moveWe = -1.5 + slotWe*3;
        double moveWy = -1.5 + slotWy*3;
        double x1 = getPoz(skrzyzowanie, drogaWe, 1);
        double x2 = getPoz(skrzyzowanie, drogaWy, 1);
        double y1 = getPoz(skrzyzowanie, drogaWe, 2);
        double y2 = getPoz(skrzyzowanie, drogaWy, 2);
        if(rotWe == 90) {
            y1 = y1 - moveWe;
        } else if (rotWe == 180) {
            x1 = x1 - moveWe;
        } else if (rotWe == 270) {
            y1 = y1 + moveWe;
        } else if (rotWe == 0) {
            x1 = x1 + moveWe;
        }
        if(rotWy == 90) {
            y2 = y2 - moveWy;
        } else if (rotWy == 180) {
            x2 = x2 - moveWy;
        } else if (rotWy == 270) {
            y2 = y2 + moveWy;
        } else if (rotWy == 0) {
            x2 = x2 + moveWy;
        }
        System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
        if(x1 != x2) {
            if (y1 == y2) {
                if (x1 <= 0 && x2 > 0)
                    return abs(x1) + x2;
                else if (x1 > 0 && x2 >= 0)
                    return abs(x2 - x1);
                else if (x1 <= 0 && x2 < 0)
                    return abs(x2 - x1);
            }
            if (y1 != y2) { // dodatkowo uwzględniono współczynnik zmieniający kształt, docelowo będzie obliczany
                double xsqrt = 0;
                double ysqrt = 0;
                if (x1 <= 0 && x2 >= 0)
                    xsqrt = (abs(x1) + x2) * (abs(x1) + x2);
                else if (x1 > 0 && x2 >= 0)
                    xsqrt = (abs(x2 - x1) * abs(x2 - x1));
                else if (x1 > 0 && x2 <= 0)
                    xsqrt = (abs(x1 - x2) * abs(x1 - x2));
                else if (x1 <= 0 && x2 < 0)
                    xsqrt = (abs(x2 - x1) * abs(x2 - x1));
                if (y1 <= 0 && y2 >= 0)
                    ysqrt = (abs(y1) + y2) * (abs(y1) + y2);
                else if (y1 > 0 && y2 >= 0)
                    ysqrt = (abs(y2 - y1) * abs(y2 - y1));
                else if (y1 > 0 && y2 <= 0)
                    ysqrt = (abs(y1 - y2) * abs(y1 - y2));
                else if (y1 <= 0 && y2 < 0)
                    ysqrt = (abs(y2 - y1) * abs(y2 - y1));
                System.out.println(xsqrt + " " + ysqrt);
                return sqrt(xsqrt + ysqrt) * 1.3;
            }
        } else if (x1 == x2) {
            if (y1 == y2)
                return 0;
            else {
                if (y1 <= 0 && y2 > 0)
                    return abs(y1) + y2;
                else if (y1 > 0 && y2 >= 0)
                    return abs(y2 - y1);
                else if (y1 <= 0 && x2 < 0)
                    return abs(y2 - y1);
            }
        }
        return 0;
    }
    public static void dodanieSciezki(Skrzyzowanie skrzyzowanie, List<Sciezka> sciezki) {
        Scanner wejscie = new Scanner(System.in);
        int exit = 0;
        int drogaWe = 0;
        int slotWe = 0;
        int drogaWy = 0;
        int slotWy = 0;
        while (exit == 0) {
            System.out.print("Czy chcesz dodac sciezke? (Tak/Nie): ");
            String test = wejscie.nextLine();
            if (test.equals("Nie")) {
                exit = 1;
            } else {
                int poprawnosc = 0;
                while (poprawnosc == 0) {
                    System.out.print("Podaj numer drogi wejsciowej: ");
                    drogaWe = wejscie.nextInt();
                    System.out.print("Podaj numer slotu: ");
                    slotWe = wejscie.nextInt();
                    if (getSlot(skrzyzowanie, drogaWe, slotWe, 2) == 2) {
                        System.out.println("Niepoprawne wejscie - slot jest przeznaczony dla wyjazdu");
                    } else poprawnosc = 1;
                }
                while (poprawnosc == 1) {
                    System.out.print("Podaj numer drogi wyjsciowej: ");
                    int popdr = 0;
                    while (popdr == 0) {
                        drogaWy = wejscie.nextInt();
                        if (drogaWe != drogaWy) {
                            popdr = 1;
                        } else {
                            System.out.print("Podaj numer drogi wyjsciowej (nie moze byc taki sam jak wejsciowej): ");
                        }
                    }
                    System.out.print("Podaj numer slotu: ");
                    slotWy = wejscie.nextInt();
                    if (getSlot(skrzyzowanie, drogaWy, slotWy, 2) == 1) {
                        System.out.println("Niepoprawne wejscie - slot jest przeznaczony dla wjazdu");
                    } else poprawnosc = 2;
                }
                Sciezka sciezka = new Sciezka(drogaWe, slotWe, drogaWy, slotWy, dlugoscSciezki(skrzyzowanie, drogaWe, slotWe, drogaWy, slotWy));
                sciezki.add(sciezka);
                wejscie.nextLine();
                System.out.print("Czy chcesz zobaczyc liste sciezek? (Tak/Nie): ");
                test = wejscie.nextLine();
                if (test.equals("Tak")) {
                    for (int i = 0; i < sciezki.size(); i++)
                        System.out.println("Sciezka nr " + i + ":\nWejscie: droga " + sciezki.get(i).drogaWe + " slot " + sciezki.get(i).slotWe + "\n" +
                                "Wyjscie: droga " + sciezki.get(i).drogaWy +  " slot " + sciezki.get(i).slotWy + "\n o dlugosci " +
                                + sciezki.get(i).dlugosc);
                }
            }
        }
    }
}
