package generics.exercises.threeuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Threeuple> threeuples = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] tokens = s.nextLine().split("\\s+");
            if (i == 0) {
                String name = String.format("%s %s", tokens[0], tokens[1]);
                String area = tokens[2];
                String town = tokens[3];
                Threeuple<String> object = new Threeuple<>(name, area, town);
                threeuples.add(object);
            } else if (i == 1) {
                String name = tokens[0];
                int litersOfBeer = Integer.parseInt(tokens[1]);
                boolean isDrunk = tokens[2].equals("drunk");
                Threeuple<Boolean> object = new Threeuple<>(name, litersOfBeer, isDrunk);
                threeuples.add(object);
            } else {
                String name = tokens[0];
                double balance = Double.parseDouble(tokens[1]);
                String bankName = tokens[2];
                Threeuple<String> object = new Threeuple<>(name, balance, bankName);
                threeuples.add(object);
            }
        }

        threeuples.forEach(e-> System.out.println(e.toString()));

    }
}
