package DesignPatternTest.Factory;

class Dog implements Animal{
    public Dog(String name) {
        this.name = name;
    }

    public Dog() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void speak(){
        System.out.println("I'm Dog :: " + name);
    }
}
