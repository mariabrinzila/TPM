import java.util.concurrent.ThreadLocalRandom;

public class Person implements Runnable {
    private int index;
    private String name;
    private boolean done;
    private Tribe t;
    private int nr_ate;

    public Person(int index, String name) {
        this.index = index;
        this.name = name;
        this.nr_ate = 0;
    }

    @Override
    public synchronized void run() {
        this.done = false;
        while (!done) {
            if (isServed()) {
                this.nr_ate++;
                System.out.println("Person " + this.index + ", whose name is " + this.name + ", is eating portion " + this.nr_ate + " now.");
                if (this.nr_ate == this.getT().getP().getNr_ate_total()) {
                    this.done = true;
                    System.out.println("Person " + this.index + ", whose name is " + this.name + ", is now full.");
                }
            }
        }

        notify();
    }

    private boolean isServed() {
        Pot p = t.getP();
        if (p.getNr_left_portions() > 0) {
            p.setNr_left_portions(p.getNr_left_portions() - 1);
        } else {
            System.out.println("The pot is empty now. It will be full shortly.");
            int N = p.getNr_total_portions();
            p.setNr_left_portions(N - 1);
        }

        return true;
    }

    public Tribe getT() {
        return t;
    }

    public void setT(Tribe t) {
        this.t = t;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}