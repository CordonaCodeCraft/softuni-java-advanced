package DefiningClasses.Exercises.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    List<Pokemon> pokemonsList;
    private String trainerName;
    private int badgesCount;

    public Trainer(String trainerName) {
        this.trainerName = trainerName;
        this.badgesCount = 0;
        this.pokemonsList = new ArrayList<>();
    }


    public void clearDeadPokemons() {
        this.pokemonsList.removeIf(pokemon -> pokemon.getPokemonHealth() <= 0);
    }

    public void printTrainerStatistics() {
        System.out.printf("%s %d %d%n", getTrainerName(), getBadgesCount(), getPokemonsList().size());
    }


    public void addPokemon(String[] tokens) {
        String pokemonName = tokens[1];
        String pokemonElement = tokens[2];
        int pokemonHealth = Integer.parseInt(tokens[3]);
        Pokemon newPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
        pokemonsList.add(newPokemon);
    }

    public String getTrainerName() {
        return this.trainerName;
    }

    public int getBadgesCount() {
        return this.badgesCount;
    }

    public void increaseBadgesCount() {
        this.badgesCount += 1;
    }

    public List<Pokemon> getPokemonsList() {
        return this.pokemonsList;
    }
}
