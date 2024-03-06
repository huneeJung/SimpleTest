package HashCodeTest;

import java.util.*;

public class HashCodeTest {
    public static void main(String[] args) {

        // 해시 코드 재정의 O : 동등성 테스트
        var hashPeople1 = new HashPeople("A","20");
        var hashPeople2 = new HashPeople("A","20");

        if(hashPeople2.equals(hashPeople1)){
            System.out.println("hashPeople2.equals(hashPeople1)");
        }
        if(hashPeople2 != hashPeople1){
            System.out.println("hashPeople1 != hashPeople2");
        }

        // 해시 코드 테스트
        Map<HashPeople,Integer> map1 = new HashMap<>();
        map1.put(hashPeople1,1);
        map1.put(hashPeople2,2);
        System.out.println("Map Size : " + map1.size());

        // 해시 코드 재정의 X : 동등성 테스트
//        var people1 = new People("A","20");
//        var people2 = new People("A","20");
//        if(people2.equals(people1)){
//            System.out.println("people2.equals(people1)");
//        }
//        if(people1 != people2){
//            System.out.println("people1 != people2");
//        }
//
//        // 해시 코드 테스트
//        Map<People,Integer> map2 = new HashMap<>();
//        map2.put(people1,1);
//        map2.put(people2,2);
//        System.out.println("Map Size : " + map2.size());

    }
}
