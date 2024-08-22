//Exercício - Loop em Java: Imprimir um losango com o caracter "%" a partir de um número como entrada.

import java.util.Scanner;
public class Main {
    public static void main (String[] Args){
        
        Scanner teclado = new Scanner(System.in);
        
        int num, cont, fator;
        num = teclado.nextInt();
        cont = 0;
        fator = 0;
        
        while(cont < num){
            for(int i = 1; i <= ((num*2)-1); i++){
                //Definindo o intervalo para imprimir "%":
                if(i >= (num-(2*fator)) && i <= (num+(2*fator))){
                    System.out.print("%");
                } else {
                    System.out.print(" ");
                }
            }
            
            //Definindo o valor do fator em relação à metade do losango:
            if(cont >= (num-1)/2){
             fator--;
            } else {
                fator++;
            }
            
            cont++;
            System.out.print("\n");
        }
    }
}