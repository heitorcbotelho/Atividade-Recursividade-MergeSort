package Atividade6;

public class Main {
    public static void main(String[] args) {
        String aux = "", name = "Pedro";

    }

    public static void Inverter(String palavra, String aux){
        if(palavra.length() == 0){
            System.out.println(aux);
            return;
        }
        aux += palavra.charAt(palavra.length() - 1);
        Inverter((palavra.substring(0, palavra.length() -1)), aux);
    }
}
