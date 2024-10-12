package teste;

import java.util.Scanner;

public class Teste {
    
    //Imprime UMA linha cheia
    public static void imprimeLinhaDoInicio(int tam){ //"tam" é um parâmetro...
        for(int simb = 1; simb <= tam; simb++){
            System.out.print("* ");
        }
        System.out.println();
    }
    
    //Imprime UMA linha do MEIO
    public static void imprimeLinhaDoMeio(int tt){ //"tt" é um parâmetro...
        System.out.print("* ");
        for (int esp = 2; esp <= tt - 1; esp++) {
            System.out.print("  ");
        }
        System.out.print("* ");
        System.out.println();
    }
    
    public static void imprimeQuadrado(int t){ //"t" é um parâmetro...
        imprimeLinhaDoInicio(t);   
        for (int linhaMeio = 2; linhaMeio <= t - 1; linhaMeio++) {
            imprimeLinhaDoMeio(t);
        }
        imprimeLinhaDoInicio(t);
    }
    
    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);
        int tam = t.nextInt();
        
        imprimeQuadrado(tam);
    }
}
