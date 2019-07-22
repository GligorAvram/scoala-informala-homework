package ro.week5;

import java.util.Objects;

/**
 * Clasa leGumes care descrie produsele vegetale care vor fi vandute.
 * Are metodele equals si toString rescrise pentru a putea fi comparate cu alte produse/printate
 * numele e scris cu litera mica intentionat.
 */

public class leGumes extends Product {

    private String name;
    private String vitamins;


    public leGumes(String name, String vitamins) {
        this.name = name;
        this.vitamins = vitamins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof leGumes)) return false;
        leGumes leGumes = (leGumes) o;
        return Objects.equals(name, leGumes.name) &&
                Objects.equals(vitamins, leGumes.vitamins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vitamins);
    }

    @Override
    public String toString() {
        return "LeGumes{" +
                "name='" + name + '\'' +
                ", quantity='" + this.getStock() + '\'' +
                "ID='" + this.getID() + '\'' +
                '}';
    }
}
