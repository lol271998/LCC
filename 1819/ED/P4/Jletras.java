import java.util.Scanner;

class Matrix{

	/*Variaveis*/
	char[][] data;
	int rows;
	int cols;

	/*Construtor Matrix*/
	Matrix(int r, int c){
		rows = r;
		cols = c;
		data = new char[r][c];
	}

	/*Ler Matrix*/
	public void read(Scanner in){
		String linha = in.nextLine();
		for(int i = 0; i<rows; i++){
			linha = in.nextLine();
			for(int j = 0; j<cols; j++){
				data[i][j] = linha.charAt(j);
			}
		}
	}
	public String toString(){
		String ans = "";
		for(int i = 0; i<rows; i++){
			for(int j = 0; j<cols; j++){
				ans = ans + data[i][j] + " ";
			}
		ans = ans + "\n";
		}
	return ans;
	}
	public String linhas_colunas(String s, int l){
		Matrix m = this;
		Matrix aux = new Matrix(rows,cols);
		/*Linhas*/
		for(int i = 0; i<m.rows; i++){
			for(int j = 0; j<m.cols; j++){
				for(int k = j; j<l; j++)
				if(s.charAt(j) == m.data[i][j]){
					aux.data[i][j] = s.charAt(j);
					System.out.println(s.charAt(j));
				}
				else aux.data[i][j] = '.';
			}
		}
		return aux.toString();
	}
}

class Jletras{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();

		Matrix m = new Matrix(r,c);
		m.read(sc);
		m.toString();

		int n = sc.nextInt();
		String s;
		for(int i = 0; i<n; i++){
			s = sc.nextLine();
			int l = s.length();
			System.out.println(m.linhas_colunas(s,l));
		}
	}
}
