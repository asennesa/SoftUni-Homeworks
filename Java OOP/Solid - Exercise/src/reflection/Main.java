package reflection;

import reflection.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Reflection reflection = new Reflection();

        //get type
        Class type = reflection.getClass();
        System.out.println(type);

        //get superClassType
        Class superClassType = reflection.getClass().getSuperclass();
        System.out.println(superClassType);

        //get all interfaces.
        Class<?>[] allInterfaces = reflection.getClass().getInterfaces();
        Arrays.stream(allInterfaces).forEach(e-> System.out.println(e));


        //Instantiate Object
        Class reflectionGetClass = Reflection.class;
        Reflection reflection1 = (Reflection) reflectionGetClass.getDeclaredConstructor().newInstance();
        System.out.println(reflection1);




    }
}
