package DefiningClasses.Exercises.FamilyTree;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {

    private static final BiFunction<Map<String, String>, String, String> EXTRACT_RELATIVE_NAME = (map, input) -> map
            .entrySet()
            .stream()
            .filter(e -> e.getValue().equals(input))
            .map(Map.Entry::getKey)
            .collect(Collectors.joining());


    private static final BiFunction<Map<String, String>, String, String> EXTRACT_RELATIVE_BIRTHDAY = (map, input) -> map
            .entrySet()
            .stream()
            .filter(e -> e.getKey().equals(input))
            .map(Map.Entry::getValue)
            .collect(Collectors.joining());


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String personData = scanner.nextLine();
        Person targetPerson = new Person(personData);
        Deque<String> inputs = feedInputsQueue(scanner);

        generateRelativesDatabase(inputs, personData, targetPerson);

        distributeRelatives(inputs, targetPerson);

        targetPerson.printFamilyTree();

    }

    private static Deque<String> feedInputsQueue(Scanner scanner) {
        Deque<String> inputs = new ArrayDeque<>();
        List<String> buffer = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            } else {
                buffer.add(input);
            }
        }

        buffer
                .stream()
                .sorted((first, second) -> Integer.compare(!second.contains("-") ? 1 : 0, !first.contains("-") ? 1 : 0))
                .forEach(inputs::offer);

        return inputs;
    }

    private static void generateRelativesDatabase(Deque<String> inputs, String targetPersonData, Person targetPerson) {

        while (!inputs.isEmpty()) {
            if (inputs.peek().contains("-")) {
                break;
            } else {
                String input = inputs.remove();
                String name = input.substring(0, input.lastIndexOf(" "));
                String birthday = input.substring((input.lastIndexOf(" ") + 1));
                boolean isTargetPerson = input.contains(targetPersonData);

                if (isTargetPerson) {
                    targetPerson.setPersonName(name);
                    targetPerson.setPersonBirthday(birthday);
                } else {
                    targetPerson.updateRelativesList(name, birthday);
                }
            }
        }
    }

    private static void distributeRelatives(Deque<String> inputs, Person targetPerson) {

        while (!inputs.isEmpty()) {
            String[] tokens = inputs.remove().split(" - ");
            String leftToken = tokens[0];
            String rightToken = tokens[1];

            boolean isChild = leftToken.equals(targetPerson.getPersonName()) || leftToken.equals(targetPerson.getPersonBirthday());

            boolean isParent = rightToken.equals(targetPerson.getPersonName()) || rightToken.equals(targetPerson.getPersonBirthday());

            if (isChild) {
                addChild(rightToken, targetPerson);
            } else if (isParent) {
                addParent(leftToken, targetPerson);
            }
        }
    }

    private static void addChild(String rightToken, Person targetPerson) {
        String childName;
        String childBirthday;
        boolean isChildBirthday = Character.isDigit(rightToken.charAt(0));

        if (isChildBirthday) {
            childName = EXTRACT_RELATIVE_NAME.apply(targetPerson.getRELATIVES(), rightToken);
            childBirthday = rightToken;
        } else {
            childName = rightToken;
            childBirthday = EXTRACT_RELATIVE_BIRTHDAY.apply(targetPerson.getRELATIVES(), rightToken);
        }

        Person.Child newChild = new Person.Child(childName, childBirthday);
        targetPerson.getCHILDREN().add(newChild);
    }

    private static void addParent(String leftToken, Person targetPerson) {
        String parentName;
        String parentBirthday;

        boolean isParentBirthday = Character.isDigit(leftToken.charAt(0));

        if (isParentBirthday) {
            parentName = EXTRACT_RELATIVE_NAME.apply(targetPerson.getRELATIVES(), leftToken);
            parentBirthday = leftToken;
        } else {
            parentName = leftToken;
            parentBirthday = EXTRACT_RELATIVE_BIRTHDAY.apply(targetPerson.getRELATIVES(), leftToken);
        }

        Person.Parent newParent = new Person.Parent(parentName, parentBirthday);
        targetPerson.getPARENTS().add(newParent);
    }


}
