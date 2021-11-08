import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Tribe extends Thread {
    private ArrayList<Person> tribe_people = new ArrayList<>();
    private Pot p;

    public Tribe(ArrayList<Person> p, Pot pt) {
        this.tribe_people = p;
        this.p = pt;

    }

    public synchronized void feedTheTribe() throws InterruptedException {
        for (Person tp : tribe_people) {
            System.out.println("Person " + tp.getIndex() + ", whose name is " + tp.getName() + " is being served now.");
            new Thread(tp).start();
            wait(100);
        }
    }

    public ArrayList<Person> getTribe_people() {
        return tribe_people;
    }

    public Pot getP() {
        return p;
    }
}
