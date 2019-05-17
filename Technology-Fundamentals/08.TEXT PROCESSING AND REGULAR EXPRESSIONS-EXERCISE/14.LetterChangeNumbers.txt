import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        Pattern reg =Pattern.compile("(?<first>[A-Za-z])(?<number>\\d+)(?<second>[A-Za-z])");
        String alhpabet = " abcdefghijklmnopqrstuvwxyz";
        double sum= 0.0;

        for (String text:input) {
            Matcher matcher=reg.matcher(text);

            while(matcher.find()){
                String leftSymbol = matcher.group("first");
                double number = Double.parseDouble(matcher.group("number"));
                String rightSymbol = matcher.group("second");
                if(leftSymbol.equals((leftSymbol.toLowerCase()))){
                    number*= alhpabet.indexOf(leftSymbol.toLowerCase());
                }else{
                    if(number !=0){
                        number/=alhpabet.indexOf(leftSymbol.toLowerCase());
                    }
                }
                if(rightSymbol.equals((rightSymbol.toLowerCase()))){
                    number+= alhpabet.indexOf(rightSymbol.toLowerCase());
                }else{
                        number-=alhpabet.indexOf(rightSymbol.toLowerCase());

                }
                sum+=number;

            }

        }
        System.out.println(String.format("%.2f",sum));

        
    }
}
