// Pensei em fazer uma representação gráfica (bem limitada) de funções do 1º e do 2º graus. Basta indicar os valores dos coeficientes.
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner t = new Scanner(System.in);
        
        int A, B, C, x, y, size = 30;
        
        System.out.println("Digite os coeficientes da função -> f(x)=Ax²+Bx+C");
	System.out.print("A: ");
	A = t.nextInt();

	System.out.print("B: ");
	B = t.nextInt();

	System.out.print("C: ");
	C = t.nextInt();
    
        for(y = size; y >= -size; y--){
	    for(x = -size; x <= size; x++){
		if(y == 0 && x == size){
		    System.out.print("> X");
		} else if(y == size && x == 0){
		    System.out.print(" ^ ");
		} else if (y == size && x == 1){
		    System.out.print(" Y ");
		} else if(y == (A*(x*x)) + (B*x) + C){
		    System.out.print(" o ");
		} else if(x == 0){
		    System.out.print(" • ");
		} else if(y == 0){
		    System.out.print(" • ");
		} else {
		    System.out.print("   ");
		}
	    }
	    System.out.print("\n");
	}
    }
}
