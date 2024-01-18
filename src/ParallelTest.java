import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ParallelTest {
    public static void main(String[] args) {
        List<Boolean> list = new ArrayList();
        int num = 0;
        while (num < 100000000) {
            if (num % 2 == 0) {
                list.add(true);
            } else {
                list.add(false);
            }
            num++;
        }
        forTest(list);
        streamTest(list);
        parallelTest(list);
    }

    private static void forTest(List<Boolean> list) {
        Instant before = Instant.now();
        int count = 0;
        for (Boolean aBoolean : list) {
            if (aBoolean) {
                count++;
            }
        }
        Instant after = Instant.now();
        System.out.println("For Count ::: " + count);
        System.out.println("For 성능 Test ::: " + Duration.between(before, after).toMillis() + "ms");
        System.out.println();
    }

    private static void streamTest(List<Boolean> list) {
        Instant before = Instant.now();
        long count = list.stream().filter(ele -> ele).count();
        Instant after = Instant.now();
        System.out.println("Stream Count ::: " + count);
        System.out.println("Stream 성능 Test ::: " + Duration.between(before, after).toMillis() + "ms");
        System.out.println();
    }

    private static void parallelTest(List<Boolean> list) {
        Instant before = Instant.now();
        long count = list.parallelStream().filter(ele -> ele).count();
        Instant after = Instant.now();
        System.out.println("ParallelStream Count ::: " + count);
        System.out.println("ParallelStream 성능 Test ::: " + Duration.between(before, after).toMillis() + "ms");
        System.out.println();
    }
}