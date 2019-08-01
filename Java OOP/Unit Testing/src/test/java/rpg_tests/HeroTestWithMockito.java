package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTestWithMockito {
    private static final String HERO_NAME = "randomName";
    private static final int DEFAULT_EXPERIENCE = 10;
    private static final boolean DEFAULT_IS_TARGET_DEAD = true;
    private static final int DEFAULT_ATTACK = 0;
    private static final int DEFAULT_DURABILITY = 0;

    @Test
    public void shouldGetExperienceIfTargetIsDead() {
        Target target = Mockito.mock(Target.class);
        Mockito.when(target.giveExperience()).thenReturn(DEFAULT_EXPERIENCE);
        Mockito.when(target.isDead()).thenReturn(DEFAULT_IS_TARGET_DEAD);

        Weapon weapon = Mockito.mock(Weapon.class);
        Mockito.when(weapon.getAttackPoints()).thenReturn(DEFAULT_ATTACK);
        Mockito.when(weapon.getDurabilityPoints()).thenReturn(DEFAULT_DURABILITY);

        Hero hero = new Hero(weapon, HERO_NAME);

        hero.attack(target);

        Assert.assertEquals(DEFAULT_EXPERIENCE, hero.getExperience());


    }
}
