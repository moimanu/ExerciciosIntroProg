//Exercício - Loop em Java: Ler 10 números e imprimir o maior e o menor deles.

import java.util.Scanner;
public class MaiorMenorValor {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int cont = 0;
        int menorNum = teclado.nextInt();
        int maiorNum = menorNum;
        int numAtual = 0;
        
        while(cont<9){
            numAtual = teclado.nextInt();
            if(numAtual < menorNum){
                menorNum = numAtual;
            } else if(numAtual > maiorNum) {
                maiorNum = numAtual;
            }
            cont++;
        }
        
        System.out.println(maiorNum);
        System.out.println(menorNum);
    }
}

/* EXEMPLO DE ENTRADA:

73
76
26
93
50
67
95
43
77
19

*/