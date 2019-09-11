package ro.siit.java8.tests;

import org.junit.Test;
import ro.siit.java8.main.PeopleManager;
import ro.siit.java8.main.Person;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test {

    private final String p1 = "Son,Willms,1955-06-10";
    private final String p2 = "Hilario,Stiedemann,1963-06-23";
    private final String p3 = "Eufemia,Kiehn,1997-06-06";
    private final String p4 = "Les,Dickens,1965-06-30";
    private final String p5 = "Timmy,Waelchi,1968-06-26";


    @Test
    public void createPeopleTest() {
        List<String> testList = new ArrayList<>();
        testList.add(p1);
        testList.add(p2);
        testList.add(p3);
        testList.add(p4);
        testList.add(p5);

        PeopleManager pm = new PeopleManager();
        List<Person> personList = pm.PersonCreator(testList);
        assertEquals(5, personList.size());
    }
}
