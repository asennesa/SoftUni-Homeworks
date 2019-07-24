package blackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class bbox = BlackBoxInt.class;

        BlackBoxInt blackBoxInt = null;
        try {
            Constructor declaredConstructor = bbox.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
             blackBoxInt = (BlackBoxInt)declaredConstructor.newInstance();

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }


        String input = "";

        while(!"END".equalsIgnoreCase(input=reader.readLine())){
            String[] split = input.split("_");
            String command = split[0];
            int numValue = Integer.parseInt(split[1]);
            Method[] declaredMethod = bbox.getDeclaredMethods();

            Method method =Arrays.stream(declaredMethod)
                    .filter(e->e.getName().equalsIgnoreCase(command))
                    .findFirst()
                    .orElse(null);


            method.setAccessible(true);
            try {
                method.invoke(blackBoxInt,numValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            try {
                Field innerValue = bbox.getDeclaredField("innerValue");
                innerValue.setAccessible(true);
                System.out.println(innerValue.getInt(blackBoxInt));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }


        }

    }
}
