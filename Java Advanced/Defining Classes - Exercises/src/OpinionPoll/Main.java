package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person> allPeople = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split("\\s+");
            Person person = new Person(split[0], Integer.parseInt(split[1]));
            allPeople.add(person);
        }
        allPeople.stream()
                .filter(e -> e.getAge() > 30)
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .forEach(e -> System.out.println(String.format("%s - %d", e.getName(), e.getAge())));


    }
}
