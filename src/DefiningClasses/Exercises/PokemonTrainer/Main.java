
// TODO: 07.08.2020 г. Judge not ready 90 / 100

package DefiningClasses.Exercises.PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, Trainer> trainersDatabase = new LinkedHashMap<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (true) {
            String tokensInput = s.nextLine();

            if ("Tournament".equals(tokensInput)) {
                break;
            } else {
                String[] tokens = tokensInput.split("\\s+");

                updateTrainersDatabase(tokens);
            }
        }

        while (true) {
            String elementType = s.nextLine();

            if ("End".equals(elementType)) {
                break;
            } else {
                trainersDatabase
                        .values()
                        .forEach(trainer -> modifyTrainer(trainer, elementType));
            }
        }

        trainersDatabase.values().forEach(Trainer::clearDeadPokemons);

        trainersDatabase
                .values()
                .stream()
                .sorted((first, second) -> Integer.compare(second.getBadgesCount(), first.getBadgesCount()))
                .forEach(Main::actOnTrainer);


    }

    private static void actOnTrainer(Trainer trainer) {
        trainer.clearDeadPokemons();
        trainer.printTrainerStatistics();
    }

    private static void updateTrainersDatabase(String[] tokens) {
        String trainerName = tokens[0];
        Trainer newTrainer = new Trainer(trainerName);
        trainersDatabase.putIfAbsent(trainerName, newTrainer);
        trainersDatabase.get(trainerName).addPokemon(tokens);
    }

    private static void modifyTrainer(Trainer trainer, String elementType) {
        boolean trainerHasPokemonWithMatchingElement = trainer
                .getPokemonsList()
                .stream()
                .anyMatch(pokemon -> pokemon.getPokemonElement().equals(elementType));

        if (trainerHasPokemonWithMatchingElement) {
            trainer.increaseBadgesCount();
        } else {
            trainer
                    .getPokemonsList()
                    .forEach(Pokemon::decreasePokemonHealth);
        }
    }
}
