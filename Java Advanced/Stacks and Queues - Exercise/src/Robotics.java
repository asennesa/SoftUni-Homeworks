import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayDeque;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(";");
        String[] robots = new String[input.length];
        int [] processTime = new int[input.length];
        int [] worktime = new int[input.length];
        for (int i=0; i < robots.length ;i++) {
            String[] data = input[i].split("-");
            String name = data[0];
            int time  = Integer.parseInt(data[1]);
            robots[i]=name;
            processTime[i]=time;

        }
        String startTime = reader.readLine();
        ArrayDeque<String>products = new ArrayDeque<>();
        String inputProduct = reader.readLine();
        while(!inputProduct.equalsIgnoreCase("end")){
            products.offer(inputProduct);
            inputProduct=reader.readLine();
        }
        String[]timeData =startTime.split(":");
        int hours= Integer.parseInt(timeData[0]);
        int minutes= Integer.parseInt(timeData[1]);
        int seconds= Integer.parseInt(timeData[2]);

        int beginSecond = hours*3600+minutes*60+seconds;
        while(!products.isEmpty()){
            beginSecond++;
            String product = products.poll();
            boolean isAssigned = false;
            for(int i = 0 ; i < robots.length; i++){
                if (worktime[i]==0 && !isAssigned){
                    worktime[i]=processTime[i];
                    isAssigned=true;
                    printRobotData(robots[i],product,beginSecond);
                }
                if(worktime[i]>0){
                    worktime[i]--;
                }

            }
            if(!isAssigned){
                products.offer(product);
            }
        }

    }

    private static void printRobotData(String robot, String product, int beginSecond) {
        long s = beginSecond % 60;
        long m = (beginSecond / 60) % 60;
        long h = (beginSecond / (60 * 60)) % 24;
        System.out.println(robot + " - "+product + " "+String.format("[%02d:%02d:%02d]",h,m,s));
    }
}
