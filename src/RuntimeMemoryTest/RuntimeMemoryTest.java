package RuntimeMemoryTest;

import java.util.ArrayList;
import java.util.List;

public class RuntimeMemoryTest {
    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<>();
        int a = 0;
        try {
            while (a < 100000000) {
                list.add(a + "sdafasf");
                a++;
            }
        }catch(OutOfMemoryError error) {
            Runtime runtime = Runtime.getRuntime();
            var freeMemory = runtime.freeMemory(); // 사용 가능한 힙 메모리 총량 / 바이트 단위
            var totalMemory = runtime.totalMemory(); // 사용 할 수 있는 힙 메모리 총량 / 바이트 단위
            var maxMemory = runtime.maxMemory(); // 운영체제로부터 JVM 에 할당받은 힙 메모리의 총량 / 바이트 단위
            System.out.println("Free Memory : " + (double) freeMemory / (double) (1024 * 1024));
            System.out.println("Max Memory : " + (double) maxMemory / (double) (1024 * 1024));
            System.out.println("Total Memory : " + (double) totalMemory / (double) (1024 * 1024));
            System.out.println("Used Memory : " + (double) (totalMemory - freeMemory) / (double) (1024 * 1024));
        }

        TestClass instance = new TestClass();
        instance = null;
        System.gc();

        instance = new TestClass();
        instance = null;
        System.runFinalization();

    }
}
