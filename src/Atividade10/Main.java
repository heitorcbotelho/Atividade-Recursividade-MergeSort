package Atividade10;


import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int[] tam = { 1000, 10000, 100000, 1000000 };
        int rep = 10;
        for (int tamanho : tam) {
            System.out.println("Tamanho do array: " + tamanho);
            long tempoMergeSort = 0;
            long tempoBubbleSort = 0;
            long tempoSelectionSort = 0;
            long tempoInsertionSort = 0;


            for (int i = 0; i < rep; i++) {
                int[] array = arrayAleatorio(tamanho);


                int[] arrayMergeSort = Arrays.copyOf(array, array.length);
                int[] arrayBubbleSort = Arrays.copyOf(array, array.length);
                int[] arraySelectionSort = Arrays.copyOf(array, array.length);
                int[] arrayInsertionSort = Arrays.copyOf(array, array.length);


                tempoMergeSort += Tempo(() -> mergeSort(arrayMergeSort));
                tempoBubbleSort += Tempo(() -> bubbleSort(arrayBubbleSort));
                tempoSelectionSort += Tempo(() -> selectionSort(arraySelectionSort));
                tempoInsertionSort += Tempo(() -> insertionSort(arrayInsertionSort));
            }


            System.out.println("Tempo médio Merge Sort: " + (tempoMergeSort / rep) + " ns");
            System.out.println("Tempo médio Bubble Sort: " + (tempoBubbleSort / rep) + " ns");
            System.out.println("Tempo médio Selection Sort: " + (tempoSelectionSort / rep) + " ns");
            System.out.println("Tempo médio Insertion Sort: " + (tempoInsertionSort / rep) + " ns");
            System.out.println();
        }
    }


    public static int[] arrayAleatorio(int tamanho) {
        Random random = new Random();
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(1000000);
        }
        return array;
    }


    public static long Tempo(Runnable algoritmo) {
        long inicio = System.nanoTime();
        algoritmo.run();
        return System.nanoTime() - inicio;
    }


    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int meio = array.length / 2;
            int[] esquerda = Arrays.copyOfRange(array, 0, meio);
            int[] direita = Arrays.copyOfRange(array, meio, array.length);


            mergeSort(esquerda);
            mergeSort(direita);


            int i = 0, j = 0, k = 0;
            while (i < esquerda.length && j < direita.length) {
                if (esquerda[i] <= direita[j]) {
                    array[k++] = esquerda[i++];
                } else {
                    array[k++] = direita[j++];
                }
            }
            while (i < esquerda.length) {
                array[k++] = esquerda[i++];
            }
            while (j < direita.length) {
                array[k++] = direita[j++];
            }
        }
    }


    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }


    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
