package week6;

import java.util.*;

/**
 * Insert javadoc here ^_^
 * <p>
 * Las intentionat gol javadocul pentru ca in tema asta nu prea pot spune ca am facut un program
 * ci mai degraba am adaugat doar valori in diverse colectii.
 */

public class Homework6 {
    public static void main(String[] args) {
        //pentru prima parte a temei
        NameComparator nComp = new NameComparator();
        AgeComparator aComp = new AgeComparator();
        Set<Persoana> nameSet = new TreeSet<>(nComp);
        Set<Persoana> ageSet = new TreeSet<>(aComp);
        //pentru a 2-a parte a temei
        Map<Persoana, List<Hobby>> hobby = new HashMap<>();

        //prima parte a temei
        Persoana p1 = new Persoana(55, "Vanilla");
        Persoana p2 = new Persoana(65, "Cocoa");
        Persoana p3 = new Persoana(25, "Oreo");
        Persoana p4 = new Persoana(795, "Cinnamon");
        Persoana p5 = new Persoana(55, "Vanilla");

        nameSet.add(p1);
        nameSet.add(p2);
        nameSet.add(p3);
        nameSet.add(p4);
        nameSet.add(p5);

        for (Persoana p : nameSet
        ) {
            System.out.println(p);
        }
        System.out.println("\n=============\n");
        ageSet.add(p1);
        ageSet.add(p2);
        ageSet.add(p3);
        ageSet.add(p4);
        ageSet.add(p5);

        for (Persoana p : ageSet
        ) {
            System.out.println(p);
        }

        //a 2-a parte a temei
        System.out.println("\n\n=======================================\n\n");

        List<Hobby> h1 = new ArrayList<>();
        h1.add(new Hobby("ciclism", 2, new Adresa("Mamaia", new Tara("Romania"))));
        h1.add(new Hobby("alpinism", 1, new Adresa("Brasov", new Tara("Romania"))));
        h1.add(new Hobby("nimic", 10000, new Adresa("New York", new Tara("USA"))));

        List<Hobby> h2 = new ArrayList<>();
        h2.add(new Hobby("arte martiale", 4, new Adresa("Tokyo", new Tara("Japonia"))));
        h2.add(new Hobby("baschet", 2, new Adresa("Los Angeles", new Tara("California"))));
        h2.add(new Hobby("cantat", 1, new Adresa("Paris", new Tara("Franta"))));

        List<Hobby> h3 = new ArrayList<>();
        h3.add(new Hobby("protestat", 2, new Adresa("Bucuresti", new Tara("Romania"))));
        h3.add(new Hobby("spart seminte", 7, new Adresa("Craiova", new Tara("Romania"))));
        h3.add(new Hobby("vandalism", 1, new Adresa("Iasi", new Tara("Romania"))));

        hobby.put(p1, h1);
        hobby.put(p2, h2);
        hobby.put(p3, h3);

        System.out.println(p2 + " practica: \n" + hobby.get(p2).toString());

        System.out.println("\n=============\n");

        for (Persoana key : hobby.keySet()
        ) {
            System.out.println(key.getName() + " practica: \n" + hobby.get(key).toString());
        }


    }
}
