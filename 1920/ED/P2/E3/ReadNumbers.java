import java.util.Scanner;

public class ReadNumbers {
    // Escrever os numeros guardados num array no stdout
    static void writeArray(int v[]) {
	for (int i=0; i<v.length; i++)          
	    System.out.println("v[" + i + "] = " + v[i]);      
    }

    //Calcular amplitude
    static int amp(int v[]){
	int maior,menor;
	menor = v[0];
	maior = v[0];
	for(int i = 1; i<v.length;i++){
	    if(v[i]>=maior) maior = v[i];
	    if(v[i]<=menor) menor = v[i];
	}
	return maior - menor;
    }
  
    public static void main(String[] args) {

	Scanner stdin = new Scanner(System.in);
	int v[] = new int[10];     // Cria um novo array com espaço para 10 inteiros           
	int n = stdin.nextInt();   // Ler a quantidade de numeros que se seguem
   
	for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
	    v[i] = stdin.nextInt();
	writeArray(v);             // Chamar procedimento que escreve
	System.out.println("Amplitude do Array: "+amp(v));
    }
}
