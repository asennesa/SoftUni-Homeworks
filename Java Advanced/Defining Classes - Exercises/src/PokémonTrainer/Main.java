package PokémonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        String input = "";

        while (!"Tournament".equalsIgnoreCase(input = reader.readLine())) {
            String[] split = input.split("\\s+");
            String trainer = split[0];
            String pokemonName = split[1];
            String pokemonElement = split[2];
            int pokemonHealth = Integer.parseInt(split[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (!trainerMap.containsKey(trainer)) {
                Trainer trainer1 = new Trainer();
                trainer1.setName(trainer);
                trainer1.addPokemon(pokemon);
                trainerMap.put(trainer, trainer1);
            } else {
                trainerMap.get(trainer).addPokemon(pokemon);
            }

        }
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String inputElement = input;

            for (Map.Entry<String, Trainer> e : trainerMap.entrySet()) {
                boolean eleTest = e.getValue().getPokemons().stream().anyMatch(x -> x.getElement().equals(inputElement));
                if (eleTest) {
                    e.getValue().setNumberOfBadges(e.getValue().getNumberOfBadges() + 1);
                } else {
                    e.getValue().getPokemons().forEach(x -> x.setHealth(x.getHealth() - 10));
                }
                List filtered = e.getValue().getPokemons().stream().filter(x -> x.getHealth() > 0).collect(Collectors.toList());
                e.getValue().setPokemons(filtered);


            }


        }
        trainerMap.entrySet().stream().sorted((t1, t2) -> {
            int sorted = Integer.compare(t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges());
            if (sorted == 0) {

            }
            return sorted;
        }).forEach(e -> System.out.println(String.format("%s %d %d", e.getValue().getName(), e.getValue().getNumberOfBadges(), e.getValue().getPokemons().size())));
    }
}
