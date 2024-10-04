package collections;

import java.util.HashSet;

public class ColEx13 {
    public static void main(String[] args) {

        HashSet<Integer> orders = new HashSet<>();
        orders.add(100);
        orders.add(101);
        orders.add(102);
        orders.add(103);
        orders.add(104);
        orders.add(105);

        boolean wasAdded = orders.add(105);
        if (!wasAdded) {
            System.out.println("Zduplikowany numer zamówienia! Dodaj kolejny numer !");
        }
        for (Integer i : orders){
            System.out.println(i);
        }
    }
}