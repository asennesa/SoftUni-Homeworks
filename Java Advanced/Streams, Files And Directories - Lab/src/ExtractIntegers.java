import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = userDir + "\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputEx4.txt";

        try (Scanner scanner = new Scanner(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(pathOut)) {
            while (scanner.hasNext()) {
                scanner.next();
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
