package collections;

import java.util.ArrayList;
import java.util.List;

public class ColEx15 {
    public static List<Integer> searchDivide(int a, int b, int x) {
        List<Integer> resume = new ArrayList<>();
        for (int i = a; i <= b ; i++) {
            if (i % x == 0) {
                resume.add(i);
            }
        }
        return resume;
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 50;
        int x = 5;

        List<Integer> divide = searchDivide(a,b,x);
        if (divide.isEmpty()) {
            System.out.println("Brak liczb podzielnych przez " + x + " w zakresie od " + a + " do " + b);
        } else {
            System.out.println("Liczby podzielne przez " + x + " w zakresie od " + a + " do " + b);
            for (int liczba : divide) {
                System.out.println(liczba + " ");
            }
        }
    }
}

