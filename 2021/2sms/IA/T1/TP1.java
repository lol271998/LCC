
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
		return "("+this.x+","+this.y+")\n";
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
		//(ni-n1)*(n2-n1)
		//p1xp2 = x1y2-x2y1
		Node ni = new Node(i.x-n1.x,i.y-n1.y);
		Node nj = new Node(n2.x-n1.x,n2.y-n1.y);

		int d = (ni.x*nj.y) - (nj.x*ni.y);

		return d;
	}
	
	static boolean onSeg(Node n1, Node n2, Node i) {
	
		return (((Math.min(n1.x,n2.x) <= i.x) && (Math.max(n1.x,n2.x) >= i.x)) 
				&&  ((Math.min(n1.y,n2.y) <= i.y) && (Math.max(n1.y,n2.y) >= i.y)));
	
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
			System.out.println("a: "+a);
			System.out.println("b: "+b);
			for(int j = i+1; j<poligono.size(); j++) {
				Node p = poligono.get(j);
				System.out.println("p: "+p);
				Node q = p.next;
				System.out.println("q: "+q);
				if(j == i+1 && dotProduct(a,b,b,p) < 0) {
					Edge ntemp = new Edge(b,q,0);
					l.add(ntemp);
				}
				else if(intersect(a,b,p,q)) {
					Edge ntemp = new Edge(p,q,0);
					l.add(ntemp);
				}
			}
			crossesWithFirst.add(l);
		}
	}
	
	
	static void exchange(Edge a, Edge b) {
		
		//(ind1--> ind2)   (ind3-->ind4)
		int ind1=-1, ind2=-1, ind3=-1, ind4=-1;
		for(int i=0;i<poligono.size();i++) {
			Node aux=poligono.get(i);
			if (aux.x == a.n1.x && aux.y == a.n1.y) {ind1=i;}
			if (aux.x == a.n2.x && aux.y == a.n2.y) {ind2=i;}
			if (aux.x == b.n1.x && aux.y == b.n1.y) {ind3=i;}
			if (aux.x == b.n2.x && aux.y == b.n2.y) {ind4=i;}
		
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
		//HILL CLIMBING
	//best improvement first 
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
	static Double perimeter(LinkedList<Node> pol) {
		double sum = 0;
		Node first = pol.get(0); //first
		Node a =  pol.get(0); //1st too
		Node b = a.next;
		Node c=null;
		while(c!= first) {
			sum += Math.sqrt( Math.pow((a.x - b.x), 2) +  Math.pow((a.y - b.y),2) );
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
		int h = 0;
		for(int i = 0; i < crossesWithFirst.size(); i++) 
			count += crossesWithFirst.get(i).size();
		//System.out.println(count+":"+n);
		if(count == n) return;
		while(count>n || h != 1) {
			int min = Integer.MAX_VALUE;
			System.out.println("LI_trying");
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
			h++;
			if(h == 1) return;
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
		
		 //(ind1--> ind2)   (ind3-->ind4)
			int ind1=-1, ind2=-1, ind3=-1, ind4=-1;
			for(int i=0;i<poligono2.size();i++) {
				Node aux=poligono2.get(i);
				if(aux.x == a.n1.x && aux.y ==a.n1.y) {ind1=i;}
				if (aux.x == a.n2.x && aux.y ==a.n2.y) {ind2=i;}
				if (aux.x == b.n1.x && aux.y ==b.n1.y) {ind3=i;}
				if (aux.x == b.n2.x && aux.y ==b.n2.y) {ind4=i;}
			
			}
			
			if((isCollinear(a.n1,a.n2,b.n1) || isCollinear(a.n1,a.n2,b.n2)) && (dotProduct(a.n1,a.n2,b.n1,b.n2)<0)) {
	           poligono2.get(ind3).next = poligono2.get(ind4).next;
	           poligono2.get(ind1).next = poligono2.get(ind4);
	           poligono2.get(ind4).next = poligono2.get(ind3);
	       }
			else {
				poligono2.get(ind3).next = poligono2.get(ind2);
				poligono2.get(ind1).next = poligono2.get(ind3);
				poligono2.get(ind2).next = poligono2.get(ind4);
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
			copy=new Node(nodeArray[i].x, nodeArray[i].y);

			poligono2.add(copy);
			if(i > 0)
				poligono2.get(i-1).next = copy;			
			
		}
		//conect first and last
		poligono2.getLast().next = poligono2.getFirst();		


        	
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
	               // Keep track of the best solution found
                if (currentEnergy < best) {
                    best = currentEnergy;
                }
    		}

              
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
		for(int i = 0 ;i <= m; i++) {
			for(int j = 0; j <=m; j++) {
			 map[i][j] = 0;
			 visitado[i][j] = false;
			}
		}
										
		for(int i=0;i<n;i++) {
			
			int x = new Random().nextInt(m ) ;
			int y = new Random().nextInt(m ) ;
			
			//if already exists
			if(map[x][y]==1) i--;
			
			else {
				map[x][y]=1;	
				Node no = new Node(x,y);
				nodeArray[i] = no;
			}
		}
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
		map = new int[m+1][m+1];
		visitado = new boolean[m+1][m+1];
		nodeArray = new Node[n];
		//generate(n,m);
		//permutation(n);
		//BIF(n);
		//System.out.println("final perimeter" +perimeter(poligono));
		//NNfirst(start, n,  m);
		
		
			

				
		Node n1 = new Node (2,0);//a
        nodeArray[0] = n1;
        Node n2 = new Node (-6,0);//b
        nodeArray[1] = n2;
        Node n3 = new Node (6,6); //c
        nodeArray[2] = n3;
        Node n4 = new Node (10,0); //d
        nodeArray[3] = n4;

        Node n5 = new Node (6,-6); //E
        nodeArray[4] = n5;
        Node n6 = new Node (-4,4); //F
        nodeArray[5] = n6;
        Node n7 = new Node (0,8); //g
        nodeArray[6] = n7;
        Node n8 = new Node (-2,2); //h
        nodeArray[7] = n8;

		permutation(n);
		findIntersection();
		printIntersection();

		/*
		dotProduct(n1,n2,n2,n3);
		print(n);
		lessIntersections(n);
		System.out.println("apos descruzar:");
		print(n);
		System.out.println("final perimeter: " +perimeter(poligono));
		*/

	}

}