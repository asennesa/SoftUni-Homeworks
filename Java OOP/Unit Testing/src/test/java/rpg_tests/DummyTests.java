package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EXPERIENCE = 50;
    private static final int EXPECTED_HEALTH = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void shouldLoseHealthIfAttacked() {


        this.axe.attack(this.dummy);

        Assert.assertEquals(EXPECTED_HEALTH, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfAttackedWhileDead() {
        this.axe.attack(dummy);
        this.axe.attack(dummy);
        this.axe.attack(dummy);


    }

    @Test
    public void shouldGiveExperienceIfDead() {
        this.axe.attack(dummy);
        this.axe.attack(dummy);
        int XP = dummy.giveExperience();
        Assert.assertEquals(XP, DUMMY_EXPERIENCE);

    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotGiveExperienceIfAlive() {

        this.dummy.giveExperience();
    }

}
