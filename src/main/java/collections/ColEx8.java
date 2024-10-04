package collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class ColEx8 {
    public static void main(String[] args) {

        Queue<String> deque = new ArrayDeque<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            int repeatCount = random.nextInt(51);
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < repeatCount; j++) {
                stringBuilder.append('a');
            }
            deque.add(stringBuilder.toString());
        }
        ColEx8 listaRozdzielanie = new ColEx8();
        listaRozdzielanie.rozdzielanie(deque);
    }
    public void rozdzielanie (Queue < String > deque) {
        ArrayList<String> even = new ArrayList<>();
        ArrayList<String> odd = new ArrayList<>();

        for (String string : deque) {
            if (string.length() % 2 == 0) {
                even.add(string);
            } else {
                odd.add(string);
            }
        }
        System.out.println("even: ");
        for (String str : even) {
            System.out.println(str);
        }
        System.out.println("odd: ");
        for (String str : odd) {
            System.out.println(str);
        }
    }
}
