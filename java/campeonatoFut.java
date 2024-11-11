package campeonatofut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CampeonatoFut {
    
    static int indicesTimesCadastrados = 0;
    static boolean comecouCampeonato = false;
    static Scanner t = new Scanner(System.in);
    static ArrayList<TimesFut> tabelaTimes = new ArrayList<>(Arrays.asList());

    private static void mostrarPrimeiro(){
        System.out.println("Primeiro colocado: " + tabelaTimes.get(0).getNome());
    }
    
    private static void mostrarClassificados(){
        for (int i = 0; i < 4; i++) {
            System.out.println("Convocados para a Libertadores: " + tabelaTimes.get(i).getNome());
        }
    }
    
    private static void mostrarZona(){
        for (int i = tabelaTimes.size() - 4; i < tabelaTimes.size(); i++) {
            System.out.println("Zona de rebaixamento: " +tabelaTimes.get(i).getNome());
        }
    }
    
    private static void mostrarTabela(){
        
        System.out.println("TABELA DO CAMPEONATO");

        for (int i = 0; i < tabelaTimes.size(); i++) {
            System.out.println((i+1) + " | " + tabelaTimes.get(i).getNome() + " | P:" + tabelaTimes.get(i).getPontos()
                + " | SG:" + tabelaTimes.get(i).getSaldoDeGols() + " | GP:" + tabelaTimes.get(i).getGolsPro() + " | CV:" + tabelaTimes.get(i).getCartoesVermelhos()
                + " | CA:" + tabelaTimes.get(i).getCartoesAmarelos());
        }
            
    }
    
    private static void ajustarPosicao(TimesFut timeFut){ //Só consegui resolver para os pontos...
        
        for(int i = 0; i < tabelaTimes.size(); i++){
            if(tabelaTimes.get(i).getPontos() < timeFut.getPontos()){ //PONTOS
                
                System.out.println("AAAAAAAAAAAA" + tabelaTimes.get(i).getPontos() + " " + timeFut.getPontos());
                
                tabelaTimes.remove(tabelaTimes.indexOf(timeFut));
                
                mostrarTabela();
                
                System.out.println(i);
                
                tabelaTimes.add(i, timeFut);
                
                mostrarTabela();

                break;
            }
        }
    }
    
    private static void adicionarPontosECartoes (String nomeTime, int qntdGols, int pontos, int qntdVerm, int qntdAmar, int diferencaGols){
        for(int i = 0; i < 20; i++){
            if(tabelaTimes.get(i).getNome().equals(nomeTime)){
                tabelaTimes.get(i).setPontos(tabelaTimes.get(i).getPontos() + pontos);
                tabelaTimes.get(i).setGolsFeitos(tabelaTimes.get(i).getGolsFeitos() + qntdGols);
                tabelaTimes.get(i).setJogosRealizados(tabelaTimes.get(i).getJogosRealizados() + 1);
                tabelaTimes.get(i).setGolsPro(tabelaTimes.get(i).getGolsPro() + (tabelaTimes.get(i).getGolsFeitos() / tabelaTimes.get(i).getJogosRealizados()));
                tabelaTimes.get(i).setSaldoDeGols(tabelaTimes.get(i).getSaldoDeGols() + diferencaGols);
                tabelaTimes.get(i).setCartoesVermelhos(tabelaTimes.get(i).getCartoesVermelhos() + qntdVerm);
                tabelaTimes.get(i).setCartoesAmarelos(tabelaTimes.get(i).getCartoesAmarelos() + qntdAmar);
                ajustarPosicao(tabelaTimes.get(i));
                break;
            }
        }
    }
    
    private static void cadastrarPartida(){
        
        int diferencaGols = 0;
        
        //Time 1
        System.out.println("Informe, para o primeiro time, o nome, quantidade de gols, cartões vermelhos e amarelos:");
        t.nextLine();
        String nomeTime1 = t.nextLine();
        int golsTime1 = t.nextInt();
        int cVermT1 = t.nextInt();
        int cAmarT1 = t.nextInt();
        
        //Time 2
        System.out.println("Informe, para o segundo time, o nome, quantidade de gols, cartões vermelhos e amarelos:");
        t.nextLine();
        String nomeTime2 = t.nextLine();
        int golsTime2 = t.nextInt();
        int cVermT2 = t.nextInt();
        int cAmarT2 = t.nextInt();
        
        //Adicionando pontos e cartões conforme o resultado:
        if(golsTime1 > golsTime2){
            diferencaGols = golsTime1 - golsTime2;
            adicionarPontosECartoes(nomeTime1, golsTime1, 3, cVermT1, cAmarT1, diferencaGols);
            adicionarPontosECartoes(nomeTime2, golsTime2, 0, cVermT2, cAmarT2, -diferencaGols);

        } else {
            if(golsTime1 < golsTime2){
                diferencaGols = golsTime2 - golsTime1;
                adicionarPontosECartoes(nomeTime2, golsTime2, 3, cVermT2, cAmarT2, diferencaGols);
                adicionarPontosECartoes(nomeTime1, golsTime1, 0, cVermT1, cAmarT1, -diferencaGols);
                            
            } else {
                adicionarPontosECartoes(nomeTime1, golsTime1, 1, cVermT1, cAmarT1, 0);
                adicionarPontosECartoes(nomeTime2, golsTime2, 1, cVermT2, cAmarT2, 0);
            }
        }
        
        comecouCampeonato = true;
        
    }
    
    private static void cadastrarTime(){
        
        System.out.println("Cadastre um time pelo nome:");
        t.nextLine(); //Utilizado para consumir quebra de linha ignorada anteriormente.
        String nome = t.nextLine();
        tabelaTimes.add(new TimesFut(nome));
        indicesTimesCadastrados += 1;
        System.out.println();
        
    }
    
    private static void menu(){
        
        while(true){
            
            int entrada = 0;
            
            //Primeiro caso: se tiver menos de dois times, será preciso cadastrar
            
            if(indicesTimesCadastrados < 2){
                
                while(entrada < 1 || entrada > 2){
                    
                    System.out.println("Escolha uma opcao:");
                    System.out.println("1 - Cadastrar time");
                    System.out.println("2 - Sair");
                    entrada = t.nextInt();
                    System.out.println();
                    
                }
                
                if(entrada == 1){
                    cadastrarTime();
                } else if(entrada == 2){
                    System.exit(0);
                }
                
            //Segundo caso: se nao lotou e nao comecou o campeonato
            
            } else if(indicesTimesCadastrados < 20 && !comecouCampeonato){
                
                while(entrada < 1 || entrada > 3){
                    
                    System.out.println("Escolha uma opcao:");
                    System.out.println("1 - Cadastrar time");
                    System.out.println("2 - Cadastrar partida");
                    System.out.println("3 - Sair");
                    entrada = t.nextInt();
                    System.out.println();
                }
                
                if(entrada == 1){
                    cadastrarTime();
                } else if(entrada == 2){
                    cadastrarPartida();
                } else if(entrada == 3){
                    System.exit(0);
                }
                
            //Terceiro caso: se lotou o campeonato
                
            } else if(indicesTimesCadastrados > 20){
                
                while(entrada < 1 || entrada > 3){
                    
                    System.out.println("Escolha uma opcao:");
                    System.out.println("1 - Cadastrar partida");
                    System.out.println("2 - Mostrar tabela");
                    System.out.println("3 - Sair");
                    entrada = t.nextInt();
                    System.out.println();
                    
                }
                
                if(entrada == 1){
                    cadastrarPartida();
                } else if(entrada == 2){
                    mostrarTabela();
                } else if(entrada == 3){
                    System.exit(0);
                }
                
            //Quarto caso: se comecou o campeonato

            } else if(comecouCampeonato){
                
                while(entrada < 1 || entrada > 6){
                    
                    System.out.println();
                    System.out.println("Escolha uma opcao:");
                    System.out.println("1 - Cadastrar partida");
                    System.out.println("2 - Ver primeiro colocado");
                    System.out.println("3 - Ver classificados para a Libertadores");
                    System.out.println("4 - Ver zona de rebaixamento");
                    System.out.println("5 - Mostrar tabela");
                    System.out.println("6 - Sair");
                    entrada = t.nextInt();
                    System.out.println();
                    
                }
                
                if(entrada == 1){
                    cadastrarPartida();
                } else if(entrada == 2){
                    mostrarPrimeiro();
                } else if(entrada == 3){
                    mostrarClassificados();
                } else if(entrada == 4){
                    mostrarZona();
                } else if(entrada == 5){
                    mostrarTabela();
                } else if(entrada == 6){
                    System.exit(0);
                }
                
            }
        }        
    }
    
    public static void main(String[] args) {
        
        menu();
    }
}
