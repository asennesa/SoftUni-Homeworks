import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Jar - Writing generic classes.
        Jar<String> jarOfStrings = new Jar<String>();
        jarOfStrings.add("StringHere");
        System.out.println(jarOfStrings.remove());


        // ArrayCreator - writing generic Methods.
        Character[] array = ArrayCreator.<Character>create(Character.class, 3, 'a');
        for (Character character : array) {
            System.out.println(character);
        }

        //Type Parameter Bounds
        GenericScale<Integer> scale = new GenericScale<>(42, 512);
        System.out.println(scale.getHeavier());

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(12);
        nums.add(3);
        nums.add(52);
        int maxInt = ListUtilities.getMax(nums);
        System.out.println(maxInt);

    }
}
