package ro.siit.java8.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that takes a text file and converts it into a String list at the new paragraph marked.
 */
public class FileToList {

    public List<String> fileReader(File textFile) {

        try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
            List<String> list = new ArrayList<>();
            String s;
            while((s = reader.readLine()) != null){
                list.add(s);
            }
            return list;
        }catch(FileNotFoundException e){
            System.out.println("file not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }
        return null;
    }
}
