import java.time.Duration;
import java.time.Instant;

public class CalculationTest {

    public static void main(String[] args) {
        Instant before = Instant.now();
        int num = 0;
        int ans = 0;
        while (num < 10000) {
            num++;
            ans++;
        }
        Instant after = Instant.now();
        System.out.println(Duration.between(before, after).toNanos());

        Instant before2 = Instant.now();
        int num2 = 0;
        int ans2 = 0;
        while (num2 < 9900) {
            num2++;
        }
        while (num2 < 10000) {
            num2++;
            ans2++;
        }
        Instant after2 = Instant.now();
        System.out.println(Duration.between(before2, after2).toNanos());
    }

}
