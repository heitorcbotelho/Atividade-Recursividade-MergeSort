package Atividade9;

public class Main {

    public static void main(String[] args) {
        String[] palavras = {"banana", "maçã", "laranja", "uva", "kiwi"};

        String[] aux = new String[palavras.length];
        mergeSort(palavras, aux, 0, palavras.length - 1);

        System.out.println("Strings ordenadas:");
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
    }

    public static void mergeSort(String[] array, String[] aux, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(array, aux, inicio, meio);
            mergeSort(array, aux, meio + 1, fim);
            intercalar(array, aux, inicio, meio, fim);
        }
    }

    public static void intercalar(String[] array, String[] aux, int inicio, int meio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            aux[i] = array[i];
        }

        int esq = inicio;
        int dir = meio + 1;

        for (int i = inicio; i <= fim; i++) {
            if (esq > meio) {
                array[i] = aux[dir++]; // Se não houver mais elementos na sublista esquerda
            } else if (dir > fim) {
                array[i] = aux[esq++]; // Se não houver mais elementos na sublista direita
            } else if (aux[esq].compareTo(aux[dir]) <= 0) { // Comparação lexicográfica
                array[i] = aux[esq++]; // Elemento da esquerda é menor ou igual
            } else {
                array[i] = aux[dir++]; // Elemento da direita é menor
            }
        }
    }
}
