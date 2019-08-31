package ro.siit.IOandEnums.main;

import java.time.LocalDate;


public class Person {
    public enum sex {
        MALE, FEMALE;

        public static sex getSex(String s) {
            if (s.equalsIgnoreCase("m") || s.equalsIgnoreCase("male") || s.equalsIgnoreCase("0")) {
                return MALE;
            } else if (s.equalsIgnoreCase("f") || s.equalsIgnoreCase("female") || s.equalsIgnoreCase("1")) {
                return FEMALE;
            } else {
                throw new IllegalArgumentException("No such sex");
            }
        }
    }

    private final String name;
    private final LocalDate birthDate;
    private final sex s;

    public Person(String name, LocalDate birthDate, String rawSex) {
        this.name = name;
        this.birthDate = birthDate;
        s = sex.getSex(rawSex);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public sex getSex() {
        return s;
    }
}
