package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int n = Integer.parseInt(reader.readLine());
        TrafficLights[] lights = new TrafficLights[input.length];
        for (int i = 0; i < input.length; i++) {
            lights[i] = TrafficLights.valueOf(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            for (int i = 0; i < input.length; i++) {
                switch (lights[i]) {
                    case GREEN:
                        sb.append("YELLOW ");
                        lights[i] = TrafficLights.valueOf("YELLOW");
                        break;
                    case RED:
                        sb.append("GREEN ");
                        lights[i] = TrafficLights.valueOf("GREEN");
                        break;
                    case YELLOW:
                        sb.append("RED ");
                        lights[i] = TrafficLights.valueOf("RED");

                }
            }
            System.out.println(sb.toString().trim());
            sb.delete(0, sb.length());
        }


    }
}
