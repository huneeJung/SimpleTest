package FunctionInterfaceTest;

public class TriConsumerTest {
    public static void main(String[] args) {
        good((a,b,c)-> System.out.println("int : " + a + " , String : " +b + " , " + "Long : " + c));
        good(TriConsumerTest::function);
    }

    private static void good(TriConsumer<Integer,String,Long> function){
        function.accept(2,"3",4L);
    }

    private static void function(Integer a, String b, Long c){
        System.out.println("int : " + a + " , String : " +b + " , " + "Long : " + c);
    }
}
