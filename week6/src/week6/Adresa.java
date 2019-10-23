package week6;

public class Adresa {

    String adr;
    private Tara tara;

    public Adresa(String adr, Tara tara) {
        this.adr = adr;
        this.tara = tara;
    }

    public String getAdr() {
        return adr;
    }

    public String getTara() {
        return tara.getName();
    }
}
