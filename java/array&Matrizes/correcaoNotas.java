//Exercício: Ler um gabarito e as respostas de 3 alunos. Após isso, determinar a quantidade de acertos de cada um e definir quantos alcançaram nota acima da media. 

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        String gabarito = teclado.nextLine();
        String respostas[] = new String[3];
        int aluno[] = new int[3];
        int acimaMedia = 0;
        
        for(int i = 0; i < 3; i++){
            respostas[i] = teclado.nextLine();
        }        

        for(int i = 0; i < 3; i++){
            int contador = 0;
            for(int j = 0; j < 10; j++){
                if(gabarito.charAt(j) == respostas[i].charAt(j)){
                    contador++;
                }   
            }
            aluno[i] = contador;
        }
        
        System.out.println("Nota do Aluno1: " + aluno[0]);
        System.out.println("Nota do Aluno2: " + aluno[1]);
        System.out.println("Nota do Aluno3: " + aluno[2]);
        
        for(int i = 0; i < 3; i++){
            if(aluno[i] >= 6){
                acimaMedia++;
            }
        }
        
        System.out.println("Notas acima da media: " + acimaMedia);
    }
}

/* EXEMPLO DE ENTRADA:

eebcecaebb
aebaababbb
dbcecadeeb
dadaebbaab

*/
