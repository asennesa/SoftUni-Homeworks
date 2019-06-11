package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public Person() {
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    public void addParent(Parents parent) {
        this.parents.add(parent);
    }

    public void addChildren(Children children) {
        this.children.add(children);
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void printPokemon() {
        this.pokemon.forEach(poke -> System.out.println(poke));
    }

    public void printParents() {
        this.parents.forEach(parents -> System.out.println(parents));
    }

    public void printChildren() {
        this.children.forEach(children -> System.out.println(children));
    }
}
