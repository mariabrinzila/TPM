public class Person implements Runnable {
    private int index;
    private String name;
    private boolean done;
    private Tribe t;

    public Person(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public void run() {
        this.done = false;
        while (!done) {
            if (isServed()) {
                this.done = true;
                System.out.println("Person " + this.index + ", whose name is " + this.name + ", was served. There are " + this.getT().getP().getNr_left_portions() + " portions left.");
            }
        }
    }

    private boolean isServed() {
        Pot p = t.getP();
        if (p.getNr_left_portions() > 0) {
            p.setNr_left_portions(p.getNr_left_portions() - 1);
        } else {
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
}
