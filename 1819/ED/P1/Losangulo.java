import java.util.Scanner;

public class Losangulo{
	public static void main(String [] args){
		Scanner stdin = new Scanner(System.in);
		int num = stdin.nextInt();
		int metade = num/2;	
		line(num,metade);
	}
	public static void line(int n, int metade){
		//Até metade
		for (int i = 0; i < metade; i++){
			// Desenhar os pontos antes de cada fila até metade
			for (int j = 0; j < metade-i; j++) System.out.print(".");
			
			// Desenhar os cardinais antes de cada fila
			for (int j = 0; j < 2*i+1; j++) System.out.print("#");
			
			//Desenhar o resto dos pontos
			for (int j = metade+1; j<n-i; j++) System.out.print(".");
			
			System.out.print("\n");

		}
		//Sentido descendente
		for (int i = metade; i >= 0; i--){
			for (int j = 0; j < metade-i; j++) System.out.print(".");
	
			for (int j = 0; j < 2*i+1; j++) System.out.print("#");

			for(int j = metade + 1;j < n-i; j++) System.out.print(".");
			
			System.out.print("\n");
		}	
	}
}