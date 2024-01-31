import java.util.WeakHashMap;

public class WeakReferenceTest {
    public static void main(String[] args) {

        WeakHashMap<String,Integer> map = new WeakHashMap<>();

        var key = new String("key");
        map.put(key, 1);
        System.out.println(map.get(key));
        key = null;
        System.gc();
        System.out.println(map.getOrDefault("key", 0));

        // String 을 생성하면 heap 메모리의 별도의 영역인 String pool 이라는 공간에 저장되어 GC 의 대상이 아님
        key = "key";
        map.put(key, 1);
        System.out.println(map.get(key));
        key = null;
        System.gc();
        System.out.println(map.getOrDefault("key", 0));
    }
}
