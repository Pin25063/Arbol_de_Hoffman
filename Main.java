import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<String> readFile(String filePath) throws IOException {
        return Files.readAllLines(Path.of(filePath));
    }

    public static void main(String[] args) {
        try {
            List<String> lines = readFile("text.txt");

            StringBuilder sb = new StringBuilder();

            for (String line : lines) {
                sb.append(line).append(" ");
            }

            String textoCompleto = sb.toString();
            
            Map<Character, List<Object>> tabla = Conteo.contarCaracteres(textoCompleto);


        } catch (IOException e) {
            System.err.println("error leyendo el archivo");
        }
    }
}

