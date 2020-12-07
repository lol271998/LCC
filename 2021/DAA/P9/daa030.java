import java.util.*;

class Node{

	LinkedList<Integer> adj;
	boolean visited;
	int distance = 0;

	Node(){
		adj = new LinkedList<Integer>();
	}

}

class Graph{
	int n; //Nós do grafo 
	Node[] nodes; //Array de nodes
	int excent;
	int[][]  m; //Matrix com distâncias minimas;

	Graph(int n){
		this.n = n;
		nodes = new Node[n+1];
		m = new int[n+1][n+1];
		
		for(int i = 1; i<=n; i++){
			nodes[i] = new Node();
		}

		for(int i = 0; i<=n; i++)
			for(int j = 0; j<=n; j++) m[i][j] = 0;
	}

	void addLink(int a, int b){
		nodes[a].adj.add(b);
	}

	int excent(int[] l, int v){
		excent = 0;		
		
		for(int i = 1; i<=n; i++){
			if(l[i]>=excent) excent = l[i];
		}

		return excent;
	}

	int getExcent(){return excent;}


	void bfs(int v){
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=n; i++) nodes[i].visited = false;
		
		q.add(v);
		nodes[v].visited = true;
		nodes[v].distance = 0;
		
		while(!q.isEmpty()){
			int u = q.poll();
			for(int w : nodes[u].adj){
				if(!nodes[w].visited){
					q.add(w);
					
					nodes[w].visited = true;	
					nodes[w].distance = nodes[u].distance + 1;				
					//Guardar a distância na matrix
					m[v][w] = nodes[w].distance;
					//System.out.println("["+v+","+w+"]: "+m[v][w]);
				}
			}
		}
		excent(m[v],v);
		//System.out.println("------------------------");
	}
}

class daa030{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(); 
		Graph g = new Graph(n);

		int e = in.nextInt();

		for(int i = 0; i<e; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			g.addLink(a,b); g.addLink(b,a);
		}

		int d = 0, r = Integer.MAX_VALUE;
		
		for(int i = 1; i<=n; i++){
			g.bfs(i);
			d = Math.max(g.getExcent(),d);
			r = Math.min(g.getExcent(),r);
		}
		System.out.println(d);
		System.out.println(r);

		int sizec = 0;
		int sizep = 0;

		for(int i = 1; i<=n; i++){
			g.bfs(i);
			if(g.getExcent() == r) sizec++;
			if(g.getExcent() == d) sizep++;
		}
		int[] c = new int[sizec];
		int[] p = new int[sizep];

		sizec = 0;
		sizep = 0;

		for(int i = 1; i<=n; i++){
			g.bfs(i);
			if(g.getExcent() == r) c[sizec++] = i;
			if(g.getExcent() == d) p[sizep++] = i;
		}

		Arrays.sort(c);
		Arrays.sort(p);

		System.out.print(c[0]);
		for(int i = 1; i<sizec; i++) System.out.print(" "+c[i]);
		System.out.println();

		System.out.print(p[0]);
		for(int i = 1; i<sizep; i++) System.out.print(" "+p[i]);
		System.out.println();
	}
}