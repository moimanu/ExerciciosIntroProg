package rachacucadefinitivo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RachaCucaDefinitivo {
    
    //GAMEPLAY
        
        //Funcoes basicas
    
            public static int[][] criarTabuleiroOrdenado(){
                
                int tabuleiro[][] = {
                    {0,0,0,0,0},
                    {0,1,2,3,0},
                    {0,4,5,6,0},
                    {0,7,8,9,0},
                    {0,0,0,0,0},
                };

                return tabuleiro;
            }

            public static void imprimirTabuleiro(int matriz[][]){
                
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

            public static int escolherNumAleatorioPossivel(int[][] matriz){
                
                Random random = new Random();

                ArrayList<Integer> alteracoesPossiveis = conferirAlteracoesPossiveis(matriz);
                int indiceParaAlterar = random.nextInt(alteracoesPossiveis.size());
                return alteracoesPossiveis.get(indiceParaAlterar);
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

            public static boolean conferirOrdem(int[][] matriz){

                return matriz[1][1] == 1 && matriz[1][2] == 2 && matriz[1][3] == 3 &&
                       matriz[2][1] == 4 && matriz[2][2] == 5 && matriz[2][3] == 6 &&
                       matriz[3][1] == 7 && matriz[3][2] == 8;
            }

        //Funcoes especificas
            
            public static void embaralharTabuleiro(int[][] matriz){

                int contador = 0;
                int dificuldade = escolherDificuldade();

                do{
                    trocarPosicao(matriz, escolherNumAleatorioPossivel(matriz));
                    contador++;
                }while(contador < dificuldade);

                System.out.println();
            }

            public static void interagir(int matriz[][]){
                
                Scanner t = new Scanner(System.in);

                int qntdJogadas = 0;

                while(!conferirOrdem(matriz)){
                    imprimirTabuleiro(matriz);

                    if (qntdJogadas > 0){
                        System.out.println("Quantidade de jogadas ate agora: " + qntdJogadas);                    
                    }

                    System.out.print("Digite um comando ou numero da peca que quer mover: ");
                    int entrada = t.nextInt();

                    if(entrada == 0){
                        System.out.println();
                        finalizarJogo();
                    }

                    while(!trocarPosicao(matriz, entrada)){
                        System.out.print("Digite outro numero: ");
                        entrada = t.nextInt();
                    }
                    System.out.println();
                    qntdJogadas++;
                }
                
                imprimirTabuleiro(matriz);
                System.out.println("Parabens! Voce venceu!");
                System.out.println();
            }

        //Funcao principal
        
            public static void gameplay(){

                //MODULO 1 - CRIANDO TABULEIRO
                int tabuleiro[][] = criarTabuleiroOrdenado();
                imprimirTabuleiro(tabuleiro);
                System.out.println("Tabuleiro ordenado!");

                //MODULO 2 - EMBARALHANDO TABULEIRO
                embaralharTabuleiro(tabuleiro); //Altera por referencia
                System.out.println("Tabuleiro embaralhado! Vamos comecar o jogo!");
                System.out.println();

                //MODULO 3 - JOGANDO
                interagir(tabuleiro);
            }

    //MENU
        
        //Funcoes basicas
            
            public static void imprimirInstrucoes(){
                System.out.println("x - - - - - - - - - - - - - - - - - - - - - - - - - - - - - x");
                System.out.println("|                                                           |");
                System.out.println("|   INSTRUCOES:                                             |");
                System.out.println("|                                                           |");
                System.out.println("|   - Como jogar: O jogo racha cuca possui um tabuleiro     |");
                System.out.println("|   com 8 pecas, as quais serao embaralhadas de acordo      |");
                System.out.println("|   com o nivel de dificuldade escolhido. Voce devera       |");
                System.out.println("|   alterar as posicoes das pecas (trocando com o espaco    |");
                System.out.println("|   vazio) ate que a ordem esteja correta.                  |");
                System.out.println("|                                                           |");
                System.out.println("|   - Objetivo: O jogo tem por objetivo ordenar             |");
                System.out.println("|   todas as pecas, do '1' ao '8', da esquerda              |");
                System.out.println("|   para a direita.                                         |");
                System.out.println("|                                                           |");            
                System.out.println("|   Para sair durante o jogo, basta digitar 0.              |");            
                System.out.println("|                                                           |");
                System.out.println("x - - - - - - - - - - - - - - - - - - - - - - - - - - - - - x");
                System.out.println();
            }

            public static int perguntar(String msg){
                Scanner teclado = new Scanner(System.in);
                System.out.print(msg);
                int entrada = teclado.nextInt();
                System.out.println();
                return entrada;
            }

            public static void finalizarJogo(){
                System.out.println("Jogo finalizado.");
                System.exit(0);
            }
        
        //Funcao principal
            
            public static void menu(){
                
                String msg1 = "Bem vindo ao Racha Cuca!\nO que quer fazer? Sair(0), Jogar(1) ou Instrucoes(2): ";
                String msg2 = "O que quer fazer agora? Sair(0), Jogar(1) ou Instrucoes(2): ";
                String msg3 = "O que quer fazer agora? Sair(0), Jogar(1): ";
                String msg4 = "Opcao invalida. Escolha Sair(0), Jogar(1): ";
                String msg5 = "Opcao invalida. Escolha Sair(0), Jogar(1) ou Instrucoes(2): ";

                int entradaOpcao = perguntar(msg1);

                do{
                    if(entradaOpcao >= 0 && entradaOpcao <= 2){
                        switch (entradaOpcao) {
                            case 0 -> {
                                finalizarJogo();
                            }           
                            case 1 -> {
                                gameplay();
                                entradaOpcao = perguntar(msg2);
                            }
                            case 2 -> {
                                imprimirInstrucoes();
                                entradaOpcao = perguntar(msg3);

                                while(entradaOpcao < 0 || entradaOpcao > 1) {
                                    entradaOpcao = perguntar(msg4);
                                }
                            }
                            default -> {
                            }
                        }
                    } 

                    while(entradaOpcao < 0 || entradaOpcao > 2) {
                        entradaOpcao = perguntar(msg5);
                    }
                } while(entradaOpcao >= 0 && entradaOpcao <= 2);
            }
            
    //PROCESSAMENTO DO JOGO
        
        public static void main(String[] args) {
            menu();
        }
}
