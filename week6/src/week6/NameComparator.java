package week6;

import java.util.Comparator;

public class NameComparator implements Comparator<Persoana> {


    @Override
    public int compare(Persoana o1, Persoana o2) {
        if (o1.getName().compareTo(o2.getName()) > 0) return 1;
        if (o1.getName().compareTo(o2.getName()) < 0) return -1;
        return 0;
    }
}
