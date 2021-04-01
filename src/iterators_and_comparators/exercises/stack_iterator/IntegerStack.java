package iterators_and_comparators.exercises.stack_iterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.stream.Stream;

public class IntegerStack implements Iterable<Integer> {
    private Integer[] elements;

    public IntegerStack() {
        this.elements = new Integer[0];
    }

    public void push(Integer... pushedElements) {
        int newStackSize = elements.length + pushedElements.length;
        Integer[] newStack = new Integer[newStackSize];
        Deque<Integer> buffer = new ArrayDeque<>();

        Stream
                .of(this.elements, pushedElements)
                .flatMap(Stream::of)
                .forEach(buffer::offer);

        for (int i = 0; i < newStack.length; i++) {
            newStack[i] = buffer.remove();
        }

        this.elements = newStack.clone();
    }

    public Integer pop() {
        int poppedElement = 0;
        try {
            poppedElement = this.elements[this.elements.length - 1];
            int newStackSize = elements.length - 1;
            Integer[] newStack = new Integer[newStackSize];

            for (int i = 0; i < newStackSize; i++) {
                newStack[i] = this.elements[i];
            }

            this.elements = newStack.clone();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No elements");
        }
        return poppedElement;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntegerIterator();
    }

    private class IntegerIterator implements Iterator<Integer> {
        private int counter = elements.length - 1;

        @Override
        public boolean hasNext() {
            if (this.counter >= 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Integer next() {
            return elements[counter--];
        }
    }
}