public class Pot {
    // singleton class -> we only create one object (there is only one pot)
    private static Pot p = new Pot();
    private int nr_total_portions;
    private int nr_left_portions;
    private int nr_ate_total;

    private Pot() {

    }

    public static Pot getInstance() {
        return p;
    }

    public int getNr_total_portions() {
        return nr_total_portions;
    }

    public void setNr_total_portions(int nr_total_portions) {
        this.nr_total_portions = nr_total_portions;
    }

    public int getNr_left_portions() {
        return nr_left_portions;
    }

    public void setNr_left_portions(int nr_left_portions) {
        this.nr_left_portions = nr_left_portions;
    }

    public int getNr_ate_total() {
        return nr_ate_total;
    }

    public void setNr_ate_total(int nr_ate_total) {
        this.nr_ate_total = nr_ate_total;
    }
}