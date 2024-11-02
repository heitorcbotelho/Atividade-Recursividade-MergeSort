package Atividade8;

public class Main {

    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[4];
        pessoas[0] = new Pessoa("Pedro", 16);
        pessoas[1] = new Pessoa("Marcio", 70);
        pessoas[2] = new Pessoa("Cleiton", 45);
        pessoas[3] = new Pessoa("Jonas", 20);
        Pessoa[] aux = new Pessoa[pessoas.length];
        mergeSort(pessoas, aux, 0, pessoas.length - 1);

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome() + " " + pessoa.getIdade() + " ");
        }
    }

    public static void mergeSort(Pessoa[] array, Pessoa[] aux, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(array, aux, inicio, meio);
            mergeSort(array, aux, meio + 1, fim);
            intercalar(array, aux, inicio, meio, fim);
        }
    }

    public static void intercalar(Pessoa[] array, Pessoa[] aux, int inicio, int meio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            aux[i] = array[i];
        }
        int esq = inicio;
        int dir = meio + 1;
        for (int i = inicio; i <= fim; i++) {
            if (esq > meio) {
                array[i] = aux[dir++];
            } else if (dir > fim) {
                array[i] = aux[esq++];
            } else if (aux[esq].getIdade() < aux[dir].getIdade()) {
                array[i] = aux[esq++];
            } else {
                array[i] = aux[dir++];
            }
        }
    }
}
