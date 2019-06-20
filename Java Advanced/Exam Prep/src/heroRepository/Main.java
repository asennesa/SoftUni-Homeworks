package heroRepository;

public class Main {
    public static void main(String[] args) {
        HeroRepository repository = new HeroRepository();
        Item item = new Item(23, 35, 48);
        Item secondItem = new Item(100, 20, 13);

        Hero hero = new Hero("Hero Name", 24, item);
        Hero secondHero = new Hero("Second Hero Name", 125, secondItem);
        repository.add(hero);
        repository.add(secondHero);
        repository.remove("Hero Name");

        System.out.println(repository);
    }
}
