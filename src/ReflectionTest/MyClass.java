package ReflectionTest;

public class MyClass {
    public MyClass(String publicField, String privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    public String publicField;
    private String privateField;
    private void method1() {
        System.out.println("I'm Method1");
    }

    private void method2() {
        System.out.println("I'm Method2");
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "publicField='" + publicField + '\'' +
                ", privateField='" + privateField + '\'' +
                '}';
    }
}
