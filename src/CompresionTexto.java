import java.util.Scanner;

public class CompresionTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el texto a comprimir:");
        String texto = scanner.nextLine();

        StringBuilder comprimido = new StringBuilder();

        int contador = 1;
        int uno = 1;
        //Buena practica
        int anchuraTexto = texto.length();
        
        //Recorre el ancho de texto
        for (int i = 1; i <= anchuraTexto; i++) {
            if (i < anchuraTexto && texto.charAt(i) == texto.charAt(i - uno)) {
                contador++;
            } else {
                comprimido.append(texto.charAt(i - uno));

                if (contador > uno) {
                    comprimido.append(contador);
                }
                contador = uno;
            }
        }

        System.out.println("Texto comprimido: " + comprimido.toString());

        // Descompresión
        StringBuilder descomprimir = new StringBuilder();
        int anchuraComprimido = comprimido.length();

        for (int i = 0; i < anchuraComprimido; i++) {
            char comprimidoChar = comprimido.charAt(i);
            if (Character.isLetter(comprimidoChar)) {
                descomprimir.append(comprimidoChar);
                
                if (i + uno < anchuraComprimido && Character.isDigit(comprimido.charAt(i + uno))) {
                    int num = Character.getNumericValue(comprimido.charAt(i + uno));
                    for (int j = uno; j < num; j++) {
                        descomprimir.append(contador);
                    }
                    i++;
                }
            }
        }

        System.out.println("Texto descomprimido: " + descomprimir.toString());

        scanner.close();
    }
}
