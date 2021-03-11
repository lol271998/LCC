import java.util.Scanner;
import java.util.Arrays;

class Pair implements Comparable<Pair>{
	public int day;
	public double ratio;
   
   	Pair(int d, double r) {
    	day = d;
    	ratio = r;
   	}

   	@Override
	public int compareTo(Pair p){
		if(ratio>p.ratio) return +1;
		if(ratio<p.ratio) return -1;
		else return 0;
	}

   	public String toString() {
   	   return day + ": " + ratio;
   	}
}

class daa014{
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		
		Pair[] l = new Pair[n];

		for(int i = 0; i<n; i++){
			
			int d = in.nextInt();
			int m = in.nextInt();
			double r = ((d*1.0)/(m*1.0));
			
			Pair p = new Pair(i+1,r);

			l[i] = p;
		}

		Arrays.sort(l);

		for(int i = 0; i<n; i++){
			if(i == n-1) System.out.println(l[i].day);
			else System.out.print(l[i].day+" ");
		}
	}
}