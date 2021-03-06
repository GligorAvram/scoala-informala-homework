package ro.week5;

import java.util.Objects;

/**
 * Clasa Other care descrie produsele animale care vor fi vandute.
 * Are metodele equals si toString rescrise pentru a putea fi comparate cu alte produse/printate
 */

public class Other extends Animal {
    private String name = "Other";

    @Override
    public String toString() {
        return "Other{" +
                "name='" + name + '\'' +
                ", quantity='" + this.getStock() + '\'' +
                "ID='" + this.getID() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Other)) return false;
        Other other = (Other) o;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
