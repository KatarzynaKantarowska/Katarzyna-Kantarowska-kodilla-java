package collections;

public class ColEx2 {
    public static void main(String[] args) {

        int amount = 5;
        Integer a = amount;
        double avg = 5.0;
        Double aDouble = avg;
        char dot = '.';
        Character d = dot;

        System.out.println("Typy podstawowe:");
        System.out.println(amount);
        System.out.println(avg);
        System.out.println(dot);
        System.out.println("Wrappery:");
        System.out.println(a);
        System.out.println(aDouble);
        System.out.println(d);
        System.out.println();
        System.out.println("Porównania:");
        System.out.println("Czy amount == a :" + (amount == a));
        System.out.println("Czy avg == aDouble: " + (avg == aDouble));
        System.out.println("Czy dot == d: " + (dot == d));
    }
}

