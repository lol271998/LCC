import java.util.Scanner;

public class Estatisticas {

   // Escrever os numeros guardados num array no stdout
   static double media(int v[]) {
       double sum=0;
       double med;   
      for (int i=0; i<v.length; i++)          
	  sum = sum + v[i];
      med = sum/v.length;
      return med;
    }
    static int amp(int v[]){
	int maior,menor,ampl;
	maior = v[0];
	menor = v[0];
	for(int i=1; i<v.length; i++){
	  if(v[i] >= maior)
	      maior = v[i];
	  if(v[i] <= menor)
	      menor = v[i];
	}

	  ampl = maior - menor;
	  return ampl;
    }
   
   public static void main(String[] args) {

      Scanner stdin = new Scanner(System.in);

      int n = stdin.nextInt();   // Ler a quantidade de numeros que se seguem
      int v[] = new int[n];     // Cria um novo array com espaço para n inteiros           
      
      
      for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
         v[i] = stdin.nextInt();
      
      System.out.printf("%.2f\n",media(v));
      System.out.println(amp(v));
   }
}
