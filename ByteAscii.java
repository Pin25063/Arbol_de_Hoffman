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

    public static String fromAscii(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }

        StringBuilder numeros = new StringBuilder();
        char[] caracteres = texto.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            // Convertimos el carácter a su valor numérico (byte)
            int valorAscii = (int) caracteres[i];

            numeros.append(valorAscii);

            // Añadimos un espacio entre números, excepto al final
            if (i < caracteres.length - 1) {
                numeros.append(" ");
            }
        }

        return numeros.toString();
    }
}
