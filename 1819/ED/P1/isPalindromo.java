import java.util.Scanner;

public class isPalindromo{
	
	public static void check(String [] linhas, int n){
		for(int i = 0; i < n; i++){
			String palavra = linhas[i];
			int a = 1;
			int cont = 0;
			int size = palavra.length();
		
			String str_up = palavra.toUpperCase();
		
			for(int j = 0; j < size; j++){ //Contar os espaços
				if(Character.isLetter(str_up.charAt(j))){
					continue;
				}
				else
					cont++;
			}

			String strfinal = str_up.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "");//Remover os espaços
			String strfinal1 = new StringBuilder(strfinal).reverse().toString();
			//System.out.println(strfinal);
		
			for(int k = 0; k < size-cont; k++){ //Compensar os espaços
				char c = strfinal.charAt(k);
				while(Character.isDigit(c)) a = 0;
			}
			if(a == 1){
				if(new String(strfinal).equals(strfinal1)){
					System.out.println("sim");
				}
				else System.out.println("nao");
			}
			else System.out.println(strfinal);
		}
	}
	public static void main (String[] args){
				
		Scanner stdin = new Scanner(System.in);

      	int n = stdin.nextInt();    // Ler a quantidade de numeros que se seguem
      	stdin.nextLine();			// Seguir para a linha seguinte (cursor está no final do numero)
      	System.out.println(n);
    	String [] linhas = new String[n];     // Cria um novo array com espaço para n strings
    	for (int i = 0; i < n; i++){   // Ler os numeros a partir do stdin
        	linhas[i] = stdin.nextLine();
      	}
      	check(linhas,n);
	}
}