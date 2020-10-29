import java.util.Scanner;
import java.util.Arrays;

public class daa010TEST{
    
    public static int binarysearch(int[] v, int low, int high, int key){
        
        if(key>v[high]) return high;
        if(key<v[low]) return low;
        
        while(low < high){

            int middle = low + (high-low)/2;
            
            System.out.println("Key: "+key);
            System.out.println("low: v["+low+"]: "+v[low]);
            System.out.println("middle: v["+middle+"]: "+v[middle]);
            System.out.println("high: v["+high+"]: "+v[high]);
            System.out.println("--------------------------------");       

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
  
            System.out.println("Key: "+key);
            System.out.println("low: v["+low+"]: "+v[low]);
            System.out.println("middle: v["+middle+"]: "+v[middle]);
            System.out.println("high: v["+high+"]: "+v[high]);
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");
            
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

        int[] v =  {12,3,17,5,34,33};
        int n = v.length;
        int nPairs = fact(n)/(2*(fact(n-2)));
        int[] somas = new int[nPairs];
        int k = 0;

        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){ 
                somas[k] = v[i]+v[j];
                k++;
            }
        }

        System.out.println("");

        Arrays.sort(somas);

        for(int i = 0; i<k; i++){
            if(i == 0)System.out.print("{"+somas[i]);
            else if(i==k-1) System.out.print(","+somas[i]+"}");
            else System.out.print(","+somas[i]);
        }

        System.out.println("");

        int[] q = {51};
        
        for(int i = 0; i<1; i++){

            int a = binarysearch(somas,0,k-1,41);
            System.out.println(somas[a]);
        }

    }
}