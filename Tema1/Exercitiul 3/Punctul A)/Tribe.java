import java.util.ArrayList;

public class Tribe extends Thread {
    private ArrayList<Person> tribe_people = new ArrayList<>();
    private Pot p;

    public Tribe(ArrayList<Person> p, Pot pt) {
        this.tribe_people = p;
        this.p = pt;

    }

    public void feedTheTribe() {
        for (Person tp : tribe_people)
            new Thread(tp).start();
    }

    public ArrayList<Person> getTribe_people() {
        return tribe_people;
    }

    public Pot getP() {
        return p;
    }
}
