public class StringBuilderTest {
    public static void main(String[] args) {

        System.gc();

        // String Builder 는 문자열을 매번 연산해서 String pool 에 저장하는 것이 아닌 StringBuilder 의 버퍼에 각각의 문자열을 저장함
        Runtime runtime = Runtime.getRuntime();
        Long totalMemory = runtime.totalMemory(); // JVM이 사용할 수 있는 전체 메모리
        StringBuilder sb = new StringBuilder();
        sb.append("a").append("b").append("c").append("d").append("e").append("f");
        Long freeMemory = runtime.freeMemory(); // JVM에서 현재 사용되지 않고 여유로운 메모리
        Long usedMemory = totalMemory - freeMemory; // JVM에서 사용 중인 메모리
        System.out.println("String Builder : " + sb.toString());
        System.out.println("Memory Usage From String Builder : " + usedMemory);


        totalMemory = null;
        sb = null;
        freeMemory = null;
        usedMemory = null;
        System.gc();

        // String 의 리터럴은 매번 연산의 수행할때마다 새로운 리터럴이 생성되어 String pool에 저장되어 메모리 관리가 비효율적임
        String str = "a";
        str += "b";
        str += "c";
        str += "d";
        str += "e";
        str += "f";
        totalMemory = runtime.totalMemory();
        freeMemory = runtime.freeMemory();
        usedMemory = totalMemory - freeMemory;
        System.out.println("String : "+ str);
        System.out.println("Memory Usage From String : "+usedMemory);
    }
}
