package collections;

import java.util.LinkedList;

class Clock{
    private int hours;
    private int minutes;
    private  int seconds;

    public Clock(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public String toString(){
        return String.format("%02d:%02d:%02d",hours,minutes,seconds);
    }
    public void move() {
        minutes++;
        if(minutes >= 60) {
            minutes = 0;
            hours++;
            if (hours >=24) {
                hours = 0;
            }
        }
    }
}

public class ColEx14 extends Clock {

    public ColEx14(int hours, int minutes, int seconds) {
        super(hours, minutes, seconds);
    }

    public static void main(String[] args) {
        Clock clock = new Clock(16,15,15);
        Clock clock1 = new Clock(11,25,30);
        Clock clock2 = new Clock(12,15,45);
        Clock clock3 = new Clock(10,30,5);
        Clock clock4 = new Clock(5,25,35);
        Clock clock5 = new Clock(15,15,15);
        Clock clock6 = new Clock(23,59,59);
        Clock clock7 = new Clock(21,59,59);
        Clock clock8 = new Clock(15,59,15);
        Clock clock9 = new Clock(0,59,0);

        LinkedList<Clock> clocks = new LinkedList<>();
        clocks.add(clock);
        clocks.add(clock1);
        clocks.add(clock2);
        clocks.add(clock3);
        clocks.add(clock4);
        clocks.add(clock5);
        clocks.add(clock6);
        clocks.add(clock7);
        clocks.add(clock8);
        clocks.add(clock9);

        System.out.println("Zegary przed przesunięciem czasu: ");
        for (Clock c : clocks) {
            System.out.println(c);
        }

        System.out.println("Zegary po przesunięciu czasu: ");
        for (Clock c : clocks) {
            c.move();
            System.out.println(c);
        }

        System.out.println();
        System.out.println("Zadanie dodatkowe: wypisywanie liczb podzielnych przez 4 bez instrukcji warunkowej:");
        System.out.println();
        for (int i = 0; i <= 100; i+=4) {
            {
                System.out.println(i);
            }
        }
    }
}