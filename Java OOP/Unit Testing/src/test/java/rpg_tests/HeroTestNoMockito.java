package rpg_tests;


import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTestNoMockito {
    private static final String HERO_NAME = "randomName";
    private static final int DEFAULT_EXPERIENCE = 10;
    private static final boolean DEFAULT_IS_TARGET_DEAD = true;
    private static final int DEFAULT_GET_HEALTH = 0;
    private static final int DEFAULT_ATTACK = 0;
    private static final int DEFAULT_DURABILITY = 0;

    @Test
    public void shouldGetExperienceIfTargetIsDead() {
        //Here you set the conditions of the Object after the "ACT" in that case after "hero.attack(target);".
        Target target = new Target() {
            @Override
            public int getHealth() {
                return DEFAULT_GET_HEALTH;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return DEFAULT_EXPERIENCE;
            }

            @Override
            public boolean isDead() {
                return DEFAULT_IS_TARGET_DEAD;
            }
        };
        Weapon weapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return DEFAULT_ATTACK;
            }

            @Override
            public int getDurabilityPoints() {
                return DEFAULT_DURABILITY;
            }

            @Override
            public void attack(Target target) {

            }
        };
        Hero hero = new Hero(weapon, HERO_NAME);

        hero.attack(target);

        Assert.assertEquals(DEFAULT_EXPERIENCE, hero.getExperience());

    }

}
