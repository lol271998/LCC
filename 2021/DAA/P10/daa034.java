import java.util.*;

// Classe que representa uma aresta
class Edge {
    int to;     	// No destino
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
}

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
    int min = 0;
    
    Graph(int n) {
		this.n = n;
		nodes = new Node[n];  // +1 se os nos comecam em 1 ao inves de 0
		for (int i=0; i<n; i++) {
	   		nodes[i] = new Node();
		}
    }
    
    void addLink(int a, int b, int c) {
		nodes[a].adj.add(new Edge(b, c));
    }

    boolean bellmanford(int s) {

    	for(int i = 0; i<n; i++){
    		nodes[i].distance = Integer.MAX_VALUE/2;
	    }

    	nodes[s].distance = 0;
    	TreeSet<NodeQ> q = new TreeSet<>();
    	q.add(new NodeQ(0,s));

    	for(int i = 1; i<=n; i++){
   			if(q.isEmpty()) return true;
   			NodeQ nq = q.pollFirst();
   			int u = nq.node;
   			
   			for(Edge e : nodes[u].adj){
   				int v = e.to;
   				int cost = e.weight;
   				if(nodes[u].distance + cost < nodes[v].distance) {
   					q.remove(new NodeQ(nodes[v].distance,v));
   					nodes[v].distance = nodes[u].distance + cost;
   					q.add(new NodeQ(nodes[v].distance,v));
   				}
   			}
   		}
   		if(q.isEmpty()) return true;
   		else{
   			NodeQ nq = q.pollFirst();
	   		int u = nq.node;
	   		for(Edge e : nodes[u].adj){
	   			int v = e.to;
	   			int cost = e.weight;
	   			if(nodes[u].distance + cost < nodes[v].distance) return false;
   			}
   		}

   	return true;
    }
}

class daa034{

	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);

		int c = in.nextInt();

		for(int i = 0; i<c; i++ ) {
	
			int n = in.nextInt();
			int m = in.nextInt();

			Graph g = new Graph(n);

			for(int j = 0; j<m; j++){
				g.addLink(in.nextInt(),in.nextInt(),in.nextInt());
			}

			if(!(g.bellmanford(1))) System.out.println("possivel");
			else System.out.println("impossivel");
			
		}
	}
}