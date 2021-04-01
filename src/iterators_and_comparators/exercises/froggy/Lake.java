package iterators_and_comparators.exercises.froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake {
    private List<Integer> elements;

    public Lake(Integer... elements) {
        this.elements = Arrays.asList(elements);
    }



    private class Frog implements Iterator<Integer> {

        private int cursor = elements.size() == 0 ? 0 : -2;

        private boolean isEvenCursor() {
            return cursor % 2 == 0;
        }

        @Override
        public boolean hasNext() {
            if (isEvenCursor() && elements.size() > 2) {
                return true;
            } else if (!isEvenCursor() && elements.size() > 2) {
                return cursor < elements.size() - 2;
            } else {
                return cursor < elements.size() - 1;
            }
        }

        @Override
        public Integer next() {
            cursor += 2;

            if (cursor > elements.size() - 1) {
                cursor = 1;
            }

            return elements.get(cursor);
        }
    }
}
