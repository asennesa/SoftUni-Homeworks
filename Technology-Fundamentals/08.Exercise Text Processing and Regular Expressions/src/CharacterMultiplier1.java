import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        String firstWord = text.substring(0,text.indexOf(' '));
        String secondWord = text.substring(text.lastIndexOf(' ') + 1);
        int sum =multiplyCharacters(firstWord,secondWord);
        System.out.println(sum);


    }
    private static int multiplyCharacters(String first, String second){
        int minLength = Math.min (first.length(), second.length());
        int sum = 0;
        for (int i = 0; i < minLength; i++) {
            sum+= first.charAt(i)*second.charAt(i);

        }
        String maxLength=first.length()<second.length()?second : first;
        for (int i = minLength; i < maxLength.length(); i++) {
            sum+=maxLength.charAt(i);
        }
        return sum;
    }
}