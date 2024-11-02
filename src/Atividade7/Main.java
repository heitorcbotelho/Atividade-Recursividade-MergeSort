package Atividade7;

public class Main {
    public static void main(String[] args) {
        int[][] array = {{1,2,3}, {4,8,9}, {80,1,7}};
        for(int i = 0; i < array.length; i++){
            int[] aux = new int[array[i].length];
            mergeSort(array[i], aux, 0, array.length - 1);
        }
        for (int i = 0; i < array.length; i++) {
            for (int a = 0; a < array[0].length; a++) {
                System.out.print(array[i][a] + " ");
            }
            System.out.println();
        }

    }

    public static void mergeSort(int[] array, int[] aux, int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSort(array, aux, inicio, meio);
            mergeSort(array, aux, meio + 1, fim);
            intercalar(array, aux, inicio, meio, fim);
        }
    }

    public static void intercalar(int[] array, int[] aux, int inicio, int meio, int fim){
        for(int i = inicio; i <= fim; i++){
            aux[i] = array[i];
        }
        int esq = inicio;
        int dir = meio + 1;
        for(int i = inicio; i <= fim; i++){
            if(esq > meio){
                array[i] = aux[dir++];
            } else if (dir > fim) {
                array[i] = aux[esq++];
            } else if (aux[esq] < aux[dir]) {
                array[i] = aux[esq++];
            }else {
                array[i] = aux[dir++];
            }
        }
    }
}
