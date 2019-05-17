package Students;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Students> studs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input=reader.readLine();
            String[] split = input.split("\\s+");
            Students studentObject = new Students(split[0],split[1],Double.parseDouble(split[2]));
            studs.add(studentObject);

        }
        studs
                .stream()
                .sorted((p1,p2)->Double.compare(p2.getGrade(),p1.getGrade()))
                .forEach(e ->{
                    System.out.println(e.toString());
                });

    }
}
