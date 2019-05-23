import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String>vipGuests = new TreeSet<>();
        TreeSet<String>regularGuests = new TreeSet<>();
        String input = "";
        while(!"PARTY".equalsIgnoreCase(input=reader.readLine())) {
            if (input.length() == 8) {
                if (Character.isDigit(input.charAt(0))) {
                    vipGuests.add(input);
                } else {
                    regularGuests.add(input);
                }
            }
        }
        while(!"End".equalsIgnoreCase(input=reader.readLine())) {
                if (Character.isDigit(input.charAt(0))) {
                    vipGuests.remove(input);
                } else {
                    regularGuests.remove(input);
                }
            }
        System.out.println(vipGuests.size()+regularGuests.size());
        vipGuests.stream().forEach(e-> System.out.println(e));
        regularGuests.stream().forEach(e-> System.out.println(e));
    }
}
