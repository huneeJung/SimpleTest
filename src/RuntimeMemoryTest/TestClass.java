package RuntimeMemoryTest;

public class TestClass {

//    private String name;
//    private int age;
//
//    public TestClass(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    protected void finalize(){
//        System.out.println(toString());
        System.out.println("가비지 컬렉터의 대상이 됩니다.");
    }

//    @Override
//    public String toString() {
//        return "TestClass{" +
//                "name=" + name +
//                ", age=" + age +
//                '}';
//    }
}
