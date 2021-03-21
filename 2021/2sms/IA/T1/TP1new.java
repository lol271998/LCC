package trabalhos;
import java.util.*;
import java.lang.*;

class Node{
	int x,y;
	Node next;
	Node(int x,int y){
		this.x=x;
		this.y=y;
	}
	
}

/* 
Pode dar jeito

class Pair {

	Node n1,n2;

	Pair (Node n1, Node n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
}

class Segment {
	Pair a;
	Pair b;

	Segment(Pair a, Pair b) {
		this.a = a;
		this.b = b;
	}
}
*/

public class TP1 {
	
	static int[][] map;
	static boolean[][] visitado;
	static LinkedList<Node> poligono=new LinkedList<Node>();
	static Node[] nodeArray; // use order in permutation method
	
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
		
		
		//HILL CLIMBING
	//alinea a: best-improvement first --> descruzar o que causar perimetro menor com as novas arestas
	static void BIF(int n) {
		
	}
	
	static Double calcEdges(Node a, Node b) {
	
		double dist=  Math.sqrt(Math.pow((a.x - b.x), 2) +  Math.pow((a.y - b.y),2));
		return dist;
		
	}
	
	//euclidian distance, return nearest node from 'no'
	static Node nearest(Node no, int m) {
		int min=Integer.MAX_VALUE; 
		int dist, a=0,b=0;
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=m;j++) {
				if(map[i][j] !=0 && visitado[i][j]==false) {
					dist= (int) Math.sqrt(Math.pow((no.x - i), 2) +  Math.pow((no.y - j),2));
					if(min>dist) {
						min=dist;
						a=i; b=j;
					}
						
				}
			}
		}
		visitado[a][b]=true;
		Node near = new Node(a,b);
		return near;
		
	}

	//alinea a
	static void permutation(int n){
		Node prev = null;
		
		
		for(int i=0;i<n ;i++) {
			poligono.add(nodeArray[i]);
			prev.next = nodeArray[i];
			prev = nodeArray[i];				
			
		}
		
	}
	//alinea b
	static void NNfirst(Node start, int n, int m){
		int count=n;
		Node aux;
		poligono.add(start);
		while(count>0) {
			aux=nearest(start,m);
			start.next=aux;
			aux=start;
			count--;
		}
					
	}
	
	static void generate(int n , int m) {
		
		//creating a map
		for(int i=0;i<=m;i++)
			for(int j=0;j<=m;j++) {
			 map[i][j]=0;
			 visitado[i][j]=false;
			}
										
		for(int i=0;i<=n;i++) {
			int x = new Random().nextInt(m) ;
			int y = new Random().nextInt(m);
			//if already exists
			if(map[x][y]==1) 
				i--;
			
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
		n=in.nextInt();
		m=in.nextInt();
		map=new int[m][m];
		visitado= new boolean[m][m];
		nodeArray = new Node[n];
		generate(n,m);

	}

}