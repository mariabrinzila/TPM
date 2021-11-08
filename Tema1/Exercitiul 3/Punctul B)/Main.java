import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Pot p = Pot.getInstance();
        p.setNr_total_portions(4);
        p.setNr_left_portions(4);
        p.setNr_ate_total(2);

        Person p1 = new Person(1, "Ion");
        Person p2 = new Person(2, "Vasile");
        Person p3 = new Person(3, "Maria");
        Person p4 = new Person(4, "Ioana");
        Person p5 = new Person(5, "Robert");
        Person p6 = new Person(6, "Stefana");

        ArrayList<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);
        people.add(p4);
        people.add(p5);
        people.add(p6);

        Tribe t = new Tribe(people, p);
        for (Person ps : people)
            ps.setT(t);

        // execution time in miliseconds
        long start = System.currentTimeMillis();
        t.feedTheTribe();
        long time_b = System.currentTimeMillis() - start;
        System.out.println("Execution time is: " + time_b);

        try {
            File read = new File("E:/Facultate-Anul3/TPM/Exercitiul3a/execution.txt");
            Scanner reader = new Scanner(read);
            String content = reader.nextLine();
            System.out.println("Execution time for exercise 3a is " + content);
            reader.close();

            long time_a = Long.parseLong(content);
            String response;
            if (time_b > time_a)
                response = "Exercise 3b takes longer to execute than 3a.";
            else
                response = "Exercise 3a takes longer to execute than 3b.";

            try {
                FileWriter writer = new FileWriter("compare.txt");
                writer.write(response);
                writer.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
