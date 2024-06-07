package UnsafeTest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    private static Unsafe getUnsafe() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    public static class CustomClass {
        private int value;

        public CustomClass(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "CustomClass{" + "value=" + value + '}';
        }
    }

    public static void main(String[] args) throws Exception {
        Unsafe unsafe = getUnsafe();

        // CustomClass 인스턴스 생성
        CustomClass originalInstance = new CustomClass(42);
        System.out.println("Original instance: " + originalInstance);

        // 메모리 주소 출력
        long originalAddress = toAddress(originalInstance, unsafe);
        System.out.println("Original instance address: " + originalAddress);

        // 새로운 메모리 할당 및 객체 복사
        long newAddress = unsafe.allocateMemory(16); // 객체 크기를 적절히 설정
        unsafe.copyMemory(originalAddress, newAddress, 16);

        // 새로운 메모리 주소에 있는 객체 가져오기
        CustomClass copiedInstance = (CustomClass) fromAddress(newAddress, unsafe);
        System.out.println("Copied instance: " + copiedInstance);

        // 메모리 주소 출력
        long copiedAddress = toAddress(copiedInstance, unsafe);
        System.out.println("Copied instance address: " + copiedAddress);

        // 메모리 해제
        unsafe.freeMemory(newAddress);
    }

    private static long toAddress(Object obj, Unsafe unsafe) throws Exception {
        Object[] array = new Object[]{obj};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        return unsafe.getLong(array, baseOffset);
    }

    private static Object fromAddress(long address, Unsafe unsafe) throws Exception {
        Object[] array = new Object[]{null};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        unsafe.putLong(array, baseOffset, address);
        return array[0];
    }

//    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
//
//
//        var ins1 = Temp.getInstance();
//        var ins2 = Temp.getInstance();
//
//        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
//        theUnsafe.setAccessible(true);
//        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
//
//        // 시스템의 주소 크기 (바이트 단위) : 64비트인 경우 8 을 반환
//        System.out.println(unsafe.addressSize());
//        System.out.println(unsafe.pageSize());
//
//        var ins3 = (Temp) unsafe.allocateInstance(Temp.class);
//
//        System.out.println(ins1 == ins2);
//        System.out.println(ins2 == ins3);
//        System.out.println(ins3 == ins1);
//
//        ins1.test();
//        ins2.test();
//        ins3.test();
//
//    }

}
