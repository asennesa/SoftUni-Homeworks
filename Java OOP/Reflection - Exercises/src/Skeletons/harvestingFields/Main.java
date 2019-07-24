package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class fields = harvestingFields.RichSoilLand.class;

        Field[] declaredFields = fields.getDeclaredFields();
        Field asd = declaredFields[1];


        String input = "";
        while (!"HARVEST".equalsIgnoreCase(input = reader.readLine())) {
            switch (input) {
                case "private":
                    Arrays.stream(declaredFields).filter(e -> Modifier.isPrivate(e.getModifiers()))
                            .forEach(e -> System.out.println(String.format("%s %s %s", Modifier.toString(e.getModifiers()),
                                    e.getType().getSimpleName(), e.getName())));
                    break;
                case "protected":
                    Arrays.stream(declaredFields).filter(e -> Modifier.isProtected(e.getModifiers()))
                            .forEach(e -> System.out.println(String.format("%s %s %s", Modifier.toString(e.getModifiers())
                                    , e.getType().getSimpleName(), e.getName())));
                    break;
                case "public":
                    Arrays.stream(declaredFields).filter(e -> Modifier.isPublic(e.getModifiers()))
                            .forEach(e -> System.out.println(String.format("%s %s %s", Modifier.toString(e.getModifiers())
                                    , e.getType().getSimpleName(), e.getName())));
                    break;
                default:
                    Arrays.stream(declaredFields).forEach(e -> System.out.println(String.format("%s %s %s", Modifier.toString(e.getModifiers())
                            , e.getType().getSimpleName(), e.getName())));
                    break;

            }
        }

    }

}
