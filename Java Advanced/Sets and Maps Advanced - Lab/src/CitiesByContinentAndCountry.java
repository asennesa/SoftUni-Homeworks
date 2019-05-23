import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Map<String, List<String>>> continentCountryCity = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split("\\s+");
            String continent = split[0];
            String country = split[1];
            String city = split[2];
            continentCountryCity.putIfAbsent(continent, new LinkedHashMap<>());
            continentCountryCity.get(continent).putIfAbsent(country, new ArrayList<>());
            continentCountryCity.get(continent).get(country).add(city);

        }
        continentCountryCity.entrySet().forEach(e -> {
            System.out.println(e.getKey() + ":");
            e.getValue().entrySet().forEach(c -> {
                System.out.print(String.format("  %s -> ", c.getKey()));
                System.out.print(c.getValue().toString().replaceAll("\\[|\\]", "") + "\n");
            });

        });

    }
}
