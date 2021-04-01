package generics.exercises.generic_count_method_doubles;

public class Box <T extends Comparable<T>> {
      T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
