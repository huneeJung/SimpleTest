package RuntimeMemoryTest;

public class RuntimeMemoryTest {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();

        var freeMemory = runtime.freeMemory(); // 사용 가능한 힙 메모리 총량 / 바이트 단위
        var totalMemory = runtime.totalMemory(); // 사용 할 수 있는 힙 메모리 총량 / 바이트 단위
        var maxMemory = runtime.maxMemory(); // 운영체제로부터 JVM 에 할당받은 힙 메모리의 총량 / 바이트 단위
        System.out.println((double)freeMemory/(double)(1024*1024));
        System.out.println((double)maxMemory/(double)(1024*1024));
        System.out.println((double)totalMemory/(double)(1024*1024));
        System.out.println("Used Memory : "+(double)(totalMemory-freeMemory)/(double)(1024*1024));

        TestClass instance = new TestClass();
        instance = null;
        System.gc();

        instance = new TestClass();
        instance = null;
        System.runFinalization();

    }
}
