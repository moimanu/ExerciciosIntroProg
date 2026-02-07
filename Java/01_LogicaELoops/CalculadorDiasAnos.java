//Exercício - Loop em Java: Imprimir a quantidade de dias entre dois anos, considerando os bissextos.

import java.util.Scanner;
public class CalculadorDiasAnos {
    public static void main (String[] Args){
        Scanner t = new Scanner(System.in);
        int anoI, anoF, soma;
        boolean valendo = true;
        
        while(valendo){
            
            anoI = t.nextInt();
            anoF = t.nextInt();
            soma = 0;
        
            if(anoI == -9999 || anoF == -9999){
                valendo = false;
            } else {
                while(anoI <= anoF){
                    soma += 365;
                    if((anoI % 4 == 0 && anoI % 100 != 0) || anoI % 400 == 0){
                        soma++;
                    }
                    anoI++;
                }
                System.out.print(soma+"\n");
            }
        }
    }
}

/* EXEMPLO DE ENTRADA (CONDICAO DE PARADA == -9999)

2001 2010
2008 2015
2000 2024
-9999 -9999

*/