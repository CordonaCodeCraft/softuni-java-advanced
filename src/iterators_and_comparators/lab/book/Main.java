package iterators_and_comparators.lab.book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        if (bookTwo.compareTo(bookThree) > 0) {
            System.out.printf("%s is before %s", bookTwo.getTitle(), bookThree.getTitle());
        } else if (bookTwo.compareTo(bookThree) < 0) {
            System.out.printf("%s is before %s", bookThree.getTitle(), bookTwo.getTitle());
        }  else {
            System.out.printf("Book are equal");
        }


    }
}
