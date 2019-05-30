import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = userDir + "\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputEx5.txt";
        int pos = 1;
        try (BufferedReader bfr = new BufferedReader(new FileReader(pathIn));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))) {
            String line = "";
            while ((line = bfr.readLine()) != null) {
                if (pos % 3 == 0) {
                    bfw.write(line);
                    bfw.newLine();
                }
                pos++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
