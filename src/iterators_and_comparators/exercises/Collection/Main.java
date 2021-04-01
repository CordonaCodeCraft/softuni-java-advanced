
// TODO: 22.08.2020 г. I am not using custom iterator in the object class

package iterators_and_comparators.exercises.Collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] parameters = generateParameters(s);
        ListyIterator listy = new ListyIterator(parameters);

        while (true) {
            String command = s.nextLine();
            if (command.equals("END")) {
                break;
            } else {
                switch (command) {
                    case "Move":
                        System.out.println(listy.move());
                        break;
                    case "Print":
                        listy.print();
                        break;
                    case "HasNext":
                        System.out.println(listy.hasNext());
                        break;
                    case "PrintAll":
                        listy.printAll();
                        break;
                }
            }
        }
    }

    private static String[] generateParameters(Scanner s) {
        String input = s.nextLine();
        if (input.contains(" ")) {
            return input.substring(input.indexOf(" ") + 1).split("\\s+");
        } else {
            return new String[0];
        }
    }
}
