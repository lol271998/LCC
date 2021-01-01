
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
    double weight;  // Peso da aresta
    
    Edge(int t, double w) {
		to = t;
		weight = w;
    }

    public String toString(){
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
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public double distance;      // Distancia ao no origem da pesquisa
    
    Node() {
		adj = new LinkedList<>();
    }
}

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
    public double cost;
    public int node;

    NodeQ(double c, int n) {
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
    
    void addLink(int a, int b, double c, int i) {
    	Edge e = new Edge(b,c);
		nodes[a].adj.add(e);
		//System.out.println("i: "+i);
		//edges[i] = e;
		//System.out.println(e);
		//System.out.println("added: "+a+" -> "+b);
    }

    // Algoritmo de Prim
    double prim(int r) {
	
		//Inicializar nos como nao visitados e com distancia infinita
		for (int i=1; i<=n; i++) {
	   		nodes[i].distance = Double.MAX_VALUE;
	    	nodes[i].visited  = false;
		}
		
		double total = 0;

		// Inicializar "fila" com no origem
		nodes[r].distance = 0;
		TreeSet<NodeQ> q = new TreeSet<>();

		q.add(new NodeQ(0, r)); // Criar um par (dist=0, no=r)

		// Ciclo principal do Prim
		while (!q.isEmpty()) {
      
	    // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
	    	NodeQ nq = q.pollFirst();
	    	int  u = nq.node;
	    	nodes[u].visited = true;
	    	//System.out.println(u + " [dist=" + nodes[u].distance + "]");
	    	total += nodes[u].distance;
	    	
	    	// Relaxar arestas do no retirado
	    	for (Edge e : nodes[u].adj) {
				int v = e.to;
				double cost = e.weight;
				if (!nodes[v].visited && cost < nodes[v].distance) {
				    q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
				    nodes[v].distance = cost;
				    q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
				}
	    	}
		}

		return total;	
    }

    /* Algoritmo de Kruskal
    int kruskal() {

    	TreeSet<NodeQ> q = new TreeSet<>();
    	Arrays.sort(edges);

    	return 0;
    }*/

}

class daa037{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int edges = (n*(n-1))/2; //Numero de arestas
		Graph g = new Graph(n);
		Point[] parray = new Point[n+1];

		for(int i = 1; i<=n; i++){
			parray[i] = new Point(in.nextInt(),in.nextInt());
		}

		int index = 0;

		for(int i = 1 ; i<=n; i++){
			for(int j = 1; j<=n; j++){
				if(i!=j){
					Point p1 = parray[i];
					Point p2 = parray[j];
					double dist = Math.sqrt( ((p1.x-p2.x)*(p1.x-p2.x)) + ((p1.y-p2.y)*(p1.y-p2.y)) );
					//System.out.println("i: "+i+"; j: "+j);		
					g.addLink(i,j,dist,i-1);
				}
			}
		}
		System.out.println(g.prim(1));
		//System.out.println(g.kruskal());
	}
}