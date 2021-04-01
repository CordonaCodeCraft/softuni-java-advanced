package generics.lab.array_creator;

import java.lang.reflect.Array;

public class ArrayCreator {
    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T item) {
        return (T[]) Array.newInstance(item.getClass(), length);
    }

    public static <T> T[] create(Class<T> tClass, int length, T item) {
        return (T[]) Array.newInstance(tClass, length);
    }

}
