package ro.week5;

import java.util.Objects;

/**
 * Clasa Milk care descrie produsele animale care vor fi vandute.
 * Are metodele equals si toString rescrise pentru a putea fi comparate cu alte produse/printate
 */

public class Milk extends Animal {
    private String name = "Milk";

    @Override
    public String toString() {
        return "Milk{" +
                "name='" + name + '\'' +
                ", quantity='" + this.getStock() + '\'' +
                "ID='" + this.getID() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Milk)) return false;
        Milk milk = (Milk) o;
        return Objects.equals(name, milk.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
