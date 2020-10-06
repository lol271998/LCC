import java.util.Scanner;

	class Matrix{
		char data[][]; 
		int rows;
		int cols;
		int maxrow = 0;

		/*Construtor da Matrix*/
		Matrix(int r, int c){
			data = new char[r][c];
			rows = r;
			cols = c;
		}
		/*Passar a matrix para String*/
		public String toString(){
			String ans = " ";
			for(int i = 0; i<rows; i++){
				for(int j = 0; j<cols; j++)
					ans+=data[i][j] + " ";
				ans+="\n";
			}
			return ans;
		}

		/* lê os caracteres da matrix */
  		public void read(Scanner in) {
    		String linha = in.nextLine();	
    		for (int i=0; i<rows; i++){
      			linha = in.nextLine();      			
        		for (int j=0; j<cols; j++){
          			data[i][j] = linha.charAt(j);
        		}
      		}
   		}
   		/*Ver se a matrix é vazia (VER O QUE SE PASSA)
   		public int vazio(int n){
   			Matrix m = this;
 			int cont = 0;
   			for(int i = 0; i<m.rows;i++){
   				for(int j = 0; i<m.cols;j++){
   					if(m.data[i][j] == '.')
   						cont++;
   				}
   			}
   			if(cont == (n^2))
   				return 1;
   			else
   				return 0;
   		}*/
   		/*Ver se os X ganham*/
   		public int sequenciaX(int n){
   			Matrix m = this; 
   			int cont = 0;
   			/*0 = Ganha X*/
   			/*1 = Empate*/

   			/*Contar na horizontal #*/
   			for(int i = 0; i<m.cols; i++){
   				cont = 0;
   				for(int j = 0; j<m.cols; j++){
   					if(m.data[i][j] == 'X')
   						cont++;
   					else
   						cont = 0;
   				}
   				//System.out.println("Cont_h: " + cont);
   				if(cont == n){
   					//System.out.println("if horizontal");
   					return 0;
   				}
   				else
   					cont = 0;
   				}
   			
   			/*Contar na vertical*/
   			for(int i = 0; i<m.rows; i++){
   				cont = 0;
   				for(int j = 0; j<m.rows;j++){
   					if(m.data[j][i] == 'X')
   						cont++;
   					else
   						cont = 0;
   				}
   				//System.out.println("Cont_v: " + cont);
   				if(cont == n){
   					System.out.println("if vertical");
   					return 0;
   				}
   				else
   					cont = 0;
   			}
   			
   			/*Contar na diagonal principal*/
   			for(int i = 0; i<n; i++){
   				if(m.data[i][i] == 'X')
   					cont++;
   				else
   					cont = 0;
   			}
   				//System.out.println("Cont_d: " + cont);
   				if(cont == n){
   					//System.out.println("if diagonal");
   					return 0;
   				}
   				else
   					cont = 0;

   			/*Contar na diagonal não principal*/
   			int j = 0;
   			for(int i = m.rows-1; i>=0; i--){
   				if(m.data[i][j] == 'X'){
   					cont++;
   					//System.out.println("Cont_ad: " + cont);
				}
				else
   						cont = 0;
   				j++;
   			}
   			if(cont == n){
   				//System.out.println("if anti diagonal");
   				return 0;
   			}
   			else
   				cont = 0;
   		/*Se for empate*/
   		return 1;
   		}
   		/*Ver se os O ganham*/
   		public int sequenciaO(int n){
   			Matrix m = this; 
   			int cont = 0;
   			/*0 = Ganha X*/
   			/*1 = Empate*/

   			/*Contar na horizontal #*/
   			for(int i = 0; i<m.rows; i++){
   				cont = 0;
   				for(int j = 0; j<m.cols; j++){
   					if(m.data[i][j] == 'O')
   						cont++;
   					else
   						cont = 0;
   				}
   				//System.out.println("Cont_O: " + cont);
   				if(cont == n)
   					return 0;
   				else
   					cont = 0;
   			}
   			
   			/*Contar na vertical*/
   			for(int i = 0; i<m.cols; i++){
   				cont = 0;
   				for(int j = 0; j<m.rows;j++){
   					if(m.data[j][i] == 'O')
   						cont++;
   					else
   						cont = 0;
   				}
   				//System.out.println("Cont_O: " + cont);
   				if(cont == n)
   					return 0;
   				else
   					cont = 0;
   			}

   			/*Contar na diagonal principal*/
   			for(int i = 0; i<n; i++){
   				if(m.data[i][i] == 'O')
   					cont++;
   				else
   					cont = 0;
   				//System.out.println("Cont_d_O: " + cont);
   			}
   				if(cont == n){
   					//System.out.println("if diagonal_O");
   					return 0;
   				}
   				else
   					cont = 0;

   			/*Contar na diagonal não principal*/
   			int j = 0;
   			for(int i = m.rows-1; i>=0; i--){
   				if(m.data[i][j] == 'O'){
   					cont++;
   					//System.out.println("Cont_ad_O: " + cont);
				}
				else
   						cont = 0;
   				j++;
   			}
   			if(cont == n){
   				//System.out.println("if anti diagonal_O");
   				return 0;
   			}
   			else
   				cont = 0;

   		/*Se for empate*/
   		return 1;
   		}   
   	}
public class Jgalo{

	public static void main(String[] args){

		Scanner stdin = new Scanner(System.in);
    	
    	int n;

    	n = stdin.nextInt(); 
      	
  		Matrix m = new Matrix(n,n);
      	      	
    	m.read(stdin);
    	
    	if(n>1 & n<101){
    		if(m.sequenciaX(n) == m.sequenciaO(n)){
    			System.out.println("Empate");
    			return;
    		}
    		if(m.sequenciaX(n) == 0){
    			System.out.println("Ganhou o X");
    			return;
    		}

    		if(m.sequenciaO(n) == 0){
    			System.out.println("Ganhou o O");
    			return;
    		}
    	}
    	else{
    		System.out.println("Jogo incompleto");
    		return;
    	}
	}
}