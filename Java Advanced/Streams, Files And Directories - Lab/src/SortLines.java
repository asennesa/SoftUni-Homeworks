import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        Path pathIn = Paths.get(userDir + "\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path pathOut = Paths.get(userDir + "\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputEx6.txt");


        List<String> inputLines = Files.readAllLines(pathIn)
                .parallelStream()
                .filter(s -> !s.isEmpty())
                .sorted()
                .collect(Collectors.toList());

        Files.write(pathOut, inputLines);

    }
}
