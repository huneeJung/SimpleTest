package AnotationTest;

import AnotationTest.animal.Animal;
import AnotationTest.animal.Cat;
import AnotationTest.animal.Dog;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class AnnotationTest {
    public static void main(String[] args) throws Exception{
        try {
            Animal cat = createInstance(Cat.class, "고양이", "2024-01-22");
            System.out.println("I'am Cat : 유효한 날짜 형식");
            System.out.println("name : "+cat.getName());
            System.out.println("birthDay : " + cat.getBirthday());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            Animal dog = createInstance(Dog.class, "강이지", "2024");
            System.out.println("I'm Dog : 유효한 날짜 형식");
            System.out.println("name : "+dog.getName());
            System.out.println("birthDay : " + dog.getBirthday());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        try{
            Animal cat = createInstance(Cat.class, "고양이", "24-01-22");
            System.out.println("I'm Cat : 유효한 날짜 형식");
            System.out.println("name : "+cat.getName());
            System.out.println("birthday : " + cat.getBirthday());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        try{
            Animal dog = createInstance(Cat.class, "강아지", "24-02-12");
            System.out.println("I'm Dog : 유효한 날짜 형식");
            System.out.println("name : "+dog.getName());
            System.out.println("birthday : " + dog.getBirthday());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    private static <T extends Animal, W, V> T createInstance(Class<T> clazz, W param1, V param2) throws Exception {
            T instance = clazz.getConstructor(String.class,String.class).newInstance(param1, param2);
            Arrays.stream(instance.getClass().getDeclaredFields())
                    .forEach(field -> {
                        if (!Objects.isNull(field.getAnnotation(DemoAnnotation.class))) {
                            DemoAnnotation annotation = field.getAnnotation(DemoAnnotation.class);
                            String message = annotation.message();
                            String format = annotation.format();
                            boolean blankAble = annotation.blankAble();
                            if(!blankAble) {
                                try {
                                    DateTimeFormatter.ofPattern(format).parse(String.valueOf(param2));
                                }catch (Exception e) {
                                    throw new RuntimeException(message);
                                }
                            }
                        }
                    });
            return instance;
    }
}
