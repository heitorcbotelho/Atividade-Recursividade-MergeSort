package Atividade1;

public class Main {
    public static void main(String[] args) {
        String palavra = "arara";
        Palindromo(palavra, 0, palavra.length()-1);
    }

    public static void Palindromo(String palavra, int inicio, int fim){
        palavra = palavra.toLowerCase();
        if(inicio > fim){
            System.out.println("É um palíndromo");
            return;
        }
        if(palavra.charAt(inicio) == palavra.charAt(fim)){
            Palindromo(palavra, inicio +1, fim -1);
            return;
        }
        System.out.println("Não é palindromo");
        return;
    }
}
