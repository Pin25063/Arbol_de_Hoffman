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

            MinHeap heap = new MinHeap(tabla.size());

            for (Map.Entry<Character, List<Object>> entry : tabla.entrySet()) {
                Node n = new Node(entry.getKey(), (int) entry.getValue().get(0));
                heap.insert(n);
            }

            while (heap.getSize() > 1) {
                var min = heap.extractMin();
                var nextMin = heap.extractMin();
                Node parent = new Node( (int) (min.frequency + nextMin.frequency), min, nextMin);
                heap.insert(parent);
            }

        } catch (IOException e) {
            System.err.println("error leyendo el archivo");
        }
    }
}

