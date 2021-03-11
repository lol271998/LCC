import java.util.Scanner;

public class daa005{
	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);

		int n = in.nextInt();
		int[] bakug = new int[n+1];
		bakug[0] = 0;

		for(int i = 1; i<=n; i++){
		
			bakug[i] = in.nextInt() + bakug[i-1];
		
		}

		n = in.nextInt();

		for(int i = 0; i<n; i++){

			int a = in.nextInt();
			int b = in.nextInt();

			FastPrint.out.println(bakug[b]-bakug[a-1]);

		}
		FastPrint.out.close();
	}
}