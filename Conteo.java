import java.util.*;

public class Conteo {

    public static Map<Character, List<Object>> contarCaracteres(List<String> lines) {
        Map<Character, List<Object>> tabla = new HashMap<>();

        for (String line : lines) {
            for (char c : line.toCharArray()) {

                List<Object> datos = tabla.get(c);
                if (datos == null) {
                    datos = new ArrayList<>();
                    datos.add(1);      // conteo
                    datos.add(0.0);    // frecuencia
                    datos.add(null);   // código Huffman
                    tabla.put(c, datos);
                } else {
                    datos.set(0, (int) datos.get(0) + 1);
                }
            }
        }
        calcularFrecuencia(tabla);
        return tabla;
    }

    private static void calcularFrecuencia(Map<Character, List<Object>> tabla) {
        int total = 0;

        for (List<Object> datos : tabla.values()) { //conteo totales
            total += (int) datos.get(0);
        }

        for (List<Object> datos : tabla.values()) {
            int conteo = (int) datos.get(0);
            datos.set(1, (double) conteo / total);
        }
    }
}
