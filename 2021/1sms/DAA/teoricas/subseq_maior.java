import java.util.Scanner;
import java.util.Arrays;

class subseq_maior{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] num = new int[n+1];

		for(int i = 1; i<=n; i++){
			num[i] = in.nextInt();
		}

		int[] best = new int[n+1];
		int[] next = new int[n+1];
		Arrays.fill(next,-1);

		best[0] = -2;
		best[n] = 1;
		next[0] = -2;
		next[n] = -1;
		int temp = 0;
		for(int i = n-1; i>=1; i--){
			best[i] = 1;
			for(int j = i+1; j<=n; j++){
				if(num[j] > num[i] && 1 + best[j] > best[i]){
					best[i] = 1 + best[j];
					next[i] = j;
					if(temp <= best[i]) temp = best[i]; 
				}
			}
		}

		int i = 0; 

		while(best[i]!=temp){
			i++;
		}

		while(next[i] != -1){
			System.out.print(" "+num[i]);
			//System.out.println(next[i]);
			i = next[i];
		}
		System.out.println(" "+num[i]);
	}
}