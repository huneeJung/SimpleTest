package DesignPatternTest.Factory;

class Cat implements Animal{

    public Cat() {
    }
    Cat(String name){
        this.name = name;
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void speak() {
        System.out.println("I'am Cat :: "+name);
    }
}
