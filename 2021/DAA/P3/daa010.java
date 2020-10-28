import java.util.Scanner;
import java.util.Arrays;

public class daa010{

    public static int binarysearch(int[] v, int low, int high, int key){
        
        if(key>v[high]) return high;
        if(key<v[low]) return low;
        
        while(low < high){

            int middle = low + (high-low)/2;

            if(v[low] == key) return low;
            if(v[middle] == key) return middle;
            if(v[high] == key) return high;

            /*
            System.out.println("Key: "+key);
            System.out.println("low: v["+low+"]: "+v[low]);
            System.out.println("middle: v["+middle+"]: "+v[middle]);
            System.out.println("high: v["+high+"]: "+v[high]);
            System.out.println("--------------------------------");
			*/
            if(key-v[middle] == v[middle+1]-key){
                System.out.print(v[middle]+" ");
                low = middle + 1;
                return low;
            }
            
            if(Math.abs(key-v[low]) > Math.abs(key-v[middle])) low = middle+1;
            else if(Math.abs(key-v[low]) <= Math.abs(key-v[middle])){
                if(Math.abs(key-v[low])>Math.abs(key-v[high])) return high;
                else high = middle+1;
            }

            /*
            System.out.println("Key: "+key);
            System.out.println("low: v["+low+"]: "+v[low]);
            System.out.println("middle: v["+middle+"]: "+v[middle]);
            System.out.println("high: v["+high+"]: "+v[high]);
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            */
        }
        return low;
    }


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
		int somas[] = new int[nPairs];

		for(int i = 0; i<n; i++) v[i] = in.nextInt();

		int k = 0;

		for(int i = 0; i<n-1; i++){
			for(int j = i+1; j<n; j++){	
				somas[k] = v[i]+v[j];
				k++;
			}
		}
		
		Arrays.sort(somas);

		int q = in.nextInt();
		for(int i = 0; i<q; i++){
			int qnum = in.nextInt();
			int a = binarysearch(somas,0,k-1,qnum);
			System.out.println(somas[a]);
		}

	}
}