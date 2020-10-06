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
      return count;
   }

	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
        int temp = 0;
        int num = 0;
		int n = in.nextInt();
		//System.out.println(n);
		for(int i = 0; i<n; i++){
      	// Leitura de uma matriz de caracteres
     		rows = in.nextInt();
     		//System.out.println(rows);
      		cols = in.nextInt();
      		//System.out.println(cols);
      		m = new char[rows][cols];
      		visited = new boolean[rows][cols];
      		for (int j=0; j<rows; j++)
        		m[j] = in.next().toCharArray();
        	for(int r = 0; r<rows; r++){
        		for(int c = 0; c<cols; c++){
        			temp = t(r,c);
        			//System.out.println("t(r,c): " + temp);
        			if(temp>=num) num = temp;
        			//System.out.println("Temp: " + num);
        		}
        	}
        System.out.println(num);
        temp = 0;
        num = 0;       	
        }
	}
}