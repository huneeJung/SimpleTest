import java.time.Duration;
import java.time.Instant;

public class CalculationTest {
    public static void main(String[] args) {
        Instant before = Instant.now();
        int cnt = 0;
        int num = 0;
        int total = 0;
        while (cnt < 1000000) {
            num++;
            total++;
            cnt++;
        }
        // total 연산 1000000번 , num 연산 1000000번 , cnt 연산 1000000번
        Instant after = Instant.now();
        System.out.println("\n합계 total ::: " + total);
        System.out.println("합계 통합 계산 ::: " + Duration.between(before, after).toNanos());

        Instant before2 = Instant.now();
        cnt = 0;
        int num2 = 0;
        int total2 = 0;
        while (cnt < 1000000) {
            num2++;
            cnt++;
        }
        while (cnt < 1001000) {
            total2 += 1000;
            cnt++;
        }
        // total2 연산 1000번 , total 연산 1000000번 , cnt 연산 1001000번
        Instant after2 = Instant.now();
        System.out.println("\n합계 total2 ::: " + total2);
        System.out.println("합계 별도 계산 ::: " + Duration.between(before2, after2).toNanos());
    }
}

