import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Reflection reflection = new Reflection();
        Class getMethods = Reflection.class;
        Method[] declaredMethods = getMethods.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(e -> e.getName().startsWith("get") && e.getParameterCount() == 0).sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.println(String.format("%s will return class %s", e.getName(), e.getReturnType().getName())));

        Arrays.stream(declaredMethods)
                .filter(e -> e.getName().startsWith("set") && e.getParameterCount() == 1).sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.println(String.format("%s and will set field of class %s", e.getName(), e.getParameterTypes()[0].getName())));


    }

}
