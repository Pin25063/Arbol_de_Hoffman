import java.nio.charset.StandardCharsets;

public class ByteAscii {

    public static String toAscii() {
        byte[] bytes = Translator.BinaryTranslator();
        if (bytes == null) {
            return "";
        }
        return new String(bytes, StandardCharsets.US_ASCII);

    }

}
