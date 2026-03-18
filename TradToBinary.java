import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TradToBinary {
    public static String TraductionToBinary(String text, HashMap<Character, List<Object>> charMap) {
        ArrayList<String> binaryValues = new ArrayList<>();
        char[] splitText = text.toCharArray();
        for (char character : splitText) {
            if (charMap.containsKey(character)){
                binaryValues.add(charMap.get(character).get(2).toString());
            }
        }
        System.out.println("Traduccion a binario: " + String.join("", binaryValues));
        return String.join("", binaryValues);
        
    }
}
