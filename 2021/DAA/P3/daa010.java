import java.util.Scanner;
import java.util.Arrays;

class BinarySearch{

	public int vec[];
	public int low;
	public int high;
	public int key;


	BinarySearch(int[] v, int l, int h, int k){

		vec = v;
		low = l;
		high = h;
		key = k;
	}

	int BS(int[] v, int l, int h, int k){
		while(low<=high){
			int middle = low+(high-low)/2;
			//Se encontrou o valor
			if(key == v[middle]) return middle;
			
			//Divide o array em 2 e procura ou para esq ou para a dir
			else if(key< v[middle]) high = middle - 1;
			else low = middle + 1;
		}
		return -1;
	} 
}

class Pair{
		
	public int pair_1;
	public int pair_2;
	public int soma;

	Pair(int p1, int p2){
		pair_1 = p1;
		pair_2 = p2;
	}
}

public class daa010{

	public static int fact(int n){
		int res = 1;

		for(int i = n-1; i>0; i--){
			res=res*n;
			n--;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int v[] = new int[n];
		int nPairs = fact(n)/(2*(fact(n-2)));
		Pair p[] = new Pair[nPairs];
		int somas[] = new int[nPairs];

		for(int i = 0; i<n; i++){
			v[i] = in.nextInt();
		}

		int k = 0;

		for(int i = 0; i<n-1; i++){
			for(int j = i+1; j<n; j++){
				p[k] = new Pair(v[i],v[j]);
				somas[k] = v[i]+v[j];
				//System.out.println("("+p[k].pair_1+","+p[k].pair_2+") = "+somas[k]);
				k++;
			}
		}

		Arrays.sort(somas);

		int q = in.nextInt();
		for(int i = 0; i<q; i++){

		}

	}
}