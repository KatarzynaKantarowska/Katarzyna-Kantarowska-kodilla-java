package collections;

import java.util.Random;

public class ColEx7 {
    public static void main(String[] args) {

        int sumaA = 1000; // 0 - 9
        int sumaB = 0; // 0 - 49
        int counter = 1;
        Random random = new Random();

        while (sumaA > sumaB) {
            int randomA = random.nextInt(10);
            sumaA += randomA;
            int randomB = random.nextInt(50);
            sumaB += randomB;

            System.out.println("Pętla numer: " + counter);
            System.out.println("sumaA: " + sumaA);
            System.out.println("sumaB: " + sumaB);
            System.out.println("~~~~~~~~~~~~~~~~~");
            counter++;
        }

        // zadanie dodatkowe

        System.out.println();
        System.out.println("zadanie dodatkowe:");
        System.out.println();


        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}
