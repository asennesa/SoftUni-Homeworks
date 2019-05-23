import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, List<Double>> students = new TreeMap<>();
        while (n-- > 0) {
            String name = reader.readLine();
            List<Double> grades = Arrays.stream(reader.readLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).addAll(grades);

        }
        students.forEach((name, grade) -> {
            double sum = 0;
            for (Double aDouble : grade) {
                sum += aDouble;
            }
            double average = sum / grade.size();

            System.out.println(String.format("%s is graduated with %s", name, average));
        });
    }
}
