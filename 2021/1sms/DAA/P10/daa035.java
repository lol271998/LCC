import java.util.*;

// Classe que representa uma aresta
class Edge {
    int to;     // No destino
    int weight; // Peso da aresta
    
    Edge(int t, int w) {
	to = t;
	weight = w;
    }
}

// Classe que representa um no
class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public int distance;         // Distancia ao no origem da pesquisa
    
    Node() {
		adj = new LinkedList<>();
    } 
};

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
    public int cost;
    public int node;

    NodeQ(int c, int n) {
	cost = c;
	node = n;
    }

    @Override
    public int compareTo(NodeQ nq) { 
        if (cost < nq.cost) return -1; 
        if (cost > nq.cost) return +1;
	if (node < nq.node) return -1; 
	if (node > nq.node) return +1;
        return 0; 
    } 
}

// Classe que representa um grafo
class Graph {
    int n;          // Numero de nos do grafo
    Node[] nodes;   // Array para conter os nos
    int[][] dist;
    int[][] connected;

    Graph(int n) {
		this.n = n;
		nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
		dist = new int[n+1][n+1];
		connected = new int[n+1][n+1];

		for (int i=1; i<=n; i++){
		    nodes[i] = new Node();
			Arrays.fill(dist[i],Integer.MAX_VALUE);
			Arrays.fill(connected[i],0);

    	}

    	for(int i = 1; i<=n; i++){
    		connected[0][i] = i; //Imprimir i+64
    		connected[i][0] = i; //Imprimir i+64
    	}
	}
    
    void addLink(int a, int b, int c) {
		nodes[a].adj.add(new Edge(b, c));
		connected[a][b] = 1;
    }

    void floydwarshall(){
    	//Diagonal igual a 0
    	for(int i = 1; i<=n; i++){
    		dist[i][i] = 0;
    	}

    	nodes[0].distance = 0;
    	TreeSet<NodeQ>q = new TreeSet<>();
    	q.add(new NodeQ(0,0));
    	NodeQ nq = q.pollFirst();
    	int u = nq.node;

    	for(Edge e : nodes[u].adj){
    		int v = e.to;
    		int cost = e.weight;
    		dist[v][u] = cost;
    	}

    	for(int k = 1; k<=n; k++){
    		for(int i = 1; i<=n; i++){
    			for(int j = 1; j<=n; j++){
    				if(dist[i][k] + dist[k][j] < dist[i][j])
    					dist[i][j] = dist[i][k] + dist[k][j];
    			}
    		}
    	}
    }

    void tfloydwarshall(){
    	
    	// 1 - verdadeiro
    	// 0 - falso

    	for(int i = 1; i<=n; i++) {
    		connected[i][i] = 1;
    	}
    	/*
    	for(int i = 1; i<=n; i++){
    		for(Edge e : nodes[i].adj){
    			connected[e.to][i] = 1;
    		}
    	}*/

    	for(int k = 1; k<=n; k++) {
    		for(int i = 1; i<=n; i++) {
    			for(int j = 1; j<=n; j++) {
    				//System.out.printf("(%c,%c) = %d | (%c,%c) = %d\n",i+64,k+64,connected[i][k],k+64,j+64,connected[k][j]);
    				if(connected[i][k] == 1 && connected[k][j] == 1){
    					connected[i][j] = 1;
    					//System.out.printf("-> (%c,%c) = %d\n",i+64,j+64,connected[i][j]);
    				}
    			}
    		}
    	}
    }

    void print() {
		for(int i = 0; i<=n; i++) {
			for(int j = 0; j<=n; j++) {
				if(i == 0 && j!= 0) System.out.printf(" %c",(connected[i][j]+64));
				else if(i!= 0 && j == 0)  System.out.printf("%c",(connected[i][j]+64));
				else if(i == 0 && j == 0) System.out.print(" ");
				else System.out.print(" "+connected[i][j]);
			}
			System.out.println();
		}
	}


}
class daa035{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		Graph g = new Graph(n);

		for(int i = 0; i<n; i++){
			
			String str = in.nextLine();
			int a = str.charAt(0)-64;

			String numberOnly = str.replaceAll("[^0-9]", "");
			int k = Integer.parseInt(numberOnly);

			//System.out.println(k);
			int j = 4;
			if(k>=10) j = 5;
			
			while(j<=(2*(k+1))){
				g.addLink(a,(str.charAt(j)-64),0);
				//System.out.printf((i+1)+": Added Link: (%d,%c)\n",(a),(str.charAt(j)));
				j+=2;
			}
		}

		//g.print();
		//System.out.println();
		g.tfloydwarshall();
		g.print();
	}
}