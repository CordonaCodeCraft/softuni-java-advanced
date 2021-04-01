package generics.lab.array_creator;

public class Main {
    public static void main(String[] args) {
        String[] nones = ArrayCreator.create(10, "none");

        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);


    }
}
