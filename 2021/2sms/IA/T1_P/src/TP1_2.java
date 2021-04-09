import java.util.*;

import javax.swing.JFrame;

class Node {

	int x,y;
	Node prev,next;

	Node(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public boolean isEqual(Node n) {
		if(this.x == n.x && this.y == n.y) return true;
		else return false;
	}
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
}

class Edge implements Comparable<Edge> {

	Node n1,n2;
	double dist;

	Edge (Node n1, Node n2, double dist) {
		this.n1 = n1;
		this.n2 = n2;
		this.dist = dist;
	}

	@Override
	public int compareTo(Edge a) { 
		if (dist < a.dist) return -1; 
		if (dist > a.dist) return +1;
		return 0; 
	} 
}

public class TP1_2 {

	static HashMap<Node, Boolean> map = new HashMap<>();
	static LinkedList<Node> poligono = new LinkedList<Node>();
	static LinkedList<Node> poligonoteste = new LinkedList<Node>();
	static Node[] nodeArray; // use order in permutation method
	static ArrayList<LinkedList<Edge>> crossesWithFirst = new ArrayList<LinkedList<Edge>>(); //each list has list of intersected edges
	static int ite;

	//1 
	static void generate(int n , int m) {
		nodeArray=new Node[n+1]; 	
		for(int i=0;i<n;i++) {

			int x = new Random().nextInt(m +m) -m ;
			int y = new Random().nextInt(m+m ) -m ;
			Node no = new Node(x,y);
			//if already exists
			if(map.containsKey(no)) i--;

			else {		
				//map[x][y]=1;	
				map.put(no, false);
				nodeArray[i] = no;
				System.out.println("Node n"+i+" = new Node("+no.x+","+no.y+");");
				System.out.println("nodeArray["+i+"] = n"+i+";");
			}
		}
	}

	//2 a)

	static void permutation(int n){
		for(int i = 0;i <n ; i++) poligono.add(nodeArray[i]);
	}

	//End 1 a)

	//2 b)

	//euclidian distance, return nearest node from 'no'
	static Node nearest(Node no, int m) {
		int min = Integer.MAX_VALUE; 
		int dist, a = 0,b = 0;
		for(int i = 0;i <= m; i++) {
			for(int j = 0;j <= m;j++) {
				if(map.containsKey(no) && !map.get(no)) {
					dist = (int) Math.sqrt(Math.pow((no.x - i),2) +  Math.pow((no.y - j),2));
					if(min > dist) {
						min = dist;
						a = i; b = j;
					}

				}
			}
		}

		map.put(new Node(a,b), true);
		Node near = new Node(a,b);
		return near;
	}

	static void NNfirst(Node start, int n, int m){

		int count = n;
		Node aux;
		poligono.add(start);

		while(count > 0) {
			aux = nearest(start,m);
			poligono.add(aux);
			aux = start;
			count--;
		}
	}

	//End 2 b)

	//3

	static boolean onSeg(Node n1, Node n2, Node i) {

		return (((Math.min(n1.x,n2.x) <= i.x) && (Math.max(n1.x,n2.x) >= i.x)) 
				&&((Math.min(n1.y,n2.y) <= i.y) && (Math.max(n1.y,n2.y) >= i.y)));

	}

	static int dotProduct(Node n1, Node n2, Node n3, Node n4) {

		Node v1 = new Node(n2.x-n1.x,n2.y-n1.y);
		Node v2 = new Node(n4.x-n3.x,n4.y-n3.y);

		int res = v1.x*v2.x + v1.y*v2.y;
		return res;

	}

	static int dir(Node n1, Node n2, Node n3) {
		return ((n3.x-n1.x)*(n2.y-n1.y)) - ((n2.x-n1.x)*(n3.y-n1.y));
	}

	static boolean isCollinear(Node n1, Node n2, Node n3) {

		int d1;

		d1 = dir(n1,n2,n3);
		//System.out.println("d1: "+d1+" dotProduct: "+dotProduct(n1,n2,n2,n3));
		if(d1 == 0 && dotProduct(n1,n2,n2,n3)<0) return true;
		else return false;

	}

	static boolean intersect(Node n1, Node n2, Node n3, Node n4) {

		int d1,d2,d3,d4;

		d1 = dir(n1,n2,n3); 
		d2 = dir(n1,n2,n4); 
		d3 = dir(n3,n4,n1); 
		d4 = dir(n3,n4,n2); 

		/*
		//Debugging
		System.out.println(n3+" "+n4);

		System.out.println("d1: "+d1+",d2: "+d2+",d3: "+d3+",d4: "+d4);
		System.out.println("onSeg(n3,n4,n1): "+onSeg(n1,n2,n3));
		System.out.println("onSeg(n3,n4,n2): "+onSeg(n3,n4,n2));
		System.out.println("onSeg(n1,n2,n3): "+onSeg(n1,n2,n3));
		System.out.println("onSeg(n1,n2,n4): "+onSeg(n1,n2,n4));
		 */

		if (((d3>0 && d4<0) || (d3<0 && d4>0)) 
				&& ((d1>0 && d2<0) || (d1<0 && d2>0))) return true;
		else if(d1 == 0 && onSeg(n1,n2,n3)) return true;
		else if(d2 == 0 && onSeg(n1,n2,n4)) return true;
		else if(d3 == 0 && onSeg(n3,n4,n1)) return true;
		else if(d4 == 0 && onSeg(n3,n4,n2)) return true;
		else return false;

	}

	//Seja a,b duas edges, se a cruza com b, então b também cruza com a
	static void findIntersection() {
		for(int i = 0; i<poligono.size(); i++) {
			Node a,b;
			a = poligono.get(i);
			if(i == poligono.size()-1) {
				b = poligono.get(0);
			}
			else{
				b = poligono.get(i+1);
			}

			//System.out.println("Comparar"+a+" "+b+ " com: ");

			Edge e = new Edge(a,b,0);
			LinkedList<Edge> lEdge = new LinkedList<Edge>();
			lEdge.add(e);

			for(int j = 0; j<poligono.size(); j++) {
				Node p,q;

				p = poligono.get(j);
				if(j == poligono.size()-1) q = poligono.get(0);
				else q = poligono.get(j+1);

				Edge f = new Edge(p,q,0);
				//System.out.println(p+" "+q);
				if((!a.isEqual(p)) && (!b.isEqual(q))) {

					//Se for aresta anterior
					if(a.isEqual(q) && isCollinear(q,a,b)) {
						lEdge.add(f);
					}

					//Se for aresta seguinte
					else if(b.isEqual(p) && isCollinear(a,b,p)) {
						lEdge.add(f);
					}

					else if(!a.isEqual(q) && !b.isEqual(p)){
						if(intersect(a,b,p,q)){
							lEdge.add(f);
						}
					}
				}
			}
			crossesWithFirst.add(lEdge);
		}
	}

	static void exchange(Edge a, Edge b) {

		int ind1=0,ind2=0,ind3=0,ind4=0;
		int i = 0;
		for(i = 0;i<poligono.size();i++) {
			Node aux = poligono.get(i);
			if (aux.x == a.n1.x && aux.y == a.n1.y) {ind1=i;}
			if (aux.x == a.n2.x && aux.y == a.n2.y) {ind2=i;}
			if (aux.x == b.n1.x && aux.y == b.n1.y) {ind3=i;}
			if (aux.x == b.n2.x && aux.y == b.n2.y) {ind4=i;}

		}

		if(ind4 == poligono.size()-1) ind4 = 0;
		if(ind1 == poligono.size()-1) ind1 = 0;


		if(isCollinear(a.n1,a.n2,b.n1)) {

			poligono.remove(ind4);
			poligono.add(ind1+1,b.n2);

		}
		else{
			poligono.add(ind2,b.n1);
			poligono.remove(ind2 +1);
			poligono.add(ind3,a.n2);
			poligono.remove(ind3+1);
		}
	}
	
	static void exchangeForTest(Edge a, Edge b) {

		int ind1=0,ind2=0,ind3=0,ind4=0;
		int i = 0;
		for(i = 0;i<poligonoteste.size();i++) {
			Node aux = poligonoteste.get(i);
			if (aux.x == a.n1.x && aux.y == a.n1.y) {ind1=i;}
			if (aux.x == a.n2.x && aux.y == a.n2.y) {ind2=i;}
			if (aux.x == b.n1.x && aux.y == b.n1.y) {ind3=i;}
			if (aux.x == b.n2.x && aux.y == b.n2.y) {ind4=i;}

		}

		if(ind4 == poligonoteste.size()-1) ind4 = 0;
		if(ind1 == poligonoteste.size()-1) ind1 = 0;


		if(isCollinear(a.n1,a.n2,b.n1)) {

			poligonoteste.remove(ind4);
			poligonoteste.add(ind1+1,b.n2);

		}
		else{
			poligonoteste.add(ind2,b.n1);
			poligonoteste.remove(ind2 +1);
			poligonoteste.add(ind3,a.n2);
			poligonoteste.remove(ind3+1);
		}		
	}

	//End 3

	//4

	// a)HILL CLIMBING
	
	// best improvement first

	// calc the size of an edge
	static Double calcEdges(Node a, Node b) {

		double dist = Math.sqrt(Math.pow((a.x - b.x),2) +  Math.pow((a.y - b.y),2));
		return dist;

	}

	//calc perimeter of poligono
	static Double perimeter(LinkedList<Node> pol) {
		double sum = 0;
		Node a,b;
		a = pol.get(0);
		b = pol.get(0);

		for(int i = 0; i<pol.size(); i++) {

			a = pol.get(i);
			if(i != pol.size()-1) b = pol.get(i+1);
			sum += Math.sqrt(Math.pow((a.x-b.x),2) + Math.pow((a.y-b.x),2));

		}

		sum += Math.sqrt(Math.pow((a.x-pol.get(0).x),2) + Math.pow((a.y-pol.get(0).x),2));
		return sum;
	}

	static void BIF(int n) {
		poligonoteste.clear();
		Edge a,b; // (a.n1,a.n2)--->(b.n1,b.n2) edge  
		findIntersection();
		double best = Integer.MAX_VALUE;
		double best_temp = Integer.MAX_VALUE;
		int indexb = 0;
		
		//verify if we have a poligono without intersections and stop
		int count = 0; //if count=n no intersections
		for(int i = 0; i<crossesWithFirst.size(); i++) 
			count += crossesWithFirst.get(i).size();
		if(count == n)
			return;
		
		while(true) {
			//Configuração inicial ver qual dos candidatos causa menor perimetro
			for(int i=0; i<crossesWithFirst.size(); i++) {
				LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
				//poligonoteste has a copy of poligono by creating new nodes
				Node copy;  	
				for(int l = 0; l < poligono.size() ; l++) {
					copy = new Node(poligono.get(l).x, poligono.get(l).y);
					poligonoteste.add(copy);
				}
			
				a = crossedEdgesList.getFirst();
				if(crossedEdgesList.size()>1) {
					b = crossedEdgesList.get(1);
					exchangeForTest(a,b);
					i = 0;
					crossesWithFirst.clear();
					findIntersection();
				}
				
				double p = perimeter(poligonoteste);
				poligonoteste.clear();
				
				if(best_temp>p){
					best_temp = p;
					indexb = i;
				}
			}
			if(best>best_temp) {
				System.out.println("best_temp>best");
				best = best_temp;
				LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(indexb);
				a = crossedEdgesList.getFirst();
				for(int k = 1; k<crossedEdgesList.size(); k++) {
					b = crossedEdgesList.get(k);
					exchange(a,b);
				}
				best_temp = Integer.MAX_VALUE;
			}	
			//Se não consegue melhorar mais
			else return;
			crossesWithFirst.clear();
			findIntersection();
		}
	}

	//alinea 4b first improvement
	static void fistImprovement(int n) {
		Edge a,b; // (a.n1,a.n2)--->(b.n1,b.n2) edge  
		findIntersection();
		
		//verify if we have a poligono without intersections and stop
		int count = 0; //if count = n no intersections
		for(int i = 0; i < crossesWithFirst.size(); i++) 
			count += crossesWithFirst.get(i).size();

		if(count == n) return;

		for(int i = 0; i <crossesWithFirst.size(); i++) {
			LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
			a = crossedEdgesList.getFirst();
			//Escolher o primeiro candidato para descruzar
			for(int k = 1; k<crossedEdgesList.size(); k++) {
				b = crossedEdgesList.get(k);
				exchange(a,b);
			}
			crossesWithFirst.clear();
			findIntersection();
		}
	}


	//alinea 4c
	static void lessIntersections(int n) {
		Edge a,b; // (a.n1,a.n2)--->(b.n1,b.n2) edge  
		findIntersection();
		//verify if we have a poligono without intersections and stop
		int count = 0; //if count = n no intersections
		
		for(int i = 0; i < crossesWithFirst.size(); i++) 
			count += crossesWithFirst.get(i).size();
		if(count == n) return;
		
		int bestmin = Integer.MAX_VALUE;
		for(int i = 0; i < crossesWithFirst.size(); i++) {
			LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
			a = crossedEdgesList.getFirst();
			for(int j = 0; j < crossesWithFirst.size(); j++) {
				if(bestmin>crossesWithFirst.get(j).size() && crossesWithFirst.get(j).size() > 1)
					bestmin = crossesWithFirst.get(j).size();
			}
		}
		
		for(int i = 0; i< crossesWithFirst.size(); i++) {
			LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
			a = crossedEdgesList.getFirst();
			if(bestmin == crossedEdgesList.size()) {
				for(int k = 1; k<crossedEdgesList.size(); k++) {
					b = crossedEdgesList.get(k);
					exchange(a,b);
				}
			}
		}
		
		while(true) {
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < crossesWithFirst.size(); i++) {
				LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
				a = crossedEdgesList.getFirst();
				for(int j = 0; j < crossesWithFirst.size(); j++) {
					if(min>crossesWithFirst.get(j).size() && crossesWithFirst.get(j).size() > 1)
						min = crossesWithFirst.get(j).size();
				}
			}
			if(bestmin>min) {
				for(int i = 0; i< crossesWithFirst.size(); i++) {
					LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
					a = crossedEdgesList.getFirst();
					if(min == crossedEdgesList.size()) {
						for(int k = 1; k<crossedEdgesList.size(); k++) {
							b = crossedEdgesList.get(k);
							exchange(a,b);
						}
					}
				}
				crossesWithFirst.clear();
				findIntersection();
				bestmin = min;
			}
			else return;
		}
	}

	//alinea 4d
	static void randomNeighbor(int n) {

		Edge a,b; // (a.n1,a.n2)--->(b.n1,b.n2) edge  
		findIntersection();

		int count = 0; //if count = n no intersections and stop
		for(int i = 0; i < crossesWithFirst.size(); i++) 
			count += crossesWithFirst.get(i).size();

		if(count == n) return;
	
		int random;
		int size = crossesWithFirst.size();
		random = new Random().nextInt(size - 1) + 1 ;
		LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(random);
		a = crossedEdgesList.getFirst();
		for(int k = 1; k<crossedEdgesList.size(); k++) {
			b = crossedEdgesList.get(k);
			exchange(a,b);
		}
	}

	//End 4
	
	//5 -SIMULATED ANNELING
	// Calculate the acceptance probability
	static double acceptanceProbability(double energy, double newEnergy, double temperature) {
		// If the new solution is better, accept it
		if (newEnergy < energy) {
			return 1.0;
		}
		// If the new solution is worse, calculate an acceptance probability
		return Math.exp((energy - newEnergy) / temperature);

	}
	static int find(Edge a) {
		for(int i = 0; i<crossesWithFirst.size(); i++) {
			if (crossesWithFirst.get(i).get(0).n1.isEqual(a.n1) 
			 && crossesWithFirst.get(i).get(0).n2.isEqual(a.n2)) return i; 
		}
		return -1;
	}
	
	static void SA(int n) {

		 //best perimeter found
		// Set initial temp
		double temp = 100*poligono.size();
		// Cooling rate
		double coolingRate = poligono.size()*0.0001; 
		
		//Se já for simples
		findIntersection();
		int count = 0; //if count = n no intersections
		for(int i = 0; i < crossesWithFirst.size(); i++) 
			count += crossesWithFirst.get(i).size();
		if(count == n) return;
		
		int min = Integer.MAX_VALUE;
		int best = min;
		
		//Configuração inicial 
	
		Edge a,b; // (a.n1,a.n2)--->(b.n1,b.n2) edge 
		
		//Calcular todos
		for(int i = 0; i < crossesWithFirst.size(); i++) {
			LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
			a = crossedEdgesList.getFirst();
			for(int j = 0; j < crossesWithFirst.size(); j++) {
				if(min>crossesWithFirst.get(j).size() && crossesWithFirst.get(j).size() > 1) {
					min = crossesWithFirst.get(j).size();
				}
			}
		}
		
		best = min;
		crossesWithFirst.clear();
		findIntersection();
				
		// Loop until system has cooled
		while (temp > 1) {
			
			LinkedList<Node> poligonoteste = new LinkedList<Node>();
			
			//poligonoteste has a copy of poligono by creating new nodes
			Node copy;  	
			for(int i = 0;i < n ; i++) {
				copy = new Node(poligono.get(i).x, poligono.get(i).y);
				poligonoteste.add(copy);
			}
			int indexv = 0;
			int currentEnergy = best;
			int neighbourEnergy = 0;
			
			//random
			int rand = new Random().nextInt(n-1);
			for(int i=rand;i<crossesWithFirst.size();i++) {
				if(crossesWithFirst.get(i).size() >1) {
					neighbourEnergy = crossesWithFirst.get(i).size();
					indexv = i;
					break;
				}
			}
			
			// Decide if we should accept the neighbour
			double r = Math.random();				
			if (acceptanceProbability((double)currentEnergy, (double)neighbourEnergy, temp) > r) {
				LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(indexv);
				a = crossedEdgesList.getFirst();
				for(int k = 1; k<crossedEdgesList.size(); k++) {
					b = crossedEdgesList.get(k);
					exchange(a,b);
				}
				currentEnergy = crossesWithFirst.get(indexv).size();
			}
			
			crossesWithFirst.clear();
			findIntersection();
			// Keep track of the best solution found
			if (currentEnergy < best) {
				best = currentEnergy;
			}
			// Cool system
			temp *= 1-coolingRate; 
		}

	}
	
	//For testing purposes
	static void print(int n,LinkedList<Node> poligonoteste) {

		for(int i = 0; i<poligonoteste.size()-1; i++) {
			System.out.print(poligonoteste.get(i)+"->");
		}
		System.out.println(poligonoteste.getLast());
	}

	static void printIntersection() {

		for(int i = 0; i<poligono.size(); i++) {
			LinkedList<Edge> l = crossesWithFirst.get(i);
			Edge a = l.getFirst();
			System.out.println(a.n1+""+a.n2+" crosses with: ");
			for(int j = 1; j<l.size(); j++) {
				Edge b = crossesWithFirst.get(i).get(j);
				System.out.println(b.n1+""+b.n2+"");
			}
			System.out.println("--------------------");
		}
	}

	
	public static void main(String args[]) {

		int n,m;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		generate(n,m);
		permutation(n);
		//nearest(nodeArray[0],n);
		
		double sizeincrease = 1/m;
		
		int size = (int)((m)*sizeincrease);
		//findIntersection();
		//printIntersection();
		ite = 0;
		JFrame f = new JFrame("Representação gráfica dos poligonos");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawPolygon p = new DrawPolygon();
		p.set(size,size,n,sizeincrease,poligono);
		f.add(p);
		f.setSize(size,size);
		f.setVisible(true);
		if(in.next().equals("next")) f.setVisible( false );
		
		//findIntersection();
		//printIntersection();
		BIF(n);
		//fistImprovement(n);
		//lessIntersections(n);
		//randomNeighbor(n);
		//SA(n);
		//printIntersection();
		
		int tok = 0;
		for(int i = 0; i<crossesWithFirst.size(); i++) {
			if(crossesWithFirst.get(i).size() > 1) {
				System.out.println("False");
				tok = 1;
			}
		}
		if(tok == 0) System.out.println("true");
		
		p.set(size,size,n,sizeincrease,poligono);
		f.add(p);
		f.setSize(size,size);
		f.setVisible(true);
		if(in.next().equals("next")) f.setVisible( false );
		in.close();
		return;		

	}
}