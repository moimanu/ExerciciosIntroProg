//Exercício - Loop em Java: Imprimir a quantidade de números primos encontrados.

import java.util.Scanner;

public class ContagemNumerosPrimos {
    
    public static void main (String[] args){
        
        Scanner t = new Scanner(System.in);
        int num, cont = 0;

        do {
            boolean primo = false;
            
            num = t.nextInt();
            
            if(num > 0) {
                //Coloquei o limite do laço em "num/2" para otimizar o algoritmo
                for(int n = 2; n <= num/2; n++){
                    if(num%n == 0){
                        primo = false;
                        break;
                    } else {
                        primo = true;
                    }
                }
                if(primo){
                    cont++;
                }
            }  
        } while(num > 0);
        
        System.out.println(cont);
    }
}

/* EXEMPLO DE ENTRADA (CONDICAO DE PARADA < 0):

8360
1163
1907
5683
7568
1503
9751
7521
7695
9836
5733
5990
5946
8358
2646
6074
7937
9781
8182
1672
-1

*/