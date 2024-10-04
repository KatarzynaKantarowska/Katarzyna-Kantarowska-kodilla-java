package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ColEx4 {
    public static void main(String[] args) {

        class Student {
            private String name;
            private String lastName;

            public Student(String name, String lastname) {
                this.name = name;
                this.lastName = lastname;
            }

            public String getName() {
                return name;
            }

            public String getLastName() {
                return lastName;
            }

            public String toString() {
                return name + " " + lastName;
            }
        }
        class Marks {
            private List<Integer> marks = new ArrayList<>();

            public Marks(int... marks) {
                for (int mark : marks) {
                    this.marks.add(mark);
                }
            }

            public double getAvg() {
                int sum = 0;
                for (int mark : marks) {
                    sum += mark;
                }
                return (double) sum / marks.size();
            }
        }
        HashMap<Student, Marks> studentMarks = new HashMap<>();

        Student student1 = new Student("Jennifer ", "Taylor ");
        Student student2 = new Student("Jen ", "Tay ");
        Student student3 = new Student("Monica ", "Kowalski ");
        Student student4 = new Student("Jan ", "Taylor ");
        Student student5 = new Student("Robert ", "Taylor ");

        studentMarks.put(student1, new Marks(5, 6, 3, 2, 4, 5));
        studentMarks.put(student2, new Marks(4, 5, 6, 4, 5, 6));
        studentMarks.put(student3, new Marks(4, 5, 6, 4, 5, 6));
        studentMarks.put(student4, new Marks(4, 5, 6, 3, 5,3,3,5, 6));
        studentMarks.put(student5, new Marks(4, 5, 6, 4, 5, 6));

        for (Student student : studentMarks.keySet()) {
            Marks marks = studentMarks.get(student);
            marks.getAvg();
            System.out.println("Imię: " + student.name + "Nazwisko: " + student.lastName
                    + "średnia ocen: " + marks.getAvg());
        }
        // ***************** ZADANIE DODATKOWE PODMIANKA BEZ ZMIENNEJ POMOCNICZEJ
        int a = 5;
        int b = 25;

        System.out.println();
        System.out.println("Zadanie dodatkowe");
        System.out.println();
        System.out.println("Liczby przed zamianą: " + "a: " + a + " b: " + b);
        System.out.println();

        if (a >= 0 && b >=0)
        {
            System.out.println("Liczby po zamianie: " + "a: " + b + " b: " + a);
        } else {
            System.out.println("Podano nieprawidłowe liczby");
        }
    }
}