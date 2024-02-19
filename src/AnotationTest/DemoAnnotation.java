package AnotationTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
public @interface DemoAnnotation {
    String message () default "유효하지 않은 날짜 형식";

    String format() default "yyyy-MM-dd";

    boolean blankAble() default true;
}
