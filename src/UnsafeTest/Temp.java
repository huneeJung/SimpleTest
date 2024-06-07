package UnsafeTest;

public class Temp {

    private static Temp temp = new Temp();

    public static Temp getInstance() {
        return temp;
    }

    private Temp() {
    }

    public void test() {
        System.out.println("Test Completed");
    }

}
