package ro.siit.IOandEnums.tests;

import org.junit.Test;
import ro.siit.IOandEnums.main.PeopleContaimentUnit;
import ro.siit.IOandEnums.main.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    private final String lineFromFile = "Jeffie Schoen,1971-12-14,female";

    //comment out the try/catch statement from the PeopleContainmentunit for the test to run
    @Test
    public void peopleCreation() {
        PeopleContaimentUnit pcm = new PeopleContaimentUnit();
        List<String> onePerson = new ArrayList<>();
        onePerson.add(lineFromFile);
        pcm.addPeople(onePerson);
        assertEquals(1, pcm.getPeople().size());
    }

    @Test
    public void peopleAttributes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate birthDate = LocalDate.parse("1971-12-14", formatter);
        PeopleContaimentUnit pcm = new PeopleContaimentUnit();
        List<String> onePerson = new ArrayList<>();
        onePerson.add(lineFromFile);
        pcm.addPeople(onePerson);
        assertEquals(birthDate, pcm.getPeople().get(0).getBirthDate());
        assertEquals(Person.sex.FEMALE, pcm.getPeople().get(0).getSex());
        assertEquals("Jeffie Schoen", pcm.getPeople().get(0).getName());
    }
}
