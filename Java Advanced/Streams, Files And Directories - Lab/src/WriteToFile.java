import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = userDir + "\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";
        try (FileInputStream fis = new FileInputStream(pathIn);
             FileOutputStream fos = new FileOutputStream(pathOut)) {
            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (oneByte != '.' && oneByte != ',' && oneByte != '?' && oneByte != '!') {
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
