package Atividade5;

public class Main {
    public static void main(String[] args) {
        int num = sum(123);
        System.out.println(num);
    }
    public static int sum(int num){
        if(num < 10){
            return num;
        }else {
            return (num % 10) + sum(num / 10);
        }
    }
}
