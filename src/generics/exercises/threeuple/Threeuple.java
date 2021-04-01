package generics.exercises.threeuple;

import generics.exercises.tuple.Tuple;

public class Threeuple<T> extends Tuple {
    T value;

    public Threeuple(Object first, Object second, T value) {
        super(first, second);
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getFirst() + " -> " + getSecond() + " -> " + value;
    }
}
