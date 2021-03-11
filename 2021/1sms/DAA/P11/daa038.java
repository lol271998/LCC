import java.util.*;

//Class que representa uma coordenada
class Point{
	int x,y;

	Point(int p1,int p2){
		x = p1;
		y = p2;
	}
}

// Classe que representa uma aresta
class Edge implements Comparable<Edge> {
    int to;     	// No destino
    int weight;  // Peso da aresta
    
    Edge(int t, int w) {
		to = t;
		weight = w;
    }

    public String toString() {
    	return "edge: "+to+", weight: "+weight;
    }

    @Override
    public int compareTo(Edge e) {
    	if (weight < e.weight) return -1; 
        if (weight > e.weight) return +1;
        else return 0;
    }
}

// Classe que representa um no
class Node {
    public LinkedList<Edge> adj;  // Lista de adjacencias
    public boolean visited; // No ja foi visitado?
    public int distance;          // Distancia ao no origem da pesquisa

    
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
    Edge[] edges; 	// Array para conter as arestas
    
    Graph(int n) {
		this.n = n;
		//System.out.println("n: "+n);
		int nEdges = ((n*(n-1))/2);
		//System.out.println("nEdges: "+nEdges);
		edges = new Edge[nEdges];
		//System.out.println("edges: "+(((n*(n-1))/2)+1));
		
		nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
		for (int i=1; i<=n; i++) nodes[i] = new Node();
    }
    
    void addLink(int a, int b, int c) {
		nodes[a].adj.add(new Edge(b, c));
		nodes[b].adj.add(new Edge(a, c));
		//System.out.println("added: "+a+" <-> "+b+"; with: "+c);
    }

    // Algoritmo de Prim
    void prim(int r, int a,int b,int c) {

    	int total = 0;
	
		//Inicializar nos como nao visitados e com distancia infinita
		for (int i=1; i<=n; i++) {
	   		nodes[i].distance = Integer.MAX_VALUE;
	   		nodes[i].visited = false;
		}

		// Inicializar "fila" com no origem
		TreeSet<NodeQ> q = new TreeSet<>();
		TreeSet<Integer> mst = new TreeSet<>();
		q.add(new NodeQ(0,r));

		for(int i = 1; i<=a; i++){
			q.add(new NodeQ(0, i)); // Adicionar à fila os nós já existentes
		}

		// Ciclo principal do Prim
		while (!q.isEmpty()) {
	    // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
	    	NodeQ nq = q.pollFirst();
	    	int  u = nq.node;

	    	mst.add(nodes[u].distance);
	    	nodes[u].visited = true;

	    	// Relaxar arestas do no retirado
	    	for (Edge e : nodes[u].adj) {
				int v = e.to;
				int cost = e.weight;
				if (!nodes[v].visited && cost < nodes[v].distance) {
				    q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
				    nodes[v].distance = cost;
				    q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
				}
	    	}
		}

		int[] path = new int[b];

		for(int i = 0; i<b; i++){
			path[i] = mst.pollFirst();
			total+=path[i];
		}

		FastPrint.out.println(total);
		for(int i = 0; i<b-1; i++){
			FastPrint.out.printf("%d ",path[i]);
		}
		FastPrint.out.printf("%d\n",path[b-1]);
    }
}

class daa038{

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);

		int a = in.nextInt(); // Casas já na rede -> [1,A]
		int b = in.nextInt(); // Casas a adicionar-> [A+1,A+B]
		int c = in.nextInt(); // Número de possíveis ligações

		Graph g = new Graph(a+b);

		for(int i = 0; i<c; i++) {
			g.addLink(in.nextInt(),in.nextInt(),in.nextInt());
		}

		int[] path = new int[a+b];

		g.prim(1,a,b,c);

		FastPrint.out.close();
	}
}