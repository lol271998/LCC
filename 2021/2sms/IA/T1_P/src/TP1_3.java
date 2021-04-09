package trabalhos;
import java.util.*;
import java.lang.*;
import java.awt.Graphics;
import javax.swing.*;

class Node {

	int x,y;

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

public class TP1 {

	static HashMap<Node, Boolean> map = new HashMap<>();
	static LinkedList<Node> poligono = new LinkedList<Node>();
	static Node[] nodeArray; // use order in permutation method
	static ArrayList<LinkedList<Edge>> crossesWithFirst = new ArrayList<LinkedList<Edge>>(); //each list has list of intersected edges


	//1 
	static void generate(int n , int m) {
		
		for(int i=0;i<n;i++) {
			
			int x = new Random().nextInt(m +m) -m ;
			int y = new Random().nextInt(m+m ) -m ;
			Node no = new Node(x,y);
			//if already exists
			if(map.containsKey(no)) i--;
			
			else {
	
				map.put(no, false);
				nodeArray[i] = no;
			}
		}
	}

	//2 a)

	static void permutation(int n){
		for(int i = 0;i <n ; i++) poligono.add(nodeArray[i]);
	}



	//2 b)

	//euclidian distance, return nearest node from 'no'
	static Node nearest(Node no, int n) {
		int min = Integer.MAX_VALUE; 
		int dist=-1, a = 0,b = 0;
		Node near=no;
		for(int i=0;i<n;i++) {
				
				if( !poligono.contains(nodeArray[i])) {
					dist = (int) Math.sqrt(Math.pow((no.x - nodeArray[i].x),2) +  Math.pow((no.y - nodeArray[i].y),2));
					if(min > dist) {
						min = dist;
						a = nodeArray[i].x; b = nodeArray[i].y;
					}
				}
			}
		for(int i=0;i<n;i++) {
			if(nodeArray[i].x==a && nodeArray[i].y==b)
				near=nodeArray[i];
		}
		
		return near;
	}

	static void NNfirst(Node start, int n, int m){
		
		
		int count = n;
		Node aux;
		poligono.add(start);
		map.replace(start, false, true);
		while(count > 1) {
			aux = nearest(start,n);
			poligono.add(aux);
			aux = start;
			count--;
		}
	}

	

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

		int d1,d2,d3,d4;

		d1 = dir(n1,n2,n3);
		
		if(d1 == 0 && dotProduct(n1,n2,n2,n3)<0) return true;
		else return false;

	}

	static boolean intersect(Node n1, Node n2, Node n3, Node n4) {

		int d1,d2,d3,d4;

		d1 = dir(n1,n2,n3); //d3
		d2 = dir(n1,n2,n4); //d4
		d3 = dir(n3,n4,n1); //d1
		d4 = dir(n3,n4,n2); //d2


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
				//pos = i+1;
				b = poligono.get(i+1);
			}
			
			
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
					//(ax,ay)-(bx,by) <-> (px,py)-(qx,qy)
					
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
		
		Edge a,b; // (a.n1,a.n2)--->(b.n1,b.n2) edge  
		findIntersection();
		//verify if we have a poligono without intersections and stop
		int count = 0; //if count=n no intersections
		for(int i = 0; i<crossesWithFirst.size(); i++) 
			count += crossesWithFirst.get(i).size();
		if(count == n) 
			return;
	
		while(count>n) {
			for(int i=0;i<crossesWithFirst.size();i++) {
				LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
				TreeSet<Edge> crossedEdgesOrder = new TreeSet<>(); //ordem ascendente
				a = crossedEdgesList.getFirst();
				
				//for each crossed edge with (a.n1,a.n1)
				for(int j = 1; j<crossedEdgesList.size(); j++) {
					b = crossedEdgesList.get(j);
					double edge1 = calcEdges(a.n1,b.n1);
					double edge2 = calcEdges(a.n2,b.n2);
					Edge aux = new Edge(b.n1, b.n2, (edge1 + edge2));
					crossedEdgesOrder.add(aux);
				}
				if( crossedEdgesOrder.size()>0) {
					Edge best = crossedEdgesOrder.first();
					exchange(a, best);
					
					crossesWithFirst.clear();
					findIntersection();
					i=0;
					
				}
					
				
				//verify if we have a poligono without intersections and stop
				count=0; //if count=n no intersections
				
				for(int k=0;k<crossesWithFirst.size();k++) 
					count += crossesWithFirst.get(k).size();
				if(count == n)
					return;
			}
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
			//System.out.println(count+":"+n);
			if(count == n) return;
		
			while(count>n) {	
				for(int i = 0; i <crossesWithFirst.size(); i++) {
					LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
					a = crossedEdgesList.getFirst();
					if(crossedEdgesList.size() > 1) {
						b = crossedEdgesList.get(1);
						exchange(a,b);
						
						crossesWithFirst.clear();
						findIntersection();
						i = 0;
					}
				}
				count=0; //if count=n no intersections
				for(int k=0;k<crossesWithFirst.size();k++) 
					count += crossesWithFirst.get(k).size();
				if(count == n)	return;
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
			while(count>n) {

				for(int i = 0; i < crossesWithFirst.size(); i++) {
					LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
					a = crossedEdgesList.getFirst();
					int min = Integer.MAX_VALUE;
					for(int j = 0; j < crossesWithFirst.size(); j++) {
						if(min>crossesWithFirst.get(j).size() && crossesWithFirst.get(j).size() > 1)
							min = crossesWithFirst.get(j).size();
					}
					if(min == crossedEdgesList.size()) {
						b = crossedEdgesList.get(1);
						exchange(a,b);
						crossesWithFirst.clear();
						findIntersection();
						i = 0;
					}

				
					count=0; //if count=n no intersections
					for(int k = 0; k<crossesWithFirst.size(); k++) 
						count += crossesWithFirst.get(k).size();
					if(count == n)
						return;
				}
				
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

		while(count>n) {	
			int random;
			for(int i = 0; i <crossesWithFirst.size(); i++) {
				LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
				a = crossedEdgesList.getFirst();
				int size=crossedEdgesList.size();
				if(size > 1) {
					random=  new Random().nextInt(size - 1) + 1 ;

					b = crossedEdgesList.get(random) ;
					exchange(a,b);
					crossesWithFirst.clear();
					findIntersection();
					i = 0;
				}
			}
			count=0; //if count=n no intersections
			for(int k=0;k<crossesWithFirst.size();k++) 
				count += crossesWithFirst.get(k).size();
			if(count == n)	return;
		}
		
	}

	//End 4

	//5 -SIMULATED ANNELING
	
	static void exchangeForSA(Edge a, Edge b, LinkedList<Node> poligono2) {
		
		int ind1=0,ind2=0,ind3=0,ind4=0;
		int i = 0;
		for(i = 0;i<poligono2.size();i++) {
			Node aux = poligono2.get(i);
			if (aux.x == a.n1.x && aux.y == a.n1.y) {ind1=i;}
			if (aux.x == a.n2.x && aux.y == a.n2.y) {ind2=i;}
			if (aux.x == b.n1.x && aux.y == b.n1.y) {ind3=i;}
			if (aux.x == b.n2.x && aux.y == b.n2.y) {ind4=i;}
			
		}

		if(ind4 == poligono2.size()-1) ind4 = 0;
		if(ind1 == poligono2.size()-1) ind1 = 0;


		if(isCollinear(a.n1,a.n2,b.n1)) {

			Node n5 = poligono2.get(ind4+1);
			poligono2.remove(ind4);
			poligono2.add(ind1+1,b.n2);

		}
		else{
			poligono2.add(ind2,b.n1);
            poligono2.remove(ind2 +1);
            poligono2.add(ind3,a.n2);
            poligono2.remove(ind3+1);
		}		
	}
	// Calculate the acceptance probability
	static double acceptanceProbability(double energy, double newEnergy, double temperature) {
	        // If the new solution is better, accept it
	        if (newEnergy < energy) {
	            return 1.0;
	        }
	        // If the new solution is worse, calculate an acceptance probability
	        return Math.exp((energy - newEnergy) / temperature);
	
	}
	
	static void SA(int n) {
		
		double best=perimeter(poligono); //best perimeter found
		// Set initial temp
        double temp = 9999;
        // Cooling rate
        double coolingRate = 0.003; 
         LinkedList<Node> poligono2 = new LinkedList<Node>();
         //poligono2 has a copy of poligono by creating new nodes
         Node copy;  	
		for(int i = 0;i < n ; i++) {
			copy=new Node(poligono.get(i).x, poligono.get(i).y);
			poligono2.add(copy);
			
		}
		
    	int found=0; //indice of a crossed edge random
	 // Loop until system has cooled
        while (temp > 1) {
        	
        	findIntersection();
    		Edge a,b; // (a.n1,a.n2)--->(b.n1,b.n2) edge  
    		int count = 0; //if count = n no intersections
    		for(int i = 0; i < crossesWithFirst.size(); i++) 
    			count += crossesWithFirst.get(i).size();
    		
    		if(count == n) return;
    		
    			//random
    		int rand= new Random().nextInt(n-1) ;
    		for(int i=rand;i<crossesWithFirst.size();i++) {
    			if(crossesWithFirst.get(i).size() >1) {
    				found=i;
    				break;
    			}
    					
    		}
    		if(crossesWithFirst.get(found).size() > 1) {
    			LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(found);		
        		a = crossedEdgesList.get(0);
        		b = crossedEdgesList.get(1);
        		exchangeForSA(a,b, poligono2); //test exchange poligono2
        		// Get energy of solutions
                Double currentEnergy = perimeter(poligono);
                Double neighbourEnergy = perimeter(poligono2);
            		
	            // Decide if we should accept the neighbour
	            if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) 
	                exchange(a,b);
	          
	          
	            crossesWithFirst.clear();
        		findIntersection();
        		for(int i = 0;i < n ; i++) {
        			copy=new Node(poligono.get(i).x, poligono.get(i).y);
        			poligono2.add(copy);
        			
        		}
	               // Keep track of the best solution found
                if (currentEnergy < best) {
                    best = currentEnergy;
                }
    		}

              
                // Cool system
                temp *= 1-coolingRate; 

    		}
		
	}

	//For testing purposes
	static void print(int n) {
		
		for(int i = 0; i<poligono.size()-1; i++) {
			System.out.print(poligono.get(i)+"->");
		}
		System.out.println(poligono.getLast());
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
		nodeArray = new Node[n];
		generate(n,m);
		permutation(n);
		
		// DESENHAR POLIGONO
				double sizeincrease;
		        	if(m>30) sizeincrease = 0.8;
		        	else sizeincrease = 15;
		        	int size = (int)(m*sizeincrease);
		
		JFrame f = new JFrame("Representação gráfica dos poligonos");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawPolygon p = new DrawPolygon();
		p.set(size,size,n,sizeincrease,poligono);
		f.add(p);
		f.setSize(size,size);
		f.setVisible(true);
		if(in.next().equals("next")) f.setVisible( false );

	//ALGORITMOS:
		//NNfirst(n1 ,n, m);
		//print(n);
		//BIF(n);
		//print(n);
		//fistImprovement(n);
		//print(n);
		//lessIntersections(n);
		//print(n);
		//randomNeighbor(n);
		//print(n);
		//SA(n);
		//print(n);
		
		
		p.set(size,size,n,sizeincrease,poligono);
		f.add(p);
		f.setSize(size,size);
		f.setVisible(true);
		if(in.next().equals("next")) f.setVisible( false );

		in.close();
		return;	
		
		
	

	}
}