import java.util.Scanner;

public class CompresionTexto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el texto a comprimir:");
        String texto = sc.nextLine();

        StringBuilder compr = new StringBuilder();
        int c = 1;
        for (int i = 1; i <= texto.length(); i++) {
            if (i < texto.length() && texto.charAt(i) == texto.charAt(i - 1)) {
                c++;
            } else {
                compr.append(texto.charAt(i - 1));
                if (c > 1) {
                    compr.append(c);
                }
                c = 1;
            }
        }

        System.out.println("Texto comprimido: " + compr.toString());

        // Descompresión
        StringBuilder decompr = new StringBuilder();
        for (int i = 0; i < compr.length(); i++) {
            char ch = compr.charAt(i);
            if (Character.isLetter(ch)) {
                decompr.append(ch);
                if (i + 1 < compr.length() && Character.isDigit(compr.charAt(i + 1))) {
                    int num = Character.getNumericValue(compr.charAt(i + 1));
                    for (int j = 1; j < num; j++) {
                        decompr.append(c);
                    }
                    i++;
                }
            }
        }

        System.out.println("Texto descomprimido: " + decompr.toString());

        sc.close();
    }
}
