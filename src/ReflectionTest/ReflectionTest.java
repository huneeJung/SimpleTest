package ReflectionTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClass myObj = new MyClass();
        Class<?> objClass = myObj.getClass();

        System.out.println("인스턴스 변수.getClass : " + objClass.getName());

        objClass = Class.forName("ReflectionTest.MyClass");
        System.out.println("Class.forName : " + objClass.getName());

        objClass = MyClass.class;
        System.out.println("Type.class : " + objClass.getName() );

        Arrays.stream(objClass.getMethods()).map(Method::getName).map(fieldName->"Method Name : " + fieldName).forEach(System.out::println);
        Arrays.stream(objClass.getFields()).map(Field::getName).map(fieldName->"Public Field Name : " + fieldName).forEach(System.out::println);
        Arrays.stream(objClass.getDeclaredFields()).map(Field::getName).map(fieldName->"All Field Name : " + fieldName).forEach(System.out::println);

    }
}
