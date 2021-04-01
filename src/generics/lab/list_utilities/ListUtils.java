package generics.lab.list_utilities;

import java.util.Collection;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(Collection<T> collection) {
        return collection.stream().max(T::compareTo).orElse(null);
    }

    public static <T extends Comparable<T>> T getMin(Collection<T> collection) {
        return collection.stream().min(T::compareTo).orElse(null);
    }
}
