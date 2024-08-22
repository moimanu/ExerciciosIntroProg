//Exercício - Loop em Java: Ler 10 números e imprimir os dois maiores deles.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int cont = 0;
        int maiorNum = teclado.nextInt();
        int segundoMaiorNum = 0;
        
        while(cont<9){
            int numAtual = teclado.nextInt();
            if(numAtual > maiorNum){
                segundoMaiorNum = maiorNum;
                maiorNum = numAtual;
            } else if(numAtual > segundoMaiorNum) {
                segundoMaiorNum = numAtual;
            }
            cont++;
        }
        
        System.out.println(maiorNum);
        System.out.println(segundoMaiorNum);
    }
}

/* EXEMPLO DE ENTRADA:

34
7
80
3
4
10
75
42
91
96

*/