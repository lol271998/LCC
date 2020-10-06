import java.util.Scanner;

public class ED202 {

	public static double sumf = 50000;

    // Escrever todos as permutacoes do array v[]
	static void permutations(String v[]) {
		boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
		int perm[] = new int[v.length];         // permutacao actual
		goPerm(0, v, used, perm); // chamar funcao recursiva
	}
    // Gera todos os subconjuntos a partir da posicao 'cur'
	static void goPerm(int cur, String v[], boolean used[], int perm[]) {
		double sum = 0;
		if (cur == v.length) {  // Caso base: terminamos a permutacao;
			for (int i=0; i<v.length; i++){
				System.out.print(v[perm[i]] + " ");				
			}
			System.out.println("");
		}
		else { // Se nao terminamos, continuar a gerar
	    	for (int i=0; i<v.length; i++) // Tentar todos os elementos
	    	if (!used[i]) { 
	    		used[i] = true; perm[cur] = i;
	    		goPerm(cur+1, v, used, perm);
	    		used[i] = false;
	    	}
	    }
	}   

   // -----------------------------------------------------------

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.nextLine();
		String[] locais = new String[n];
		double v[][] = new double[n][n];
		for(int i = 0; i<n; i++) locais[i] = in.next();
		in.nextLine();
		int count = 0;

		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				v[i][j] = in.nextDouble();
			}
		}		
		permutations(locais);
	}
}
