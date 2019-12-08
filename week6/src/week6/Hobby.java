package week6;

public class Hobby {

    private String name;
    private int frequency;
    private Adresa adresa;

    public Hobby(String name, int frequency, Adresa adresa) {
        this.name = name;
        this.frequency = frequency;
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", adresa = " + adresa.getAdr() +
                " in " + adresa.getTara() +
                '}';
    }
}
