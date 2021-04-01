package generics.lab.jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> content;

    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public void add(T e) {
        this.content.push(e);
    }

    public T remove() {
        return this.content.pop();
    }

}
