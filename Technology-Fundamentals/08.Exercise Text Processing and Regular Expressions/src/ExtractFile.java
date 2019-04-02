import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtractFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        String fileName = text.substring(text.lastIndexOf("\\") + 1, text.lastIndexOf("."));
        String fileExtension = text.substring(text.lastIndexOf(".") + 1);

        System.out.println(String.format("File name: %s", fileName));
        System.out.println(String.format("File extension: %s", fileExtension));


    }
}

