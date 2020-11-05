import java.util.Scanner;
import java.util.Arrays;

public class daa017{

	public static void count(boolean[][] pir, int n){
		int[][] count = new int[n][n];

		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				count[i][j] = 0;
			}
		}

		if(pir[n-1][0] == true){

			count[n-1][0] = 1;

			for(int i = n-2; i>=0; i--){
				for(int j = 0; j<=n-i-1; j++){
					
					//Se for o extremo esquerdo da piramide
					if(j == 0 && pir[i][j] == true){
						count[i][j] += count[i+1][j];
					}
					//Se for o extremo direito
					else if(j == n-i-1 && pir[i][j] == true){
						count[i][j] += count[i+1][j-1];
					}
					//Os restantes
					else if(pir[i][j] == true){
						count[i][j] += count[i+1][j]+count[i+1][j-1];
					}
				}
			}		

			long m = 0;

			for(int i = 0; i<n; i++){
				//System.out.println("i: "+i+" -> "+count[0][i]);
				m += count[0][i]; 
			}

			System.out.println(m);
		}

		else System.out.println(0);

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int d = in.nextInt();

		boolean[][] pir  = new boolean[n][n];

		for(int i = 0; i<n; i++){
			for(int j = 0; j<=n-1-i; j++){
				pir[i][j] = true;
			}
		}

		for(int i = 0; i<d; i++){
			pir[in.nextInt()-1][in.nextInt()-1] = false;
		}
		/*{
			for(int i = 0; i<n; i++){
				for(int j = 0; j<=n-1-i; j++){
					System.out.print(pir[i][j]+" ");
				}
				System.out.println();
			}
		}*/

		count(pir,n);
	}
}