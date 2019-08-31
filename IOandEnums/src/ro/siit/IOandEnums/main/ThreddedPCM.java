package ro.siit.IOandEnums.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that creates a list of people "Person" and adds to. The method that adds to it accepts a list of strings
 * and in order to function properly, the information in every line should be in the "name-birth date(yyyy-mm-dd)-sex" format.
 * Also, every female in the list whose birthday is today will be wished happy birthday and written to a file. This is
 * the thredded version of the file and it contains a static method to print a list both to the console and write a file
 */
public class ThreddedPCM implements Runnable {
    private List<Person> people;
    static File file;

    public ThreddedPCM(List<Person> people, File file) {
        this.people = people;
        this.file = file;
    }

    public void addPeople(List<String> list) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        LocalDate today = LocalDate.now();

        for (String s : list
        ) {
            String[] splitLine = s.split(",");
            String name = splitLine[0];
            LocalDate birthDate = LocalDate.parse(splitLine[1], formatter);

            String sex = splitLine[2];
            Person p = new Person(name, birthDate, sex);
            if (name != null || birthDate != null || sex != null) {
                people.add(p);
            }
        }
    }

    @Override
    public void run() {
        FilesReader reader = new FilesReader();

        addPeople(reader.getPeople(file));
    }

    public static void printPeople(List<Person> theList) {
        LocalDate today = LocalDate.now();
        try {
            FileWriter fw = new FileWriter("IOandEnums/thredded output.txt");
            for (Person p : theList
            ) {
                if (p.getSex() == Person.sex.FEMALE) {
                    if (today.getDayOfMonth() == p.getBirthDate().getDayOfMonth() && today.getMonth() == p.getBirthDate().getMonth()) {
                        String output = String.format("Happy birthday %s(%s)!!\n", p.getName(), p.getBirthDate().getYear());
                        System.out.println(output);
                        fw.write(output);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("IOException when trying to write the file");
        }
    }
}


