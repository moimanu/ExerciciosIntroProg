//O objetivo desse código foi o de imprimir um quadrado, com um "x" dentro, e metade de uma linha vertical no centro, do topo ao meio.

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int num, invertidoI;
        System.out.print("Digite um número ímpar a partir de 7: ");
        num = teclado.nextInt();
        invertidoI = num;
        
        for(int i=1; i<=num; i++){
            for(int j=1; j<=num; j++){
                if(i==1 || i==num){
					System.out.print(" * ");					
				} else if(j == 1 || j == num){
					System.out.print(" * ");	
				} else if(i==j || j==invertidoI){
					System.out.print(" * ");	
				} else if(i<=(num+1)/2 & j==(num+1)/2){
					System.out.print(" * ");	
				} else {
					System.out.print("   ");	
				}
            }
            invertidoI--;
			System.out.println();
        }
    }
}
