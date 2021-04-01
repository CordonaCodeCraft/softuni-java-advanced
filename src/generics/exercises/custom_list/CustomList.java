package generics.exercises.custom_list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void sort() {
        this.list = list
                .stream()
                .sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public void print() {
        this.list.forEach(System.out::println);
    }

    public void add(T input) {
        list.add(input);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        list.add(list.get(firstIndex));
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, list.get(list.size() - 1));
        list.remove(list.size() - 1);
    }

    public int countGreaterThan(T target) {
        int counter = 0;
        for (T element : list) {
            if (element.compareTo(target) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        return this.list.stream().max(Comparator.naturalOrder()).get();
    }

    public T getMin() {
        return this.list.stream().min(Comparator.naturalOrder()).get();
    }

    public List<T> getList() {
        return list;
    }

}
