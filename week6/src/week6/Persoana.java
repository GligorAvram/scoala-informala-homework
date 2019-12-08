package week6;

import java.util.Objects;

public class Persoana {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Persoana(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoana)) return false;
        Persoana persoana = (Persoana) o;
        return getAge() == persoana.getAge() &&
                Objects.equals(getName(), persoana.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
