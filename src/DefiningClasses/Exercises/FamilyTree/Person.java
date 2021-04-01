package DefiningClasses.Exercises.FamilyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String personName;
    private String personBirthday;
    private final Map<String, String> RELATIVES;
    private final List<Parent> PARENTS;
    private final List<Child> CHILDREN;

    public Person(String personData) {

        if (Character.isDigit(personData.charAt(0))) {
            this.personName = "";
            this.personBirthday = personData;
        } else {
            this.personName = personData;
            this.personBirthday = "";
        }

        this.RELATIVES = new HashMap<>();
        this.PARENTS = new ArrayList<>();
        this.CHILDREN = new ArrayList<>();
    }

    public void printFamilyTree() {
        System.out.printf("%s %s%n",personName,personBirthday);
        System.out.println("Parents:");
        if (!PARENTS.isEmpty()) {
            PARENTS.forEach(Parent::printParent);
        }
        System.out.println("Children:");
        if (!CHILDREN.isEmpty()) {
            CHILDREN.forEach(Child::printChild);
        }
    }
    
    public void updateRelativesList(String relativeName, String relativeBirthday) {
        RELATIVES.putIfAbsent(relativeName,relativeBirthday);
    }


    public void setPersonName(String input) {
        this.personName = input;
    }

    public void setPersonBirthday(String input) {
        this.personBirthday = input;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPersonBirthday() {
        return personBirthday;
    }

    public Map<String, String> getRELATIVES() {
        return RELATIVES;
    }

    public List<Parent> getPARENTS() {
        return PARENTS;
    }

    public List<Child> getCHILDREN() {
        return CHILDREN;
    }

    public static class Parent {
        private String parentName;
        private String parentBirthday;

        private void printParent() {
            System.out.printf("%s %s%n",parentName,parentBirthday);
        }

        public Parent(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }
    }

    public static class Child {
        private String childName;
        private String childBirthday;

        private void printChild() {
            System.out.printf("%s %s%n",childName,childBirthday);
        }

        public Child(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }
    }


}
