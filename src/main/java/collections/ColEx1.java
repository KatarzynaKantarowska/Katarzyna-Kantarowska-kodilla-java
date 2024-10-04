package collections;

public class ColEx1 {
    public static void main(String[] args) {
        int[] avg = new int[]{ 2,56,42,58,54,52,56,54,51,57,51,54,58,55,56,56,52,55,55,55};
        int suma = 0;
        for (int i = 0; i < avg.length; i++) {
            suma += avg[i];
            System.out.println(avg[i]);
        }
        double srednia = (double) suma  / avg.length;
        System.out.println("Średnia podanych liczb to: " + srednia);
    }
}