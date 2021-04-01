package generics.exercises.generic_count_method_strings;

public class Box<T extends Comparable<T>> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}
