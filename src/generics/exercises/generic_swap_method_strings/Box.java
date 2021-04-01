package generics.exercises.generic_swap_method_strings;

public class Box<T> {
    private T content;

    public Box(T input) {
        this.content = input;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", content.getClass().getName(), content);
    }
}
