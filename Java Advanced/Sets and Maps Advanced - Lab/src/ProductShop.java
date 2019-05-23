import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Double>> stores = new TreeMap<>();

        String input = "";
        while (!"revision".equalsIgnoreCase(input = reader.readLine())) {
            String[] split = input.split(", ");
            String store = split[0];
            String product = split[1];
            double price = Double.parseDouble(split[2]);

            if (!stores.containsKey(store)) {
                stores.put(store, new LinkedHashMap<>());
                stores.get(store).put(product, price);
            } else {
                stores.get(store).put(product, price);
            }
        }
        stores.forEach((key, value) -> {
            System.out.println(String.format("%s->", key));
            value.forEach((product, price) -> System.out.println(String.format("Product: %s, Price: %.1f", product, price)));
        });

    }
}
