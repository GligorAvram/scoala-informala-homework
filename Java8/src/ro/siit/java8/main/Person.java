package ro.siit.java8.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Person implements Comparable {
    private final String firstName;
    private final String surName;
    private final LocalDate birthDate;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");

    public Person(String firstName, String surName, String bday) {
        this.firstName = firstName;
        this.surName = surName;
        this.birthDate = LocalDate.parse(bday, formatter);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return String.format("Happy Birthday %s %s!!!!", firstName, surName);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        return this.getFirstName().compareTo(((Person) o).getFirstName());
    }

}


