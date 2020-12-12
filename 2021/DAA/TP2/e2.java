import java.util.Scanner;

class e2{
	
	static int n;              // Numero de nos do grafo
    static boolean adj[][];    // Matriz de adjacencias
    static boolean visited[];  // Que nos ja foram visitados?
    static String m[]; 		   // Matrix do input

    static void dfs(int v) {
    	//System.out.println(v) //imprimir por ordem
		visited[v] = true;
		for (int i=1; i<=n; i++)
		    if (adj[v][i] && !visited[i])
			dfs(i);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int k = in.nextInt();

		for(int i = 0; i<n; i++){
			int l = in.nextInt();
			int c = in.nextInt();
			in.nextLine();
			
			for(int i = 0; i<l; i++){
				m[i] = in.nextLine();
				
			}
		}	
	}
}