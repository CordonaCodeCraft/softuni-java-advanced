package iterators_and_comparators.exercises;

import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        String[] test = new String[9];
        int center = test.length / 2;
        System.out.println(center);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        while (set.iterator().hasNext()) {
            if (set.iterator().next() == 1) {
                System.out.println("true");
            }
        }
    }

}
