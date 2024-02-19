package ReflectionTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<MyClass> objClass = MyClass.class;

        System.out.println("인스턴스 변수.getClass : " + objClass.getName());

        System.out.println("Class.forName : " + objClass.getName());

        objClass = MyClass.class;
        System.out.println("Type.class : " + objClass.getName() );

        Arrays.stream(objClass.getMethods()).map(Method::getName).map(fieldName->"Method Name : " + fieldName).forEach(System.out::println);
        Arrays.stream(objClass.getFields()).map(Field::getName).map(fieldName->"Public Field Name : " + fieldName).forEach(System.out::println);
        Arrays.stream(objClass.getDeclaredFields()).map(Field::getName).map(fieldName->"All Field Name : " + fieldName).forEach(System.out::println);

        Constructor<MyClass> constructor = objClass.getConstructor(String.class,String.class);
        MyClass myClass = constructor.newInstance("field1","field2");

        Method toString = objClass.getDeclaredMethod("toString");
        System.out.println(toString.invoke(myClass));
    }
}
