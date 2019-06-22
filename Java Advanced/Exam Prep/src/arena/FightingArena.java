package arena;

import java.util.ArrayList;
import java.util.List;

public class FightingArena {
    private List<Gladiator> gladiators;
    private String name;

    public FightingArena(String name) {
        this.gladiators = new ArrayList<>();
        this.name = name;
    }

    public void add(Gladiator entity) {
        gladiators.add(entity);
    }

    public void remove(String name){
        for (Gladiator gladiator : gladiators) {
            if(gladiator.getName().equalsIgnoreCase(name)){
                gladiators.remove(gladiator);
            }

        }
    }
    public Gladiator getGladiatorWithHighestStatPower() {
        Gladiator bestStrHero = null;
        int max = Integer.MIN_VALUE;
        for (Gladiator hero : this.gladiators) {
            if (hero.getStatPower() > max) {
                max = hero.getStatPower();
                bestStrHero = hero;
            }
        }
        return bestStrHero;
    }
    public Gladiator getGladiatorWithHighestWeaponPower() {
        Gladiator bestStrHero = null;
        int max = Integer.MIN_VALUE;
        for (Gladiator gladiator : this.gladiators) {
            if (gladiator.getWeaponPower() > max) {
                max = gladiator.getWeaponPower();
                bestStrHero = gladiator;
            }
        }
        return bestStrHero;
    }
    public Gladiator getGladiatorWithHighestTotalPower() {
        Gladiator bestStrHero = null;
        int max = Integer.MIN_VALUE;
        for (Gladiator gladiator : this.gladiators) {
            if (gladiator.getTotalPower() > max) {
                max = gladiator.getTotalPower();
                bestStrHero = gladiator;
            }
        }
        return bestStrHero;
    }
    public int getCount(){
        return gladiators.size();
    }

    @Override
    public String toString() {
        return String.format("%s – %d gladiators are participating.",this.name,getCount());
    }
}
