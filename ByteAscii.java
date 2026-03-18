public class ByteAscii {

    public static String toAscii() {

        String numeritos = Translator.BinaryTranslator("");

        if (numeritos == null || numeritos.isEmpty()) {
            return "";
        }


        String[] partes = numeritos.split(" ");
        StringBuilder resultadoReal = new StringBuilder();

        for (String parte : partes) {

            String limpia = parte.trim();

            if (!limpia.isEmpty()) {

                int codigoAscii = Integer.parseInt(limpia);
                resultadoReal.append((char) codigoAscii);
            }
        }


        return resultadoReal.toString();
    }
}
