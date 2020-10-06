import java.util.Scanner;

public class ED200{
	
	static int rows;            // Numero de linhas
	static int cols;            // Numero de colunas   
	static char m[][];          // Matriz de celulas
	static boolean visited[][]; // Saber se uma dada posicao ja foi visitada

   	// Tamanho da mancha que inclui posicao (y,x)
	static int t(int y, int x) {
    	if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
    	if (visited[y][x]) return 0;  // Caso base: celula ja visitada
    	if (m[y][x] == '.') return 0; // Caso base: celula vazia
    	int count = 1;        // celula nao vazia
    	visited[y][x] = true; // marcar como visitada
    	count += t(y-1, x);   // Adicionando celulas nao vizinhas
    	count += t(y+1, x);
    	count += t(y, x+1);
    	count += t(y, x-1);
    	count += t(y-1,x-1);
    	count += t(y+1,x+1);
    	count += t(y-1,x+1);
    	count += t(y+1,x-1);
    	return count;
   	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int l = 0; l<n; l++){
			int count = 0,countemp = 0;
    		// Leitura de uma matriz de caracteres
   			rows = in.nextInt();
     		cols = in.nextInt();
    	
    		m = new char[rows][cols];
    		visited = new boolean[rows][cols];
   		
   			for (int i=0; i<rows; i++) m[i] = in.next().toCharArray();
	    	for(int i = 0; i<rows; i++){
	    		for(int j = 0; j<rows; j++){
	    			//System.out.println("matrix: "+l+" coutemp: "+countemp);
	    			countemp = t(i,j);
	    			if(countemp>=count) count = countemp;
	    		}
	    	}
	    	System.out.println(count);
	   	}      
   	}	
}