import java.util.Arrays;
import java.util.Scanner;

class Pair implements Comparable<Pair>{
	public int first;
	public int last;
   
   	Pair(int f, int l) {
    	first = f;
    	last = l;
   	}

   	@Override
	public int compareTo(Pair p){
		if(first>p.first) return +1;
		if(first<p.first) return -1;
		else return 0;
	}

   	public String toString() {
   	   return "(" + first + "," + last + ")";
   	}
}

public class daa013{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int m = in.nextInt();
  
		int np = in.nextInt();

		Pair[] s = new Pair[np];
		
		for(int i = 0; i<np; i++){
			Pair p = new Pair(in.nextInt(),in.nextInt());
			s[i] = p;
			//System.out.println(p);
		}

		Arrays.sort(s);

		int end = 0, i = 0, count = 0;

		while(end<m){
			if(s[i].first<=end){
				//System.out.println("s["+i+"]: "+s[i]);
				int j = i+1;
				int tmp = s[i].last;
				while(j<np && s[j].first<=end){
					if(tmp<s[j].last){
						tmp = s[j].last;
					}
					j++;
				}
				end = tmp;
				count++;
			}
			i++;
		}

		System.out.println(count);
	}
}