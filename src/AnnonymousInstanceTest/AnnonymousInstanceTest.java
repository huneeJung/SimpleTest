package AnnonymousInstanceTest;

public class AnnonymousInstanceTest {
    public static void main(String[] args) {
        TestInterface instance1 = new TestInterface() {
            @Override
            public void test() {
                System.out.println("New Test Method From TestInterface");
            }
        };
        instance1.test();

        TestInterface instance2 = new TestClass();
        instance2.test();

        TestInterface instance3 = new TestClass(){
            @Override
            public void test(){
                System.out.println("Modified Test Method From TestClass");
            }
        };
        instance3.test();


    }
}
