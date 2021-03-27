//package trabalhos;
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
	public String toString() {
		return "("+this.x+","+this.y+") -> ("+next.x+","+next.y+")\n";
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
	
	static int[][] map;
	static boolean[][] visitado;
	static LinkedList<Node> poligono = new LinkedList<Node>();
	static Node[] nodeArray; // use order in permutation method
	static ArrayList<LinkedList<Edge>> crossesWithFirst = new ArrayList<LinkedList<Edge>>(); //each list has list of intersected edges

	static int dir(Node n1, Node n2, Node i) {
		return (((n1.x - i.x)*(n2.y - i.y) - (n1.y - i.y)*(n2.x - i.x)));
	}
	
	static boolean onSeg(Node n1, Node n2, Node i) {
	
		return (((Math.min(n1.x,n2.x) < i.x) && (Math.max(n1.x,n2.x) > i.x)) 
				&&  ((Math.min(n1.y,n2.y) < i.y) && (Math.max(n1.y,n2.y) > i.y)));
	
	}
	
	static boolean isCollinear(Node n1, Node n2, Node n3) {
    	// Calculation the area of 
    	// triangle. We have skipped 
    	// multiplication with 0.5 
    	// to avoid floating point 
    	// computations 

    	int a = n1.x * (n2.y - n3.y) + 
    	        n2.x * (n3.y - n1.y) + 
    	        n3.x * (n1.y - n2.y);

    	//System.out.println(a);
    	if (a == 0) return true;
  		else return false;
		
	}


	static int dotProduct(Node n1, Node n2, Node n3, Node n4) {

		Node v1 = new Node(n2.x-n1.x,n2.y-n1.y);
		Node v2 = new Node(n4.x-n3.x,n4.y-n3.y);
		
		int res = v1.x*v2.x + v1.y*v2.y;
		//System.out.println("Produto escalar: "+res);
		return res;
	}
	
	
	static boolean intersect(Node n1, Node n2, Node n3, Node n4) {

		int d1,d2,d3,d4;
		d1 = dir(n3,n4,n1);
		d2 = dir(n3,n4,n2);
		d3 = dir(n1,n2,n3);
		d4 = dir(n1,n2,n4);
		if(isCollinear(n1,n2,n3) && isCollinear(n1,n2,n4) && dotProduct(n1,n2,n3,n4)<0) return true;
		if( ((d1>0 && d2<0) || (d1<0 && d2>0)) && 
			((d3>0 && d4<0) || (d3<0 && d4>0))) return true;

		else if(d1 == 0 && onSeg(n3,n4,n1)) return true;
		else if(d2 == 0 && onSeg(n3,n4,n2)) return true;
		else if(d3 == 0 && onSeg(n1,n2,n3)) return true;
		else if(d4 == 0 && onSeg(n1,n2,n4)) return true;
	
		else return false;

	}

	static void findIntersection() {

		for(int i = 0; i<poligono.size(); i++) {
			Node a = poligono.get(i);
			Node b = a.next;
			Edge n = new Edge(a,b,0);

			LinkedList<Edge> l = new LinkedList<Edge>();
			l.add(n);

			for(int j = i+1; j<poligono.size(); j++) {
				Node p = poligono.get(j);
				Node q = p.next;
				if(intersect(a,b,p,q)) {
					Edge ntemp = new Edge(p,q,0);
					l.add(ntemp);
				}

			}
			crossesWithFirst.add(l);
		}
	}
	static void exchange(Edge a, Edge b) {
		//necessario procurar cada no no poligono por causa dos next de pair a e pair b que sao null
		 //(ind1--> ind2)   (ind3-->ind4)
		int ind1=-1, ind2=-1, ind3=-1, ind4=-1;
		for(int i=0;i<poligono.size();i++) {
			Node aux=poligono.get(i);
			if(aux.x == a.n1.x && aux.y ==a.n1.y) {ind1=i;}
			if (aux.x == a.n2.x && aux.y ==a.n2.y) {ind2=i;}
			if (aux.x == b.n1.x && aux.y ==b.n1.y) {ind3=i;}
			if (aux.x == b.n2.x && aux.y ==b.n2.y) {ind4=i;}
		
		}
		
		if((isCollinear(a.n1,a.n2,b.n1) || isCollinear(a.n1,a.n2,b.n2)) && (dotProduct(a.n1,a.n2,b.n1,b.n2)<0)) {
            poligono.get(ind3).next = poligono.get(ind4).next;
            poligono.get(ind1).next = poligono.get(ind4);
            poligono.get(ind4).next = poligono.get(ind3);
        }
		else {
			poligono.get(ind3).next = poligono.get(ind2);
			poligono.get(ind1).next = poligono.get(ind3);
			poligono.get(ind2).next = poligono.get(ind4);
		}
		
	}
		
		//HILL CLIMBING
	//alinea a:best improvement first 
	static void BIF(int n) {
		
		Edge a,b; // (a.n1,a.n2)--->(b.n1,b.n2) edge  
		findIntersection();
		//verify if we have a poligono without intersections and stop
		int count=0; //if count=n no intersections
		for(int i=0;i<crossesWithFirst.size();i++) 
			count +=crossesWithFirst.get(i).size();
		if(count ==n)
			return;
		while(count>n) {
			for(int i=0;i<crossesWithFirst.size();i++) {
				LinkedList<Edge> crossedEdgesList=crossesWithFirst.get(i);
				TreeSet<Edge> crossedEdgesOrder = new TreeSet<>(); //ordem ascendente
				a=crossedEdgesList.getFirst();
				
				//for each crossed edge with (a.n1,a.n1)
				for(int j=1;j<crossedEdgesList.size();j++) {
					b=crossedEdgesList.get(j);
					double edge1 = calcEdges(a.n1,b.n1);
					double edge2 = calcEdges(a.n2,b.n2);
					Edge aux = new Edge(b.n1, b.n2, (edge1 + edge2));
					crossedEdgesOrder.add(aux);
				}
				if( crossedEdgesOrder.size()>0) {
					Edge best = crossedEdgesOrder.first();
					exchange(a, best);
				}
				
				
				System.out.println("perimeter" +perimeter(poligono));
				crossesWithFirst.clear();
				findIntersection();
				//verify if we have a poligono without intersections and stop
				 count=0; //if count=n no intersections
				for(int k=0;k<crossesWithFirst.size();k++) 
					count +=crossesWithFirst.get(k).size();
				if(count == n)
					return;
			}
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
		Node a =  poligono.get(0); //1st too
		Node b = a.next;
		Node c=null;
		while(c!= first) {
			sum += Math.sqrt(Math.pow((a.x - b.x), 2) +  Math.pow((a.y - b.y),2));
			a = b;
			b = b.next;
			c=a;
		}
			
		return sum;
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
			//System.out.println("FI_trying");
			for(int i = 0; i <crossesWithFirst.size(); i++) {
				LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
				a = crossedEdgesList.getFirst();

				//for each crossed edge with (a.n1,a.n1)
				for(int j = 1; j < crossedEdgesList.size(); j++) {
					b = crossedEdgesList.get(j);
					exchange(a,b);
				}

				crossesWithFirst.clear();
				findIntersection();
				count=0; //if count=n no intersections
				for(int k=0;k<crossesWithFirst.size();k++) 
					count += crossesWithFirst.get(k).size();
				if(count == n)
					return;
			}
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
		//System.out.println(count+":"+n);
		if(count == n) return;
		while(count>n) {
			int min = Integer.MAX_VALUE;
			//System.out.println("LI_trying");
			for(int i = 0; i < crossesWithFirst.size(); i++) {
				if(min>crossesWithFirst.get(i).size() && crossesWithFirst.get(i).size() > 1) min = crossesWithFirst.get(i).size();
			}

			for(int i = 0; i < crossesWithFirst.size(); i++) {
				LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(i);
				a = crossedEdgesList.getFirst();

				if(min == crossedEdgesList.size()) {
					for(int j = 1; j < crossedEdgesList.size(); j++) {
						b = crossedEdgesList.get(j);
						exchange(a,b);
					}
				}
			}

			crossesWithFirst.clear();
			findIntersection();
			count=0; //if count=n no intersections
			for(int k = 0; k<crossesWithFirst.size(); k++) 
				count += crossesWithFirst.get(k).size();
			if(count == n)
				return;
		}
	}
	//alinea 4d
	static void randomNeighbor(int n) {
		
		findIntersection();
		for(int i=0;i<crossesWithFirst.size();i++)
			Collections.shuffle(crossesWithFirst.get(i)); 
		fistImprovement(n);
	}
	
	//5 -SIMULATED ANNELING
	
	static void exchangeForSA(Edge a, Edge b, LinkedList<Node> poligono2) {
		//necessario procurar cada no no poligono por causa dos next de pair a e pair b que sao null
		 //(ind1--> ind2)   (ind3-->ind4)
		int ind1=-1, ind2=-1, ind3=-1, ind4=-1;
		for(int i=0;i<poligono2.size();i++) {
			Node aux=poligono2.get(i);
			if (aux.x == a.n1.x && aux.y == a.n1.y) {ind1=i;}
			if (aux.x == a.n2.x && aux.y == a.n2.y) {ind2=i;}
			if (aux.x == b.n1.x && aux.y == b.n1.y) {ind3=i;}
			if (aux.x == b.n2.x && aux.y == b.n2.y) {ind4=i;}
		
		}
		
		poligono2.get(ind1).next=poligono2.get(ind3);
		poligono2.get(ind2).next=poligono2.get(ind4);
		poligono.get(ind3).next=poligono.get(ind2);
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
        double temp = 10000;
        // Cooling rate
        double coolingRate = 0.003; 
         LinkedList<Node> poligono2 = new LinkedList<Node>();
         //poligono2 has a copy of poligono
        for(int i=0;i<poligono.size();i++) 
        	poligono2.add(poligono.get(i));
        
	 // Loop until system has cooled
        while (temp > 1) {
        	
        	findIntersection();
        	Collections.shuffle(crossesWithFirst);
    		for(int i=0;i<crossesWithFirst.size();i++)
    			Collections.shuffle(crossesWithFirst.get(i));
    		Edge a,b; // (a.n1,a.n2)--->(b.n1,b.n2) edge  
    		//verify if we have a poligono without intersections and stop
    		int count = 0; //if count = n no intersections
    		for(int i = 0; i < crossesWithFirst.size(); i++) 
    			count += crossesWithFirst.get(i).size();
    		
    		if(count == n) return;
    		
    			//random
    		LinkedList<Edge> crossedEdgesList = crossesWithFirst.get(0);
    		a = crossedEdgesList.get(0);
    		b = crossedEdgesList.get(1);
    		exchangeForSA(a,b, poligono2); //test exchange poligono2
    		
    		crossesWithFirst.clear();
    		findIntersection();
    
    			
    			// Get energy of solutions
            Double currentEnergy = perimeter(poligono);
            Double neighbourEnergy = perimeter(poligono2);

                // Decide if we should accept the neighbour
                if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                    exchange(a,b);
                }

             /*   // Keep track of the best solution found
                if (currentEnergy < best) {
                    best = currentEnergy;
                }
                */
                // Cool system
                temp *= 1-coolingRate; 
            
    		}	
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
	
	static void print(int n) {
		
		int i = 0;
		System.out.println("");
		System.out.print(poligono.getFirst()+"->");
		Node temp = poligono.getFirst().next;
		for(i = 0; i<n-2; i++) {
			System.out.print(temp+"->");
			temp = temp.next;
		}
		System.out.print(temp);
		System.out.println("");
		System.out.println("");
	}
	
	public static void main(String args[]) {
		int n,m;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		map = new int[m+1][m+1];
		visitado = new boolean[m+1][m+1];
		nodeArray = new Node[n];
		//generate(n,m);
		//permutation(n);
		//BIF(n);
		//System.out.println("final perimeter" +perimeter(poligono));
		//NNfirst(start, n,  m);
		
		
			

				
		//PARA TESTAR
		Node n1 = new Node (-2,3);
		nodeArray[0] = n1;
		Node n2 = new Node (3,3);
		nodeArray[1] = n2;
		Node n3 = new Node (1,3);
		nodeArray[2] = n3;
		Node n4 = new Node (-1,0);
		nodeArray[3] = n4;
		permutation(n);
		int i=0;

		dotProduct(n1,n2,n2,n3);
		print(n);
		BIF(n);
		System.out.println("apos descruzar:");
		print(n);
		System.out.println("final perimeter: " +perimeter(poligono));
		

	}

}