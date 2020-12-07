import java.util.Scanner;
import java.util.Arrays;

class daa027{
	// Cores: -1 ou 1
	static int n,edges,flag = 0;
	static boolean adj[][];
	static int visited[]; //visited[i] = 0, não foi visitado


	static void dfs(int v, int c){
		visited[v] = c;
		for(int i = 0; i<=n; i++){
			System.out.printf("adj[%d][%d]: %b | visited[%d]: %d | visited[%d]: %d\n",v,i,adj[v][i],v,visited[v],i,visited[i]);
			if(adj[v][i]){
				if(visited[i] == 0){
					visited[i] = -c;
					System.out.printf("visited[%d]: %d\n",i,visited[i]);
					dfs(i,-c);
				}
				else if(visited[i] == visited[v]){
					flag = 1;
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for(int k = 0; k<t; k++){

			n = in.nextInt();
			adj = new boolean[n+1][n+1];
			visited = new int[n+1];
			edges = in.nextInt();

			for(int i = 0; i<edges; i++){
				int a = in.nextInt();
				int b = in.nextInt();
				//System.out.println(a+" "+b);
				adj[a][b] = adj[b][a] = true;
			}

			int c = 1;
			for(int i = 1; i<=n; i++){
				
				if(visited[i]==0) dfs(i,c);
				else dfs(i,visited[i]);
				
				if(flag == 1){
					System.out.println("nao");
					break;
				}

				System.out.println("-------------------------------------");
			}
			
			if(flag == 0) System.out.println("sim");
			
			flag = 0;
		}
	}
}