import java.util.Scanner;
import java.util.Arrays;

public class daa010{

    public static int binarysearch(int[] v, int low, int high, int key){
        
        if(key>v[high]) return high;
        if(key<v[low]) return low;
        
        while(low < high){

            int middle = low + (high-low)/2;

            /*
            System.out.println("Key: "+key);
            System.out.println("low: v["+low+"]: "+v[low]);
            System.out.println("middle: v["+middle+"]: "+v[middle]);
            System.out.println("high: v["+high+"]: "+v[high]);
            System.out.println("--------------------------------");
			*/
            /*
            if(key-v[middle] == v[middle+1]-key){
                System.out.print(v[middle]+" ");
                low = middle + 1;
                return low;
            }*/

            if(key<v[middle]){
                if(key>v[middle-1]){
                    if(key-v[middle-1] == v[middle]-key){
                        System.out.print(v[middle-1]+" ");
                        return middle;
                    }
                    if(key-v[middle-1]<v[middle]-key){
                        return middle-1;
                    }
                    else if(key-v[middle-1]>v[middle]-key){
                        return middle;
                    }
                }
                high = middle;
            }
            else if(key>v[middle]){
                if(key<v[middle+1]){
                    if(key-v[middle] == v[middle+1]-key){
                        System.out.print(v[middle]+" ");
                        return middle+1;
                    }
                    if(key-v[middle]<v[middle+1]-key){
                        return middle;
                    }
                    else if(key-v[middle]>v[middle+1]-key){
                        return middle+1;
                    }
                }
                low = middle+1;
            }
            else return middle;

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

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int v[] = new int[n];

		for(int i = 0; i<n; i++) v[i] = in.nextInt();

		int k = 0;
		
		for(int i = 0; i<n-1; i++){
			for(int j = i+1; j<n; j++){
				k++;
			}
		}

		int[] somas = new int[k];
		k = 0;
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