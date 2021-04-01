package generics.exercises.tuple;

public class Tuple<T, U> {
    T first;
    U second;

    public Tuple() {
    }

    public Tuple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first + " -> " + second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}
