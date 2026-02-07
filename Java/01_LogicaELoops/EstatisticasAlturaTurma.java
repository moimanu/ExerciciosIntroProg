//Exercício - Loop em Java: Imprimir a maior e a menor altura da turma, a média de altura das mulheres (2) e a média de altura da turma.

import java.util.Scanner;

public class EstatisticasAlturaTurma {
    public static void main (String[] args){
        
        Scanner t = new Scanner(System.in);
        int testes = 1; 
        int ficha; 
        int qntdMulheres = 0;
        double altura = 0.00; 
        double maiorAltura = -1.00; 
        double menorAltura = 99.99; //Para esse exercício pode, pois não há essa altura...
        double somaMulheres = 0.00; 
        double somaGeral = 0.00;
        
        do{
            altura = t.nextFloat();
            ficha = t.nextInt();
            
            if(altura > maiorAltura){
                maiorAltura = altura;
            } else if(altura < menorAltura){
                menorAltura = altura;
            }
            
            if(ficha == 2){
                qntdMulheres++;
                somaMulheres += altura;
            }
            
            somaGeral += altura;
            testes++;
            
        } while(testes <= 50);
        
        double mediaMulheres = somaMulheres/qntdMulheres;
        double mediaGeral = somaGeral/50;
        
        System.out.printf("%.2f\n",maiorAltura);
        System.out.printf("%.2f\n",menorAltura);
        System.out.printf("%.2f\n",mediaGeral);
        System.out.printf("%.2f\n",mediaMulheres);
    }
}

/* EXEMPLO DE ENTRADA (50 FICHAS/ 1=HOMEM/ 2=MULHER/ ALTURA):

1.49
1
1.65
1
1.33
2
1.36
2
1.21
2
1.47
1
1.27
1
1.32
1
1.43
2
1.95
2
1.59
2
1.77
1
1.68
2
1.94
2
1.91
2
1.81
1
1.23
2
1.24
2
1.71
2
1.94
2
1.85
2
1.32
2
1.92
1
1.59
1
1.43
1
1.15
1
1.74
2
1.94
2
1.86
1
1.93
2
1.59
1
1.64
2
1.21
1
1.58
1
1.49
1
1.39
1
1.37
2
1.33
1
1.95
2
1.22
1
1.20
1
1.72
1
1.72
1
1.29
2
1.66
1
1.66
2
1.69
1
1.46
2
1.59
1
1.83
1

*/