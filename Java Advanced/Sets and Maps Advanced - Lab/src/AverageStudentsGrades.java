import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        TreeMap<String, List<Double>> studentRecord = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String student = input[0];
            double grade = Double.parseDouble(input[1]);
            if (!studentRecord.containsKey(student)) {
                studentRecord.put(student, new ArrayList<>());
                studentRecord.get(student).add(grade);
            } else {
                studentRecord.get(student).add(grade);
            }


        }
        studentRecord.forEach((name, grades) -> {
            double sum = 0;
            for (double v : grades) {
                sum += v;
            }
            double avg = sum / grades.size();
            System.out.printf("%s -> ", name);
            grades.forEach(a -> System.out.printf("%.2f ", a));
            System.out.printf("(avg: %.2f)", avg);
            System.out.println();
        });

    }
}
