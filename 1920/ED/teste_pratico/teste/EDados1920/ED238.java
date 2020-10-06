import java.util.Scanner;

public class ED238{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int inc = 0; 
		int max = 0;
		int flag = 0;
		int[] num = new int[n];
		String line = in.next();
		for(int i = 0; i<n; i++){
			num[i] = line.charAt(i) -'0';
			if(num[i] == 1){
				inc++;
			}
			else{
				if(inc>=max){
					max = inc;
					flag = i;
				}
				inc = 0;
			}
		}
		int k = in.nextInt();
		int[] knum = new int[k];
		for(int i = 0; i<k; i++){
			knum[i] = in.nextInt();
			if(knum[i] == 0) System.out.println(max);
			for(int j = 0; j<k; j++){
				num[k+max] = 
			}
		}
	}
}