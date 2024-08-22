//Exercício - Loop em Java: Imprimir os 100 primeiros números e a soma total.

public class Main {
    public static void main(String[] args) {
        
        int num = 1;
        int soma = 0;
        
        while(num<=100){
            System.out.println(num);
            soma += num;
            num++;
        }
        
        System.out.println(soma);
    }
}