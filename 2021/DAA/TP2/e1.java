import java.util.Scanner;

class e1{

    static int n,count;              // Numero de nos do grafo
    static boolean adj[][];    // Matriz de adjacencias
    static boolean visited[];  // Que nos ja foram visitados?

    static int count(){
    	count = 0;
    	for(int i = 1; i<=n; i++){
    		if(!visited[i]){
    			count++;
    			dfs(i);
    		}
    	}
    	return count;
    }

    static void dfs(int v) {
    	//System.out.println(v) //imprimir por ordem
		visited[v] = true;
		for (int i=1; i<=n; i++){
		    if (adj[v][i] && !visited[i]){
				dfs(i);
			}
		}
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		int e = in.nextInt();
		adj = new boolean[n+1][n+1];
		visited = new boolean[n+1];

		for(int i = 0; i<e; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			adj[a][b] = adj[b][a] = true;
		}
		System.out.println(count());
	}
}