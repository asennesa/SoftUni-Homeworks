import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String path = userDir + "\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (FileInputStream fis = new FileInputStream(path)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                String res = Integer.toBinaryString(oneByte);
                System.out.print(res + " ");
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}