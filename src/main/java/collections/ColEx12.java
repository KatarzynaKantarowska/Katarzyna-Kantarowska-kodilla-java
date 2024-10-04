package collections;

public class ColEx12 {
    public static void main(String[] args) {
        int a = 48;
        int b = 18;

        while (a != b){
            if (b < a) {
                a -= b;
            }else {
                b -= a;
            }
        }
        System.out.println("Największy wspólny dzielnik podanych liczb to: " + b );

        while (b != 0) {
            int reszta = a % b;
            a = b ;
            b = reszta;
            System.out.println("Największy wspólny dzielnik podanych liczb to: " + a);
        }
    }
}

