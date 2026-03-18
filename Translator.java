
public class Translator{    
    public static String BinaryTranslator(String binaryString){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += 8) {
            int end = Math.min(i + 8, binaryString.length());
            String byte_str = binaryString.substring(i, end);
            int decimal = Integer.parseInt(byte_str, 2);
            
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(decimal);
        }
        
        return result.toString();
    }
    
}