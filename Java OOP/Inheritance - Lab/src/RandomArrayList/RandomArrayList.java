package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private static final Random random;

    static {
        random = new Random();
    }

    public Object getRandomElement() {
        Object o = super.get(random.nextInt(super.size()));
        super.remove(o);
        return o;


    }
}
