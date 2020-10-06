import java.util.Scanner;

public class ACE{
    static void ger(char line[],int n, int rule){
	
    }

    public static void main(String[] args){

	Scanner stdin = new Scanner(System.in);

	int regra = stdin.nextInt(); 
	int n = stdin.nextInt();  //Tamanho da linha
	int g = stdin.nextInt(); // Numero da geração 

	char line[] = new char[n];
	for(int i = 0; i<n; i++){
	    if(i==n/2) line[i] = '#';
	    else line[i] = '.';
			 
	}
	for(int i = 0; i<g; i++){
	    ger(line, 
	}
	System.out.println("");
    }
}
