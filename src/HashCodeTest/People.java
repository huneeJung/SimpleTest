package HashCodeTest;

import java.util.Objects;

public class People {

    private String name;
    private String age;

    public People(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name) && Objects.equals(age, people.age);
    }
}
