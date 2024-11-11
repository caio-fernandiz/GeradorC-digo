import java.util.Random;

public class GeradorCodigo {
    public static void main(String[] args) {
        System.out.println(gerarCodigoAleatorio());
    }

    public static String gerarCodigoAleatorio() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        // Gera os três primeiros caracteres com pelo menos uma letra e um número
        int letraIndex = random.nextInt(3); // Índice aleatório para a posição da letra
        int numeroIndex = random.nextInt(3); // Índice aleatório para a posição do número

        while (letraIndex == numeroIndex) { // Garante que as posições sejam diferentes
            numeroIndex = random.nextInt(3);
        }

        for (int i = 0; i < 3; i++) {
            if (i == letraIndex) {
                // Garante que essa posição é uma letra
                codigo.append(letras.charAt(random.nextInt(letras.length())));
            } else if (i == numeroIndex) {
                // Garante que essa posição é um número
                codigo.append(numeros.charAt(random.nextInt(numeros.length())));
            } else {
                // Insere aleatoriamente uma letra ou um número nas outras posições
                if (random.nextBoolean()) {
                    codigo.append(letras.charAt(random.nextInt(letras.length())));
                } else {
                    codigo.append(numeros.charAt(random.nextInt(numeros.length())));
                }
            }
        }

        // Adiciona o traço
        codigo.append("-");

        // Gera os dois últimos caracteres com pelo menos uma letra e um número
        letraIndex = random.nextInt(2); // Índice aleatório para a posição da letra
        numeroIndex = 1 - letraIndex;   // O outro índice será o número

        for (int i = 0; i < 2; i++) {
            if (i == letraIndex) {
                // Garante que essa posição é uma letra
                codigo.append(letras.charAt(random.nextInt(letras.length())));
            } else {
                // Garante que essa posição é um número
                codigo.append(numeros.charAt(random.nextInt(numeros.length())));
            }
        }

        return codigo.toString();
    }
}
