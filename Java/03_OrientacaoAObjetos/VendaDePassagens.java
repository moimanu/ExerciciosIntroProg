package vendadepassagens;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class VendaDePassagens {
    
    //VARIAVEIS
    
        private static Scanner t = new Scanner(System.in);

        //Declarando matriz 3x3 para armazenar os lugares
        private static Passageiro lugares[][][] = new Passageiro[30][11][4];

        //Declarando o dia de referencia
        public static LocalDate dataReferencia = LocalDate.of(2024, 11, 01);

        //Armazenando passageiros recorrentes
        private static ArrayList<Passageiro> historicoPassageiros = new ArrayList<Passageiro>();

    //VENDA DE PASSAGENS
    
        private static void imprimirLugares(Passageiro lugares[][][], int dia){

            System.out.println(" A    C  B"); //Imprimindo coordenadas das colunas

            for(int i = 0; i < 11; i++){

                for(int j = 0; j < 4; j++){

                    //Definindo estado da vaga
                    String estadoDaVaga;
                    if(lugares[dia][i][j] == null){
                        estadoDaVaga = ("[ ]");
                    } else {
                        estadoDaVaga = ("[X]");
                    }

                    //Imprimindo vagas
                    if(j == 1){ //Imprimindo corredor
                        System.out.print("  ");
                    } else {
                        if(j == 3){ //Imprimindo coordenada linha
                            System.out.print(estadoDaVaga + " " +(i + 1));
                        } else { //Imprimindo outras colunas
                            System.out.print(estadoDaVaga);
                        }
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

        private static LocalDate pedirData(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.print("Digite uma data no formato yyyy-MM-dd: ");
            String dataString = t.nextLine();
            LocalDate data = LocalDate.parse(dataString, formatter);

            return data;
        }

        private static Passageiro pedirInfoCliente(){
            System.out.print("Digite o seu nome: ");
            String nome = t.nextLine();
            System.out.print("Digite o seu email: ");
            String email = t.nextLine();
            System.out.print("Digite o seu endereco: ");
            String endereco = t.nextLine();
            System.out.print("Digite a sua data de nascimento. ");
            LocalDate dataNascimento = pedirData();
            System.out.print("Informe se ha comorbidades (true, false): ");
            boolean comorbidades = t.nextBoolean();

            return new Passageiro(nome, email, endereco, dataNascimento, comorbidades);
        }

        private static int mostrarVagasDoDia(){
            System.out.print("Escolha um dia entre hoje e o ultimo dia do mes (informe apenas um inteiro): ");
            int diaEscolhido;

            do{
                diaEscolhido = t.nextInt();
                System.out.println();

                if(dataReferencia.getDayOfMonth() <= diaEscolhido){
                    imprimirLugares(lugares, diaEscolhido);
                } else {
                    System.out.println("Dia invalido.");
                }
            } while(dataReferencia.getDayOfMonth() > diaEscolhido);

            return diaEscolhido;
        }

        private static int converterLetraParaNumero(String letra){

            switch (letra) {
                case "A" -> {
                    return 0;
                }
                case "B" -> {
                    return 3;
                }
                case "C" -> {
                    return 2;
                }
                default -> {
                }
            }

            return 1;
        }

        private static double conferirValorPassagem(int coluna, Passageiro cliente){

            double valor = 0.0;

            //Conferindo valor de acordo com a janela
            switch (coluna) {
                case 0 -> {
                    valor += 850.0;
                }
                case 2 -> {
                    valor += 550.0;
                }
                case 3 -> {
                    valor += 720.0;
                }
                default -> {
                }
            }

            //Conferindo desconto progressivo por fidelidade
            double descontoFidelidade;
            if(conferirSeJaComprouAntes(cliente) > 10){
                descontoFidelidade = 50;
            } else {
                descontoFidelidade = (100 - (conferirSeJaComprouAntes(cliente)) * 5)/100;
            }
            valor = valor * descontoFidelidade;

            //Ajustando valor pela idade
            if(cliente.retornaIdade().getYears() < -60){
                valor = valor * (95.0/100.0);
            }

            //Ajustando valor por comorbidade
            if(cliente.isComorbidades()){
                valor = valor * (85.0/100.0);
            }

            //Ajustando valor por aniversario
            if(cliente.getDataNascimento().getDayOfMonth() == dataReferencia.getDayOfMonth() && 
                   cliente.getDataNascimento().getMonth() == dataReferencia.getMonth()){
                valor = valor * (95.0/100.0);
            }        

            return valor;
        }

        private static int conferirSeJaComprouAntes(Passageiro cliente){

            for(int i = 0; i < historicoPassageiros.size(); i++){
                if(historicoPassageiros.get(i).equals(cliente)){
                    return cliente.getQntdViajada();
                }
            }

            return 0;
        }

        private static void venderPassagem(){

            //Primeiro: pedir info. cliente
            Passageiro cliente = pedirInfoCliente();

            //Segundo: mostrar vagas do dia, de acordo com o dia escolhido
            int diaEscolhido = mostrarVagasDoDia();

            //Terceiro: pedir coordenada do lugar desejado
            int coluna;
            int linha;
            do {
                System.out.println("Informe a coordenada da vaga desejada.");
                System.out.print("Linha: ");
                linha = t.nextInt() - 1;
                t.nextLine();
                System.out.print("Coluna: ");
                coluna = converterLetraParaNumero(t.nextLine());

                if(lugares[diaEscolhido][linha][coluna] != null){
                    System.out.println("Essa vaga já foi preenchida...");
                } else {
                    break;
                }
            } while(true);

            //Quarto: informar o valor da passagem
            System.out.println();
            System.out.println("Valor da passagem: " + conferirValorPassagem(coluna, cliente));

            //Depois de efetuar a compra, deve-se armazenar o cliente no historico e atualizar a fidelidade
            System.out.println("Deseja efetuar a compra (S/N)?");
            String comprou = t.nextLine();

            if(comprou.equals("S")){
                for(int i = 0; i < 11; i++){
                    for(int j = 0; j < 4; j++){
                        if(lugares[diaEscolhido][linha][coluna] == lugares[diaEscolhido][i][j]){
                            System.out.println("Voce já comprou uma passagem hoje...");
                            break;
                        } else {
                            lugares[diaEscolhido][linha][coluna] = cliente;
                        }
                    }
                }
                
            } else if(comprou.equals("N")){
                System.out.println("Compra cancelada...");
            }

            imprimirLugares(lugares, diaEscolhido);
        }
    
    //EMBARQUE e DESEMBARQUE
    
        private static ArrayList criarListaDePassageiros(){

            ArrayList<Passageiro> passageirosDoDia = new ArrayList<>();

            for(int i = 0; i < 11; i++){
                for(int j = 0; j < 4; j++){
                    if(lugares[dataReferencia.getDayOfMonth()][i][j] != null){
                        passageirosDoDia.add(lugares[dataReferencia.getDayOfMonth()][i][j]);
                    }
                }
            }

            return passageirosDoDia;
        }

        private static void embarque(){

            ArrayList<Passageiro> passageirosParaEmbarque = criarListaDePassageiros();

            //Ordena por aniversario
            for (Passageiro pessoa : passageirosParaEmbarque) {
                if(pessoa.getDataNascimento().getDayOfMonth() == dataReferencia.getDayOfMonth() && 
                   pessoa.getDataNascimento().getMonth() == dataReferencia.getMonth()){
                    passageirosParaEmbarque.remove(pessoa);
                    passageirosParaEmbarque.add(0, pessoa);
                }
            }

            //Ordena por ser idoso/a
            for (Passageiro pessoa : passageirosParaEmbarque) {
                if(pessoa.retornaIdade().getYears() < -60){
                    passageirosParaEmbarque.remove(pessoa);
                    passageirosParaEmbarque.add(0, pessoa);
                }
            }

            //Ordena por comorbidade
            for (Passageiro pessoa : passageirosParaEmbarque) {
                if(pessoa.isComorbidades()){
                    passageirosParaEmbarque.remove(pessoa);
                    passageirosParaEmbarque.add(0, pessoa);
                }
            }

            //Imprime a lista
            System.out.println("Embarque:");
            for (Passageiro pessoa : passageirosParaEmbarque) {
                System.out.println(pessoa.getNome());
            }

        }
    
    public static void main(String[] args) {
        imprimirLugares(lugares, 3);

        System.out.println("Data atual: " + dataReferencia);
        
        venderPassagem();
        venderPassagem();
        venderPassagem();

        embarque();
    }
}
