package iterators_and_comparators.exercises.pet_clinics;

import java.util.Objects;

public class Pet {
    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Pet pet = (Pet) other;
        return age == pet.age &&
                name.equals(pet.name) &&
                kind.equals(pet.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, kind);
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.kind);
    }
}
