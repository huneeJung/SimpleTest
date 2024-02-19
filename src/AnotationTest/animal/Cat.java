package AnotationTest.animal;

import AnotationTest.DemoAnnotation;

public class Cat implements Animal {

    public Cat(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    private String name;
    @DemoAnnotation(message = "I'm Cat : 유효하지 않은 날짜 형식", blankAble = false)
    private String birthday;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBirthday() {
        return birthday;
    }
}
