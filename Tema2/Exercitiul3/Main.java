public class Main {
    public static void main(String[] args) {
        OptimisticListV<Integer> test = new OptimisticListV<>();
        test.add(Integer.valueOf(10));
        test.add(Integer.valueOf(11));
        test.add(Integer.valueOf(12));
        test.add(Integer.valueOf(13));
        test.add(Integer.valueOf(14));
        test.add(Integer.valueOf(15));
        test.add(Integer.valueOf(16));
        test.add(Integer.valueOf(17));
        test.print();
        System.out.println("---------------------------");
        test.remove(Integer.valueOf(11));
        test.print();
        System.out.println("---------------------------");
        test.remove(Integer.valueOf(16));
        test.print();
    }
}
