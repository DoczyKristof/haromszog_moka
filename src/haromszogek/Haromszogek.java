package haromszogek;
import logika.DHaromszog;
public class Haromszogek {
    public static void main(String[] args) {
        try {
            DHaromszog d1 = new DHaromszog("3 4 5", 1);
            DHaromszog d2 = new DHaromszog("1,1 2,2 4,5", 2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}