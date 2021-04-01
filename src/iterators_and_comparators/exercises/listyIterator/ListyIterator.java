package iterators_and_comparators.exercises.listyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
    private final List<String> elements;
    private int index;


    public ListyIterator(String... elements) {
        this.elements = new ArrayList<>(Arrays.asList(elements));
        this.index = 0;
    }

    public void print() {
        try {
            System.out.println(elements.get(this.index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid Operation!");
        }
    }

    public boolean hasNext() {
        return this.index < elements.size() - 1;
    }

    public boolean move() {
        if (this.index < elements.size() - 1) {
            this.index = this.index + 1;
            return true;
        } else {
            return false;
        }
    }
}
