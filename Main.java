import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static List<String> readFile(String filePath) throws IOException {
        return Files.readAllLines(Path.of(filePath));
    }

    public static void main(String[] args) {
        try {
            List<String> lines = readFile("text.txt");
            for (String line : lines) {
                System.out.println(lines.toString());
            }
        } catch (IOException e) {
            System.err.println("error leyendo el archivo");
        }
    }


}

