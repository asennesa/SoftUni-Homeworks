package Orderbyage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String end = reader.readLine();
        List<Student> students = new ArrayList<>();
        while(!end.equalsIgnoreCase("End")){
            String[] split =end.split("\\s+");
            Student stud = new Student();
            stud.setName(split[0]);
            stud.setId(split[1]);
            stud.setAge(Integer.parseInt(split[2]));
            students.add(stud);


            end = reader.readLine();
        }

        students
                .stream()
                .filter(person->person.getAge() > 0)
                .sorted((p1,p2)->Integer.compare(p1.getAge(),p2.getAge()))
                .forEach(e->{
                    System.out.println(e.toString());
                });






    }
}
