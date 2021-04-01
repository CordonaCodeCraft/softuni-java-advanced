package iterators_and_comparators.exercises.strategy_pattern;

import java.util.Comparator;

public class CompareByName implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        String firstName = first.getName().toLowerCase();
        String secondName = second.getName().toLowerCase();
        boolean namesLengthsAreEqual = firstName.length() == secondName.length();

        if (namesLengthsAreEqual) {
            char firstCharacter = firstName.charAt(0);
            char secondCharacter = secondName.charAt(0);
            return Integer.compare(firstCharacter, secondCharacter);
        } else {
            return Integer.compare(firstName.length(), secondName.length());
        }
    }
}
