package heroRepository;

import java.util.ArrayList;

import java.util.List;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add(Hero hero) {
        data.add(hero);
    }

    public void remove(String name) {
        for (Hero hero : data) {
            if (hero.getName().equalsIgnoreCase(name)) {
                data.remove(hero);
            }
        }
    }

    public Hero getHeroWithHighestStrength() {
        Hero bestStrHero = null;
        int max = Integer.MIN_VALUE;
        for (Hero hero : this.data) {
            if (hero.getItem().getStrength() > max) {
                max = hero.getItem().getStrength();
                bestStrHero = hero;
            }
        }
        return bestStrHero;
    }

    public Hero getHeroWithHighestAgility() {
        Hero bestStrHero = null;
        int max = Integer.MIN_VALUE;
        for (Hero hero : this.data) {
            if (hero.getItem().getAgility() > max) {
                max = hero.getItem().getAgility();
                bestStrHero = hero;
            }
        }
        return bestStrHero;
    }

    public Hero getHeroWithHighestIntelligence() {
        Hero bestStrHero = null;
        int max = Integer.MIN_VALUE;
        for (Hero hero : this.data) {
            if (hero.getItem().getIntelligence() > max) {
                max = hero.getItem().getIntelligence();
                bestStrHero = hero;
            }
        }
        return bestStrHero;
    }

    public int getCount() {
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Hero hero : data) {
            result.append(hero.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }
}
