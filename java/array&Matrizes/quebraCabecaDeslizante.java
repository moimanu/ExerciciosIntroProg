package teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Teste {
    
    public static void preencherMatriz(int[][] matriz, int contador){
        //Preenchendo a matriz (laterais com "0" e o miolo ordenado):
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i == 0 || i == 4 || j == 0 || j == 4){
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = contador;
                    contador++;
                }
            }
        }
    }
        
    public static ArrayList conferirAlteracoesPossiveis(int[][] matriz){
        
        ArrayList<Integer> alteracoesPossiveis = new ArrayList<>(Arrays.asList());
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(matriz[i][j] == 9){
                    if(matriz[i-1][j] != 0){
                        alteracoesPossiveis.add(matriz[i-1][j]);
                    }
                    if(matriz[i+1][j] != 0){
                        alteracoesPossiveis.add(matriz[i+1][j]);
                    }
                    if(matriz[i][j-1] != 0){
                        alteracoesPossiveis.add(matriz[i][j-1]);
                    }
                    if(matriz[i][j+1] != 0){
                        alteracoesPossiveis.add(matriz[i][j+1]);
                    }
                }
            }    
        } 
        return alteracoesPossiveis;
    }
    
    public static void trocarPosicao(int[][] matriz, int numeroParaAlterar){
    
        int iVazio = 0;
        int jVazio = 0;
        int iSort = 0;
        int jSort = 0;
    
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(matriz[i][j] == 9){
                    iVazio = i;
                    jVazio = j;
                } else if(matriz[i][j] == numeroParaAlterar){
                    iSort = i;
                    jSort = j;
                }
            }
        }
        
        matriz[iVazio][jVazio] = numeroParaAlterar;
        matriz[iSort][jSort] = 9;
    }
    
    public static int escolherDificuldade(){
        Scanner teclado = new Scanner(System.in);
        
        int entrada = teclado.nextInt();
        
        do{
            switch (entrada) {
                case 1 -> {
                    return 20;
                }
                case 2 -> {
                    return 30;
                }
                case 3 -> {
                    return 40;
                }
                default -> {
                }
            }
        } while(entrada < 1 || entrada > 3);
        return 0;
    }

    public static void baguncarMatriz(int[][] matriz){
        
        Random random = new Random();
        
        int contador = 0;
        int dificuldade = escolherDificuldade();
        
        do{
            ArrayList<Integer> alteracoesPossiveis = conferirAlteracoesPossiveis(matriz);
            int indiceParaAlterar = random.nextInt(alteracoesPossiveis.size());
            int numeroParaAlterar = alteracoesPossiveis.get(indiceParaAlterar);
            
            trocarPosicao(matriz, numeroParaAlterar);
            contador++;
            
        }while(contador < dificuldade);
    }
    
    public static void imprimirMatriz(int[][] matriz){
        for(int i = 0; i < 5; i++){
            //Exceto as bordas do topo e de baixo:
            if(i > 0 && i < 4){
                for(int j = 0; j < 5; j++){
                    //Exceto as bordas da esquerda e da direita:
                    if(j > 0 && j < 4){
                        if(matriz[i][j] == 9){
                            System.out.print("  ");
                        } else {
                            System.out.print(matriz[i][j] + " ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
    

    
    public static void main(String[] args) {
        
        //Configurando o projeto:
        int matrizJogo[][] = new int[5][5];
        int contadorItemMatriz = 1;
        
        
        //MODULO 1 - INICIANDO O JOGO
        preencherMatriz(matrizJogo, contadorItemMatriz);
        imprimirMatriz(matrizJogo);
        baguncarMatriz(matrizJogo);
        imprimirMatriz(matrizJogo);

        
        
        //Modulo 2 - Gameplay
        
        //Modulo 3 - Finalizando o jogo
        
    }
}
