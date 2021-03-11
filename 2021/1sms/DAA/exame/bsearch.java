import java.util.*;

class bsearch{

	public static int bs(int key,int low,int high,int[] v){
		
		if(key < v[low]) return low;
		if(key > v[high]) return high;

		int middle = low + (high - low)/2, count = 0;

		//System.out.println("key: "+key+"; low: "+low+"; high: "+high+"; middle: "+middle);

		while (low <= high) {
            int mid = low + (high - low)/2;

            if (key < v[mid]) high = mid - 1;
            else if (key > v[mid]) low = mid + 1;
            else return mid;
        }

        //Afunila para um intervalo [l,h] e escolhe o mais próximo
        if((v[low] - key) < (key - v[high])) return low; 
        else if((v[low] - key) < (key - v[high])) return high;

        //Imprimir os dois mais próximos
        else {
        	System.out.print(v[low]+" ");
        	return high;
        }
	}

	public static void main(String[] args) {
		int[] n = {0,3,11,13,20};
		System.out.println(n[bs(12,0,n.length-1,n)]);
	}
}