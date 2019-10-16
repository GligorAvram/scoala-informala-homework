package ro.siit.java8.main;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class with methods to keep track of objects created through the Person class. This class includes methods to create
 * people and, identify people whose birthday in a certain month and sort these people based on their first name.
 */

public class PeopleManager {
    public static enum monthEnum {
        January, February, March, April, May, June, July,
        August, September, October, November, December;

        public static Month getMonth(String s) {
            if (s.equalsIgnoreCase("january") || s.equalsIgnoreCase("1"))
                return Month.JANUARY;
            if (s.equalsIgnoreCase("february") || s.equalsIgnoreCase("2"))
                return Month.FEBRUARY;
            if (s.equalsIgnoreCase("march") || s.equalsIgnoreCase("3"))
                return Month.MARCH;
            if (s.equalsIgnoreCase("april") || s.equalsIgnoreCase("4"))
                return Month.APRIL;
            if (s.equalsIgnoreCase("may") || s.equalsIgnoreCase("5"))
                return Month.MAY;
            if (s.equalsIgnoreCase("june") || s.equalsIgnoreCase("6"))
                return Month.JUNE;
            if (s.equalsIgnoreCase("july") || s.equalsIgnoreCase("7"))
                return Month.JULY;
            if (s.equalsIgnoreCase("august") || s.equalsIgnoreCase("8"))
                return Month.AUGUST;
            if (s.equalsIgnoreCase("september") || s.equalsIgnoreCase("9"))
                return Month.SEPTEMBER;
            if (s.equalsIgnoreCase("october") || s.equalsIgnoreCase("10"))
                return Month.OCTOBER;
            if (s.equalsIgnoreCase("november") || s.equalsIgnoreCase("11"))
                return Month.NOVEMBER;
            if (s.equalsIgnoreCase("december") || s.equalsIgnoreCase("12"))
                return Month.DECEMBER;
            throw new IllegalArgumentException("Invalid input for month");
        }
    }


    private List<Person> theList = new ArrayList<>();

    public List<Person> PersonCreator(List<String> list) {

        for (String s : list
        ) {
            String[] breakDown = s.split(",");
            Person p = new Person(breakDown[0], breakDown[1], breakDown[2]);
            theList.add(p);
        }
        return theList;
    }

    public void congratulateBday(String mth, String fileName) {

        List<Person> bDayPeople = theList
                .stream()
                .filter(person -> person.getBirthDate().getMonth().equals(monthEnum.getMonth(mth))
                )
                .sorted()
                .collect(Collectors.toList());

        writeFile(bDayPeople, fileName);
    }

    private void writeFile(List<Person> bDayPeople, String fileName) {
        try (FileWriter fw = new FileWriter(fileName)){
            bDayPeople
                    .stream()
                    .forEach(p-> {
                        try {
                            fw.write(p.getFirstName() + " " + p.getSurName() + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //only for testing
    public List<Person> getTheList() {
        return theList;
    }
}



