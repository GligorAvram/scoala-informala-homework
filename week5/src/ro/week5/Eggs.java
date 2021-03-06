package ro.week5;

import java.util.Objects;

/**
 * Clasa Eggs care descrie produsele animale care vor fi vandute.
 * Are metodele equals si toString rescrise pentru a putea fi comparate cu alte produse/printate
 */

public class Eggs extends Animal {
    private String name = "Eggs";

    @Override
    public String toString() {
        return "Eggs{" +
                "name='" + name + '\'' +
                ", quantity='" + this.getStock() + '\'' +
                "ID='" + this.getID() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Eggs)) return false;
        Eggs eggs = (Eggs) o;
        return Objects.equals(name, eggs.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
