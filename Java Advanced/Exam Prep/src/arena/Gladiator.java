package arena;

public class Gladiator {
    private String name;
    private Stat stat;
    private Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }
    public int getStatPower(){
        int sum = this.stat.getAgility()+this.stat.getFlexibility()
                +this.stat.getIntelligence()+this.stat.getSkills()
                +this.stat.getStrength();
        return sum;
    }
    public int getWeaponPower(){
        int wepSum=this.weapon.getSharpness()
                +this.weapon.getSize()
                +this.weapon.getSolidity();
        return wepSum;
    }
    public int getTotalPower(){
        int totalSum = getWeaponPower()+getStatPower();
        return totalSum;
    }

    @Override
    public String toString() {
        return String.format("%s - %d%n Weapon power: %d%n Stat Power: %d",getName()
        ,getTotalPower(),getWeaponPower()
        ,getStatPower());
    }
}
