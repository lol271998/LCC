import java.util.Scanner;

class piramide{
	public static void calc(int[][] pir, int n){
		int[] t = new int[11];
		int k = 0;

		for(int i = 1; i<n; i++){
			int temp = 0;
			for(int j = 0; j<n-i; j++){
				System.out.println(pir[i][j]+ " i: "+i+" j: "+j);
				int max = Math.max(pir[i-1][j],pir[i-1][j+1]);
				System.out.println(max);
				pir[i][j] += max;
				if(temp<=max) temp = max;
			}
			t[k] = temp;
			k++;
		}
		t[k] = pir[n-1][0];
		pir[0][n-1] += Math.max(pir[n-2][0],pir[n-2][1]);

		System.out.println("Valor Mais Alto: "+pir[n-1][0]);

		for(int i = 0; i<n; i++){
			System.out.println(t[i]);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[][] pir = new int[n][n];

		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++) pir[i][j] = 0;
		}

		//Guardar os elementos numa pirâmide
		for(int i = n; i>=0; i--){
			for(int j = 0; j<n-i; j++){
				pir[i][j] = in.nextInt();
			}
		}

		for(int i = 0; i<n; i++){
			for(int j = 0; j<n-i; j++) System.out.print(" "+pir[i][j]);
			System.out.println();
		}


		calc(pir,n);
	}
}