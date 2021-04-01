package iterators_and_comparators.exercises.strategy_pattern;

import java.util.Comparator;

public class CompareByAge implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        return Integer.compare(first.getAge(), second.getAge());
    }
}
