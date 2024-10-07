package quebracabecadeslizante;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuebraCabecaDeslizante {
    
    public static int printarMatriz(int[][] matriz) {
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(matriz[i][j] != 0){
                    if(matriz[i][j] == 9){
                        System.out.print("  ");
                    } else {
                        System.out.print(matriz[i][j] + " ");
                    }
                }
            }
            if(i > 0 && i < 4){
                System.out.println();
            }
        }
        return 0;
    }
    
    public static void perguntarNumero(){
        System.out.print("Qual numero alterar? ");
    }

    public static void main(String[] args) {
        
        Scanner t = new Scanner(System.in);
        
        //Criando matriz para o jogo:
        int matriz[][] = new int[5][5];
        
        //Preenchendo a matriz de maneira aleatória:
        Random random = new Random();
        
        ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        
        int contador = 1;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                
                if(i == 0 || i == 4 || j == 0 || j == 4){
                    matriz[i][j] = 0;
                } else {
                    int valor;
                    do{
                        valor = random.nextInt(lista.size());
                    } while(contador == valor);
                    
                    matriz[i][j] = lista.get(valor);
                    lista.remove(valor);
                }
            }
        }
        
        //Interagindo com o usuário até que a ordem esteja certa:
        boolean logico = true;
        
        do{
            /* 
            *    O logico comeca "false" para, se algum número estiver na ordem 
            *    errada, torná-lo verdadeiro e não sair do loop.
            */
            
            //logico = false;
            
            printarMatriz(matriz);
            perguntarNumero();
        
            //Entrada:
            int entrada = t.nextInt();
            boolean trocou = true;
            
            //Alterando matriz:
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    
                    //Conferindo se está no espaço vazio:
                    if(matriz[i][j] == 9 && trocou == true){
                        
                        if(matriz[i+1][j] == entrada){ //Conferindo baixo
                            matriz[i][j] = entrada;
                            matriz[i+1][j] = 9;
                            trocou = false;
                        } else
                        
                        if(matriz[i][j+1] == entrada){ //Conferindo direita
                            matriz[i][j] = entrada;
                            matriz[i][j+1] = 9;
                            trocou = false;
                        } else
                        
                        if(matriz[i-1][j] == entrada){ //Conferindo baixo
                            matriz[i][j] = entrada;
                            matriz[i-1][j] = 9;
                            trocou = false;
                        } else
                        
                        if(matriz[i][j-1] == entrada){ //Conferindo direita
                            matriz[i][j] = entrada;
                            matriz[i][j-1] = 9;
                            trocou = false;
                        } else
                            
                        {
                            System.out.println("Tente outro numero...");
                        }
                        
                    }
                }
            }        
            
            if(matriz[1][1] == 1 && matriz[1][2] == 2 && matriz[1][3] == 3 &&
               matriz[2][1] == 4 && matriz[2][2] == 5 && matriz[2][3] == 6 &&
               matriz[3][1] == 7 && matriz[3][2] == 8 && matriz[3][3] == 9){
                
                logico = false;
            }
            
            //Fim do jogo:
            if(logico == false){
                printarMatriz(matriz);
                System.out.println("Parabens, voce conseguiu!");
            }
            
        }while(logico);
    }
}
