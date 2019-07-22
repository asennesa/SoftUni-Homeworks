package gettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();
        Class allMethods = Reflection.class;

        Method[] declaredMethods = allMethods.getDeclaredMethods();
        Arrays.stream(declaredMethods).filter(e->e.getName().startsWith("get")).forEach(e-> System.out.println(e));

    }

}
