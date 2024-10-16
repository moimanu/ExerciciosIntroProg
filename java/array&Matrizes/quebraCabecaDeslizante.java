package rachaCuca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RachaCuca {
    
    public static void preencherMatriz(int[][] matriz){
        int contadorItemMatriz = 1;

        //Preenchendo a matriz (laterais com "0" e o miolo ordenado):
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(i == 0 || i == 4 || j == 0 || j == 4){
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = contadorItemMatriz;
                    contadorItemMatriz++;
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
    
    public static boolean trocarPosicao(int[][] matriz, int numeroParaAlterar){
    
        ArrayList<Integer> alteracoesPossiveis = conferirAlteracoesPossiveis(matriz);
        
        for(int n = 0; n < alteracoesPossiveis.size(); n++){
            if(numeroParaAlterar == alteracoesPossiveis.get(n)){
            
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
                
                return true;
            }
        }
        return false;
    }
    
    public static int escolherDificuldade(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o nivel de dificuldade para embaralhar, facil(1), medio(2) ou dificil(3): ");
        
        int entradaOpcao = teclado.nextInt();
        int qntdAlteracoes = 0;
        
        do{
            
            if(entradaOpcao >= 1 && entradaOpcao <= 3){
                switch (entradaOpcao) {
                    case 1 -> qntdAlteracoes = 20;
                    case 2 -> qntdAlteracoes = 40;
                    case 3 -> qntdAlteracoes = 80;
                    default -> {
                    }
                }
            } else {
                System.out.print("Opcao invalida. Escolha facil(1), medio(2) ou dificil(3): ");
                entradaOpcao = teclado.nextInt();
            }
            
        } while(entradaOpcao < 1 || entradaOpcao > 3);
        
        return qntdAlteracoes;
    }

    public static int escolherNumAleatorioPossivel(int[][] matriz){
        Random random = new Random();

        ArrayList<Integer> alteracoesPossiveis = conferirAlteracoesPossiveis(matriz);
        int indiceParaAlterar = random.nextInt(alteracoesPossiveis.size());
        return alteracoesPossiveis.get(indiceParaAlterar);
    }
    
    public static void baguncarMatriz(int[][] matriz){
        
        int contador = 0;
        int dificuldade = escolherDificuldade();
        
        do{
            trocarPosicao(matriz, escolherNumAleatorioPossivel(matriz));
            contador++;
        }while(contador < dificuldade);
        
        System.out.println();
        System.out.println("Tabuleiro embaralhado. Vamos comecar o jogo!");
    }
    
    public static void imprimirMatriz(int[][] matriz, boolean primeiraVezImprimindo){
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
        if(primeiraVezImprimindo){
            System.out.println("Tabuleiro ordenado!");
        }
    }

    public static boolean conferirOrdem(int[][] matriz){
        
        return matriz[1][1] == 1 && matriz[1][2] == 2 && matriz[1][3] == 3 &&
                matriz[2][1] == 4 && matriz[2][2] == 5 && matriz[2][3] == 6 &&
                matriz[3][1] == 7 && matriz[3][2] == 8;

    }
            
    public static void main(String[] args) {
        
        //Configurando o projeto:
        int matrizJogo[][] = new int[5][5];        
        Scanner teclado = new Scanner(System.in);
        
        //MODULO 1 - INICIANDO O JOGO
        preencherMatriz(matrizJogo);
        imprimirMatriz(matrizJogo, true);
        baguncarMatriz(matrizJogo);
        
        //MODULO 2 - GAMEPLAY
        
        
        boolean logico = true;
        
        while(!conferirOrdem(matrizJogo)){
            if(logico){
                imprimirMatriz(matrizJogo, false);
                System.out.print("Digite um comando ou numero da peca que quer mover: ");
                int entradaTentativa = teclado.nextInt();
                System.out.println();
                logico = trocarPosicao(matrizJogo, entradaTentativa);
            } else {
                System.out.println("Invalido...");
                System.out.print("Digite um comando ou numero da peca que quer mover: ");
                int entradaTentativa = teclado.nextInt();
                System.out.println();
                logico = trocarPosicao(matrizJogo, entradaTentativa);
            }
        }
        
        //MODULO 3 - FINALIZANDO O JOGO
        imprimirMatriz(matrizJogo, false);
        System.out.println("Parabens, voce venceu!");
    }
}
