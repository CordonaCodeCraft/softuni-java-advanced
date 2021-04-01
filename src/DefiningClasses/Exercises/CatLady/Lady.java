package DefiningClasses.Exercises.CatLady;

import java.util.HashMap;
import java.util.Map;

public class Lady {
    private Map<String, Cat> cats;

    public Lady() {
        this.cats = new HashMap<>();
    }

    public Map<String, Cat> getCats() {
        return cats;
    }

    public void updateCatsDatabase(String catName, Cat cat) {
        cats.putIfAbsent(catName, cat);
    }

    public class Cat {
        private String catName;
        private String catType;
        private double catParameter;

        public Cat(String catType, String catName, double catParameter) {
            this.catName = catName;
            this.catType = catType;
            this.catParameter = catParameter;
        }

        public void printCat() {
            System.out.printf("%s %s %.2f", catType, catName, catParameter);
        }
    }
}
