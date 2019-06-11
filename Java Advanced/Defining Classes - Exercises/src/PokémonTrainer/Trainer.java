package PokémonTrainer;

import PokémonTrainer.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> pokemons;

    public Trainer() {
        this.pokemons = new ArrayList<>();
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }


    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

}
