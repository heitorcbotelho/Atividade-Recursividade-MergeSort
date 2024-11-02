package Atividade2;

public class Main {
    public static void main(String[] args) {
        int[] array = {2, 7, 9, 5, 3};
        System.out.println(sumArray(array));
    }
    public static int sumArray(int[] array){
        int tam = array.length-1;
        int[] aux = new int[tam];
        for (int i = 0; i < aux.length; i++){
            aux[i] = array[i];
        }
        if(aux.length == 1){
            return  aux[0] + array [tam];
        }
        return array[tam] + sumArray(aux);
    }
}
