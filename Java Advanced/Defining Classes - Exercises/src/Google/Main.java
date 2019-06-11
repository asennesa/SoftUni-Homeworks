package Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> personMap = new HashMap<>();

        String input = "";
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] split = input.split("\\s+");
            String name = split[0];
            String command = split[1];
            Company company = new Company();
            Pokemon pokemon = new Pokemon();
            Parents parent = new Parents();
            Children children = new Children();
            Car car = new Car();
            Person person = new Person();
            person.setCompany(company);
            person.setCar(car);

            if (command.equalsIgnoreCase("company")) {
                company.setCompanyName(split[2]);
                company.setDepartment(split[3]);
                company.setSalary(Double.parseDouble(split[4]));
            }
            if (command.equalsIgnoreCase("pokemon")) {
                pokemon.setPokemonName(split[2]);
                pokemon.setPokemonType(split[3]);
                person.addPokemon(pokemon);

            }
            if (command.equalsIgnoreCase("parents")) {
                parent.setParentName(split[2]);
                parent.setParentBirthday(split[3]);
                person.addParent(parent);
            }
            if (command.equalsIgnoreCase("children")) {
                children.setChildName(split[2]);
                children.setChildBirthday(split[3]);
                person.addChildren(children);
            }
            if (command.equalsIgnoreCase("car")) {
                car.setCarModel(split[2]);
                car.setCarSpeed(split[3]);
            }

            if (!personMap.containsKey(name)) {
                personMap.put(name, person);
            } else {
                if (command.equalsIgnoreCase("company")) {
                    personMap.get(name).getCompany().setCompanyName(split[2]);
                    personMap.get(name).getCompany().setDepartment(split[3]);
                    personMap.get(name).getCompany().setSalary(Double.parseDouble(split[4]));
                }
                if (command.equalsIgnoreCase("pokemon")) {
                    pokemon.setPokemonName(split[2]);
                    pokemon.setPokemonType(split[3]);
                    personMap.get(name).addPokemon(pokemon);

                }
                if (command.equalsIgnoreCase("parents")) {
                    parent.setParentName(split[2]);
                    parent.setParentBirthday(split[3]);
                    personMap.get(name).addParent(parent);
                }
                if (command.equalsIgnoreCase("children")) {
                    children.setChildName(split[2]);
                    children.setChildBirthday(split[3]);
                    personMap.get(name).addChildren(children);
                }
                if (command.equalsIgnoreCase("car")) {
                    personMap.get(name).getCar().setCarModel(split[2]);
                    personMap.get(name).getCar().setCarSpeed(split[3]);
                }


            }
        }

        String inputName = reader.readLine();
        personMap.entrySet().forEach(p -> {
            if (p.getKey().equalsIgnoreCase(inputName)) {
                System.out.println(p.getKey());
                System.out.println("Company:");
                boolean nullTestCompany = p.getValue().getCompany().getCompanyName() == null;
                if (!nullTestCompany) {
                    System.out.println(p.getValue().getCompany());
                }
                System.out.println("Car:");
                boolean nullTestCar = p.getValue().getCar().getCarModel() == null;
                if (!nullTestCar) {
                    System.out.println(p.getValue().getCar());
                }
                System.out.println("Pokemon:");
                p.getValue().printPokemon();
                System.out.println("Parents:");
                p.getValue().printParents();
                System.out.println("Children:");
                p.getValue().printChildren();
            }
        });

    }
}
