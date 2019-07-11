package lab.borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        List<Robot> robots = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();

        while (!"End".equalsIgnoreCase(input = reader.readLine())) {
            String[] split = input.split("\\s+");
            if (split.length == 3){
                Citizen citizen = new Citizen(split[0],Integer.parseInt(split[1]),split[2]);
                citizens.add(citizen);
            }else if (split.length==2){
                Robot robot = new Robot(split[1],split[0]);
                robots.add(robot);
            }

        }
        String fakeIds = reader.readLine();
        citizens.stream().map(Citizen::getId).filter(e->e.endsWith(fakeIds)).forEach(e-> System.out.println(e));
        robots.stream().map(Robot::getId).filter(e->e.endsWith(fakeIds)).forEach(e-> System.out.println(e));
    }
}
