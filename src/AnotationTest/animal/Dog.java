package AnotationTest.animal;

import AnotationTest.DemoAnnotation;

public class Dog implements Animal{

    public Dog(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    String name;
    @DemoAnnotation(message = "I'm Dog : 유효하지 않은 날짜 형식", blankAble = false,format = "yyyy")
    String birthday;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }
}
