import java.util.Scanner;

	class Matrix {
		int data[][]; // os elementos da matriz em si
   	int rows;     // numero de linhas
   	int cols;     // numero de colunas
    int contins = 0;  // conta as instancias 

   // construtor padrao de matriz
		Matrix(int r, int c) {
    		  data = new int[r][c];
      		rows = r;
      		cols = c;
   	}
   		
   	public String toString() {
    		String ans = "";
    		for (int i=0; i<rows; i++) {
          for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
          ans += "\n";
      	}  
      	return ans;
   	}	

    /*lê os characteres da matrix*/
  	public void read(Scanner in) {
    	String linha = in.nextLine();	
    	for (int i=0; i<rows; i++){
      	linha = in.nextLine();      			
        for (int j=0; j<cols; j++){
          data[i][j] = linha.charAt(j);
        }
      }
   	}

   	public int contador(){
      Matrix m = this;
      int cont = 0;
      int contmax = 0;
      
        /*Conta os cardinais por linha seguidos*/  
      for(int i = 0; i<m.rows; i++){
        cont = 0;
        for(int j = 0;j<m.cols; j++){
          if(m.data[i][j] == '#'){
            cont++;
            //System.out.println("Cont: " + cont);
          }
          else{
            cont = 0;
            //System.out.println("else");
          }
        if(cont > contmax)
          contmax = cont;
        //System.out.println("Contmax: " + contmax);
        }
      }

      /*Conta os cardinais por coluna seguidos*/
      for(int i = 0; i<m.cols; i++){
        cont = 0;
        for(int j = 0; j<m.rows; j++){
          if(m.data[j][i] == '#'){
            cont++;
            //System.out.println("Cont: " + cont);
          }
          else
            cont = 0;
        if(cont > contmax)
          contmax = cont;        
        }
        ////System.out.println("Contmax: " + contmax);
      } 
      
      /*Conta as instancias por linha */
      for(int i = 0; i<m.rows; i++){
        cont = 0;
        for(int j = 0;j<m.cols; j++){
          if(m.data[i][j] == '#'){
            cont++;
            //System.out.println("Cont: " + cont);
          }
          else
            cont = 0;
          if(cont == contmax)
            contins++;
          //System.out.println("Contamax: "+contmax);
          //System.out.println("Contins: "+contins);
          //System.out.println("Cont: "+cont);
        }
      }
      
      /*Conta as instancias por coluna*/
      for(int i = 0; i<m.cols; i++){ 
        cont = 0;
        for(int j = 0; j<m.rows; j++){
          if(m.data[j][i] == '#')
            cont++;
          else
            cont = 0;
          
          if(cont == contmax)
            contins++;
        }
      }
      
      return contmax;
    }
  }


public class contaCard{
	public static void main(String[] args){
		
		Scanner stdin = new Scanner(System.in);
      	
  	Matrix m = new Matrix(stdin.nextInt(), stdin.nextInt());
      	
    m.read(stdin);
		
    System.out.println(m.contador() + " " + m.contins);

	}
}