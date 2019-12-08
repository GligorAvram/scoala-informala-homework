package ro.siit.IOandEnums.main;

import java.io.File;
import java.util.List;
import java.util.Vector;

public class DoStuff {
    public static void main(String[] args) {

        File f1 = new File("IOandEnums/file1.txt");
        File f2 = new File("IOandEnums/file2.txt");

        long unthreddedTime = System.currentTimeMillis();
        PeopleContaimentUnit pcm = new PeopleContaimentUnit();
        FilesReader reader = new FilesReader();
        pcm.addPeople(reader.getPeople(f1));
        pcm.addPeople(reader.getPeople(f2));
        System.out.println("without threads it took: " + unthreddedTime);


        long time = System.currentTimeMillis();
        List<Person> theList = new Vector<>();

        ThreddedPCM runnable1 = new ThreddedPCM(theList, f1);
        ThreddedPCM runnable2 = new ThreddedPCM(theList, f2);

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreddedPCM.printPeople(theList);
        System.out.println("using threads it took: " + time);
    }
}
