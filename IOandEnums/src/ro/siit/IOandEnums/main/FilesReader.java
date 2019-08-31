package ro.siit.IOandEnums.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Transforms a CSV file into a List of Strings separated by the new line marker
 */
public class FilesReader {
    private List<String> people = new ArrayList<>();


    public List<String> getPeople(File f) {
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                people.add(line);
            }
            return people;
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
        return people;
    }

}
