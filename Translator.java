
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

    public static String DecimalTranslator(String decimalString){
        StringBuilder result = new StringBuilder();
        String[] decimals = decimalString.trim().split("\\s+");
        for (int i = 0; i < decimals.length; i++) {
            int decimal = Integer.parseInt(decimals[i]);
            String binary = Integer.toBinaryString(decimal);            
            while (binary.length() < 8) {
                binary = "0" + binary;
            }
            result.append(binary);
        }
        return result.toString();
    }
}
