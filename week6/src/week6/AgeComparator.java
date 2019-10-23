package week6;

import java.util.Comparator;

public class AgeComparator implements Comparator<Persoana> {

    @Override
    public int compare(Persoana o1, Persoana o2) {
        if (o1.getAge() < o2.getAge()) return -1;
        if (o1.getAge() == o2.getAge()) return 0;
        return 1;
    }
}
