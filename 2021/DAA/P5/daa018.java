import java.util.Arrays;
import java.util.Scanner;

public class daa018{

	public static void troco(int[] s, int k){

		int[] coins = new int[k+1];
		int[] used = new int[k+1];
		used[0] = -1;
		Arrays.fill(coins,k+1);
		coins[0] = 0;

		int count = 0;
		
		int first = s[0];
		for(int i = 1; i<=k; i++){
			for(int j = 0; j<s.length; j++){
				if(s[j]<=i && (1 + coins[i-s[j]] < coins[i])){
					coins[i] = Math.min(coins[i-s[j]]+1,coins[i]);
					used[i] = s[j];
				}
			}
		}

		System.out.print(k+": ["+coins[k]+"]");
		int i = k;
		while(i!=0){
			System.out.print(" "+used[i]);
			int temp = i;
			i-=used[temp];
		}	
		System.out.println();
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] c = new int[n];

		for(int i = 0; i<n; i++){
			c[i] = in.nextInt();
		}

		int t = in.nextInt();

		for(int i = 0; i<t; i++){
			troco(c,in.nextInt());
		}
		
	}
}