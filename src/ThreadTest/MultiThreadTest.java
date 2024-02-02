package ThreadTest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadTest {
    private static final int TOTAL_DATA_COUNT = 10000000;
    private static final int BATCH_SIZE = 100000;
    private static final int THREAD_COUNT = TOTAL_DATA_COUNT / BATCH_SIZE;

    public static void main(String[] args) {
        // 멀티 쓰레드 처리
        Instant before = Instant.now();
        List<Data> dataList = generateDataList();
        Thread[] threads = new Thread[THREAD_COUNT];
        // 데이터를 일정량씩 나누어서 각각의 쓰레드에서 처리
        for (int i = 0; i < THREAD_COUNT; i++) {
            int startIdx = i * BATCH_SIZE;
            int endIdx = startIdx + BATCH_SIZE;
            // 쓰레드 생성 및 실행
            threads[i] = new Thread(new DataProcessor(dataList.subList(startIdx, endIdx), new ArrayList<>()));
            threads[i].start();
        }
        // 모든 쓰레드가 종료될 때까지 대기
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Instant after = Instant.now();
        System.out.println("10만건 멀티 쓰레드 처리 작업 시간 ::: " + Duration.between(before,after).toMillis());

        // 일괄 처리
        Instant before2 = Instant.now();
        List<Data> dataList2 = generateDataList();
        List<Result> resultList2 = new ArrayList<>();
        new DataProcessor(dataList2,resultList2).run();
        Instant after2 = Instant.now();
        System.out.println("10만건 단일 쓰레드 처리 작업 시간 ::: " + Duration.between(before2,after2).toMillis());
    }

    // 가상의 데이터를 생성하는 메서드
    private static List<Data> generateDataList() {
        List<Data> dataList = new ArrayList<>();
        for (int i = 1; i <= TOTAL_DATA_COUNT; i++) {
            dataList.add(new Data("Data " + i));
        }
        return dataList;
    }

    // 데이터 처리를 담당하는 Runnable 클래스
    private static class DataProcessor implements Runnable {
        private final List<Data> dataList;
        private final List<Result> resultList;
        public DataProcessor(List<Data> dataList, List<Result> resultList) {
            this.dataList = dataList;
            this.resultList = resultList;
        }

        @Override
        public void run() {
            // 데이터를 처리하는 로직을 구현
            // 본 예시에서는 데이터를 단순히 출력하는 것으로 가정
            for (Data data : dataList) {
                resultList.add(new Result(data.getName() + " Processed"));
            }
            // RestTemplate 으로 resultList 데이터를 실어서 외부 API 호출
        }
    }

    // 가상의 데이터 클래스
    private static class Data {
        private final String name;
        public Data(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    // 처리 결과 클래스
    private static class Result {
        private final String result;

        public Result(String result) {
            this.result = result;
        }
    }
}
