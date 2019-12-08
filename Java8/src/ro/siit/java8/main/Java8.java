package ro.siit.java8.main;

import java.io.File;

/**
 * homework for the Java8 course which needs to fulfill the following conditions:
 *
 * Java 8
 *
 * By using streams and lamba expressions, implement a small application which:
 * 1.load from a file a structure like
 * first name, last name, date of birth
 * 2. write back another file containing only
 * first name, last name
 * ordered alphabetically for all the of all matches which have the birthday on a month indicated.
 *
 * Application takes 3 params:
 * 1. input filename
 * 2. target month (1-12)
 * 3. output file name
 * Use unittests to check the correctness.
 */
public class Java8 {
    public static void main(String[] args) {

        File f = new File("Java8/java8 input.txt");

        FileToList ftl = new FileToList();
        PeopleManager pm = new PeopleManager();

        pm.PersonCreator(ftl.fileReader(f));
        pm.congratulateBday("June", "output");


    }
}