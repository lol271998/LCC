import java.util.Scanner;

public class ReadNumbers {

   // Escrever os numeros guardados num array no stdout
   static void writeArray(int v[]) {
       int maior,menor;
      for (int i=0; i<v.length; i++)          
         System.out.println("v[" + i + "] = " + v[i]);
      maior = v[0];
      menor = v[0];
      for(int c=1; c<v.length; c++){
	  if(v[c] >= maior){
	      maior = v[c];
	  }
	  if(v[c] <= menor){
	      menor = v[c];
	  }
      }
      System.out.println("O menor valor é: " + menor);
      System.out.println("O maior valor é: " + maior);
   }
   
   public static void main(String[] args) {

      Scanner stdin = new Scanner(System.in);

      int v[] = new int[10];     // Cria um novo array com espaço para 10 inteiros           
      int n = stdin.nextInt();   // Ler a quantidade de numeros que se seguem
      
      for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
         v[i] = stdin.nextInt();
      
      writeArray(v);             // Chamar procedimento que escreve
   }
}
