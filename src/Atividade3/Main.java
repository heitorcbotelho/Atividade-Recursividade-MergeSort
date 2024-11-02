package Atividade3;

public class Main {
    public static void main(String[] args) {
        int palavra = cont("carroça", 'r');
        System.out.println(palavra);
    }

    public static int cont(String palavra, char a) {
        // Verifica se a palavra é nula
        if (palavra == null || palavra.isEmpty()) {
            return 0;
        }

        palavra = palavra.toLowerCase();
        a = Character.toLowerCase(a);

        //Verifica se a palavra tem um único caractere
        if (palavra.length() == 1) {
            return (palavra.charAt(0) == a) ? 1 : 0;
        }

        //Verifica o ultimo caractere
        if (palavra.charAt(palavra.length() - 1) == a) {
            return 1 + cont(palavra.substring(0, palavra.length() - 1), a);
        } else {
            return cont(palavra.substring(0, palavra.length() - 1), a);
        }
    }
}
