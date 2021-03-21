package trabalhos;
import java.util.*;
import java.lang.*;

class Node{
	int x,y;
	Node next;
	Node(int x,int y){
		this.x=x;
		this.y=y;
		next=null;
	}
	
}



class Pair implements Comparable<Pair> {

	Node n1,n2;
	double dist;

	Pair (Node n1, Node n2, double dist) {
		this.n1 = n1;
		this.n2 = n2;
		this.dist = dist;
	}

	@Override
    public int compareTo(Pair a) { 
        if (dist < a.dist) return -1; 
        if (dist > a.dist) return +1;
        return 0; 
    } 
}

public class TP1 {
	
	static int[][] map;
	static boolean[][] visitado;
	static LinkedList<Node> poligono = new LinkedList<Node>();
	static Node[] nodeArray; // use order in permutation method
	static ArrayList<LinkedList<Pair>> crossesWithFirst = new ArrayList<LinkedList<Pair>>();
	
	//2-exchange
	static int dir(Node n1, Node n2, Node i) {
		return (((n1.x - i.x)*(n2.y - i.y) - (n1.y- i.y)*(n2.x-i.x)));
	}
	
	static boolean onSeg(Node n1, Node n2, Node i) {
	
		return (((Math.min(n1.x,n2.x) <= i.x) 
			&&   (Math.max(n1.x,n2.x) >= i.x)) 
			&&  ((Math.min(n1.y,n2.y) <= i.y) 
			&&   (Math.max(n1.y,n2.y))>= i.y));
	
	}

	static boolean intersect(Node n1, Node n2, Node n3, Node n4) {

		int d1,d2,d3,d4;
		d1 = dir(n3,n4,n1);
		d2 = dir(n3,n4,n2);
		d3 = dir(n1,n2,n3);
		d4 = dir(n1,n2,n4);

		if( ((d1>0 && d2<0) || (d1<0 && d2>0)) && 
			((d3>0 && d4<0) || (d3<0 && d4>0))) return true;

		else if(d1 == 0 && onSeg(n3,n4,n1)) return true;
		else if(d2 == 0 && onSeg(n3,n4,n2)) return true;
		else if(d3 == 0 && onSeg(n1,n2,n3)) return true;
		else if(d4 == 0 && onSeg(n1,n2,n4)) return true;
	
		else return false;

	}


	void findIntersection() {

		for(int i = 0; i<poligono.size(); i++) {
			Node a = poligono.get(i);
			Node b = a.next;
			Pair n = new Pair(a,b,0);

			LinkedList<Pair> l = new LinkedList<Pair>();
			l.add(n);

			for(int j = i+1; j<poligono.size(); j++) {
				Node p = poligono.get(j);
				Node q = p.next;
				if(intersect(a,b,p,q)) {
					Pair ntemp = new Pair(p,q,0);
					l.add(ntemp);
				}

			}
			crossesWithFirst.add(l);
		}
	}
		
		//HILL CLIMBING
	//alinea a: best-improvement first --> descruzar o que causar perimetro menor com as novas arestas
	static void BIF(int n) {
		
		boolean cross = false;
		
		//nao sei os limites de iteracao
		while(n>0) {
			Node a,b,p,q; // par(a,b) e (p,q) sao arestas
			a = poligono.get(n);
			b = a.next;
			TreeSet<Pair> crossedEdges = new TreeSet<>(); //ordem ascendente
			for(int j = 0; j<poligono.size(); j++) {
				
				p = poligono.get(j);
				q = p.next;	
				cross = intersect(a,b,p,q);
				
				// j!=n para n usar o mesmo par (a,b) (a,b)
				if(j != n && cross) {
					double edge1 = calcEdges(a,p);
					double edge2 = calcEdges(b,q);
					//ou
					double edge3 = calcEdges(a,q);
					double edge4 = calcEdges(b,p);
					//as duas possibilidades de descruzar 
					Pair aux = new Pair(p, q, (edge1 + edge2));
					Pair aux2 = new Pair(q, p, (edge3 + edge4));
					crossedEdges.add(aux); crossedEdges.add(aux2); // será sempre:no a junta com n1 e b com n2
				}
			}
			Pair best = crossedEdges.first();
			a.next = best.n1;
			b.next = best.n1;
			n--;
		}
		
	}
	// calc the size of an edge
	static Double calcEdges(Node a, Node b) {
	
		double dist = Math.sqrt(Math.pow((a.x - b.x),2) +  Math.pow((a.y - b.y),2));
		return dist;
		
	}
	
	//calc perimeter of poligono
	static Double perimeter(LinkedList<Node> poligono) {
		double sum = 0;
		Node first = poligono.get(0); //first
		Node a = first;
		Node b = first.next;
		while(a != first) {
			sum += Math.sqrt(Math.pow((a.x - b.x), 2) +  Math.pow((a.y - b.y),2));
			a = b;
			b = b.next;
		}
			
		return sum;
	}
	
	
	//alinea 4b first improvement
	static void fistImprovement() {
		
	}
	
	//euclidian distance, return nearest node from 'no'
	static Node nearest(Node no, int m) {
		int min = Integer.MAX_VALUE; 
		int dist, a = 0,b = 0;
		for(int i = 0;i <= m; i++) {
			for(int j = 0;j <= m;j++) {
				if(map[i][j] != 0 && !visitado[i][j]) {
					dist = (int) Math.sqrt(Math.pow((no.x - i),2) +  Math.pow((no.y - j),2));
					if(min > dist) {
						min = dist;
						a = i; b = j;
					}
						
				}
			}
		}
		visitado[a][b] = true;
		Node near = new Node(a,b);
		return near;
		
	}
	//alinea a
	static void permutation(int n){

		for(int i = 0;i < n ; i++) {
			poligono.add(nodeArray[i]);
			if(i > 0)
				poligono.get(i-1).next = nodeArray[i];			
			
		}
		//conect first and last
		poligono.getLast().next = nodeArray[0];
	}
	
	//alinea b
	static void NNfirst(Node start, int n, int m){
		
		int count = n;
		Node aux;
		poligono.add(start);

		while(count > 0) {
			aux = nearest(start,m);
			start.next = aux;
			aux = start;
			count--;
		}
					
	}
	
	static void generate(int n , int m) {
		
		//creating a map
		for(int i = 0;i <= m; i++) {
			for(int j = 0; j <= m; j++) {
			 map[i][j] = 0;
			 visitado[i][j] = false;
			}
		}
										
		for(int i=0;i<n;i++) {

			int x = new Random().nextInt(m);
			int y = new Random().nextInt(m);

			//if already exists
			if(map[x][y]==1) i--;
			
			else {
				map[x][y]=1;	
				Node no = new Node(x,y);
				nodeArray[i] = no;
			}
		}
	}
	
	
	public static void main(String args[]) {
		int n,m;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[m+1][m+1];
		visitado = new boolean[m+1][m+1];
		nodeArray = new Node[n];
		generate(n,m);

	}

}