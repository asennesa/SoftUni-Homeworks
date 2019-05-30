import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File f = new File("D:\\Coding\\Exercises\\Java Advanced\\SoftUni-Homeworks\\" +
                "Java Advanced\\Streams, Files And Directories - Lab\\Resources\\04. Java-Adva" +
                "nced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File[] allFiles = f.listFiles();
        for (File file : allFiles) {
            if (!file.isDirectory()) {
                System.out.println(String.format("%s: [%d]", file.getName(), file.length()));
            }
        }
    }
}
