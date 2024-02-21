import java.util.logging.Logger;

public class MemoryAreaTest {
    public static void main(String[] args) {

        // 스택 영역 메모리 자체에 값을 할당
        int numFromStack = 0;
        // 스택 영역에 힙 메모리의 주소를 할당
        Integer numFromHeap = new Integer(0);
        // 래퍼 클래스와 프리미티브 타입의 값(리터럴)을 비교할때, 자동으로 래퍼 클래스가 언박싱 (오토언박싱)이 되어 값 비교가 일어난다 - 예상 결과 : true
        System.out.println("literal == Wapper Class");
        System.out.println(numFromStack == numFromHeap);
        System.out.println("-----------------------");
        // 프리미티브 타입은 값을 나타내는 자바의 기본 데이터 타입이고, 리터럴은 값 그 자체이다.

        Integer num2FromHeap = new Integer(0);
        // 래퍼 클래스끼리 비교하여 힙메모리의 주소 비교 - 예상 결과 : false
        System.out.println(numFromHeap == num2FromHeap);

        boolean boolFromStack = true;
        Boolean booleanFromHeap = true;
        System.out.println(boolFromStack == booleanFromHeap);


        // 정수형 타입과 문자형 타입의 비교는 문자를 유니코드 또는 아스키 코드로 값으로 변환하여 정수형으로 변환해서 값을 비교함
        char c = 'A';
        int num = 65;
        double d = 65.0;
        System.out.println(c ==num);
        System.out.println(d ==num);

        // String pool 영역은 자바 8 이전에는 메소드 영역에 위치하여, GC(가바지컬렉터)의 대상이 아니었지만, 현재는 자바 8 이후부터 힙메모리 영역으로 이전되면서 GC 의 대상이 되었음
        // String pool 에 "key" 라는 값을 최초로 할당
        // keyFromStringPool 변수는 Stack 영역에 생성되며, 이 Stack 영역에 생성된 메모리에 String pool 메모리 주소를 할당 / 메소드 종료시 할당된 스택 영역의 메모리가 해제되면서, 참조하고 있던 String pool 내의 메모리를 더 이상 참조하지 않게 됌
        String keyFromStringPool = "key";
        // "key" 라는 값을 가진 String pool 메모리의 주소를 참조
        String key2FromStringPool = "key";

        // keyFromStringPool 변수와 같은 String pool 객체를 참조 ( 값을 비교하는 것이 아닌 String pool 의 메모리 주소를 비교 ) - 에상 결과 - true
        System.out.println(keyFromStringPool == key2FromStringPool);

        // heap 메모리에 "key" 라는 값을 할당 , String pool 과 관련이 없음
        String keyFromHeap = new String("key");

        // String pool 의 메모리 주소와 Heap 메모리 주소를 비교 - 예상 결과 : false
        System.out.println(keyFromStringPool == keyFromHeap);


    }

}
