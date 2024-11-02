package Atividade4;

public class Main {
    public static void main(String[] args) {
        int fibo = fibonacci(10);
        System.out.println(fibo);
    }

    public static int fibonacci(int num){
        if(num == 1){
            return num;
        }
        return (fibonacci(num -1)) + num;
    }
}

