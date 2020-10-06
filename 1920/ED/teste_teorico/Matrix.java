import java.util.Scanner;

public class Matrix{
	public int linhas;
	public int colunas;
	public int[][] m;

	Matrix(int l, int c, int k){
		m = new int[l][c];
		linhas = l;
		colunas = c;
		for(int i = 0; i<l; i++){
			for(int j = 0; j<c; j++){
				m[i][j] = k;
			}
		}
	}

	// Ler os rows x cols elementos da matriz
    public void read(Scanner in) {
    	for (int i=0; i<linhas; i++)
    		for (int j=0; j<colunas; j++)
    			m[i][j] = in.nextInt();
    }

	public Matrix transpose(){
		Matrix mt = new Matrix(colunas,linhas,0);

		for(int i = 0; i<colunas; i++){
			for(int j = 0; j<linhas; j++){
				mt.m[i][j] = m[j][i];
			}
		}
		return mt;
	}



	public String toString() {
		String ans = "";
		for (int i=0; i<linhas; i++) {
		    for (int j=0; j<colunas; j++)
			ans += m[i][j] + " ";
		    ans += "\n";
		}
		return ans;
    }
}