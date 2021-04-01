package LinearDataStructures.Exercises;

import java.util.Scanner;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(input);
        boolean match = pattern.matcher(s.nextLine()).matches();
        System.out.println(match);
    }
}