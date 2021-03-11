import java.util.*;

// Classe que representa uma aresta
class Edge {
    int to;     // No destino
    double weight; // Peso da aresta
    
    Edge(int t, double w) {
	to = t;
	weight = w;
    }
}

// Classe que representa um no
class Node {
    public LinkedList<Edge> adj; // Lista de adjacencias
    public boolean visited;      // No ja foi visitado?
    public double distance;         // Distancia ao no origem da pesquisa
    
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
    int min = 0;
    
    Graph(int n) {
	this.n = n;
	nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
	for (int i=1; i<=n; i++)
	    nodes[i] = new Node();
    }
    
    void addLink(int a, int b, double c) {
		nodes[a].adj.add(new Edge(b, c));
		nodes[b].adj.add(new Edge(a, c));
    }

    // Algoritmo de Dijkstra
    double dijkstra(int s, int d) {
	
		//Inicializar nos como nao visitados e com distancia infinita
		for (int i=1; i<=n; i++) {
		    nodes[i].distance = Double.MAX_VALUE;
		    nodes[i].visited  = false;
		}
	
		// Inicializar "fila" com no origem
		nodes[s].distance = 0.0;
		TreeSet<NodeQ> q = new TreeSet<>();
		q.add(new NodeQ(0, s)); // Criar um par (dist=0, no=s)

		// Ciclo principal do Dijkstra
		while (!q.isEmpty()) {
    	  
		    // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
		    NodeQ nq = q.pollFirst();
		    int  u = nq.node;
		    nodes[u].visited = true;
		    //System.out.println(u + " [dist=" + nodes[u].distance + "]");
		    if(u == d){
		    	return nodes[u].distance;
		    }
		    
		    // Relaxar arestas do no retirado
		    for (Edge e : nodes[u].adj) {
				int v = e.to;
				double cost = e.weight;
				if (!nodes[v].visited && nodes[u].distance + cost < nodes[v].distance) {
			   		q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
			   		nodes[v].distance = nodes[u].distance + cost;
			    	q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
				}
	    	}
		}
		return -1;
    }
}

class daa033{

	public static String[] loc; //String que guarda os locais
	public static int n,e;


	static int find(String str){

		int i;
		
		for(i = 0; i<n; i++){	
			if(loc[i].equals("")){
				loc[i] = str;
				return i+1;
			}
			if(str.equals(loc[i])) return i+1;
		}
		return i+1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		e = in.nextInt();
		in.nextLine();

		loc = new String[n];
		Arrays.fill(loc,"");

		String[] line = (in.nextLine()).split(" ",2);
		loc[0] = line[0];
		loc[1] = line[1];
		
		Graph g = new Graph(n);

		for(int i = 0; i<e; i++){
			
			String[] str = (in.nextLine().split(" ",3));
			int a = find(str[0]);
			int b = find(str[1]);
			double cost = Double.parseDouble(str[2]);
			
			//System.out.println("a: "+a+", b: "+b+", cost: "+cost);

			g.addLink(a,b,cost);

		}
		System.out.println(Math.round(g.dijkstra(1,2)*100.0)/100.0);
		/*
		double a = g.dijkstra(1,2);
		System.out.println("-----------------");
		double b = g.dijkstra(2,1);

		if(a == -1) System.out.println(b);
		if(b == -1) System.out.println(a);
		else if(a<=b) System.out.println(a);
		else System.out.println(b);
		*/
	}
}