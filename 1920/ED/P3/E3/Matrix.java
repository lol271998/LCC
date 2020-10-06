import java.util.Scanner;

class Matrix {
    int data[][]; // os elementos da matriz em si
    int rows;     // numero de linhas
    int cols;     // numero de colunas

    // construtor padrao de matriz
    Matrix(int r, int c) {
    	data = new int[r][c];
    	rows = r;
    	cols = c;
    }

    public boolean magic(){
    	int sum = 0;
    	//Colunas
    	for(int i = 0; i<rows; i++){
    		for(int j = 0; j<rows; j++){
    			sum+=data[i][j];
    		}
    		if(sum!=15){
    			System.out.println("1: "+ sum);
    			return false;
    		}
    		sum = 0;
    	}

    	//Linhas
    	for(int j = 0; j<rows; j++){
    		for(int i = 0; i<rows; i++){
    			sum+=data[i][j];
    		}
    		if(sum!=15){
    			System.out.println("2: "+ sum);
    			return false;
    		}
    		sum = 0;
    	}

    	//Diagonal 1
    	for(int i = 0; i<rows; i++){
    		sum+=data[i][i];
    	}
    	
    	if(sum!=15){
    		System.out.println("3: "+ sum);
    		return false;
    	}
    	sum = 0;

    	//Diagonal 2;
    	for(int i = rows-1, j = 0; i>=0 && j<rows; i--,j++){
    		//System.out.print(data[i][j]+" ");
    		sum+=data[i][j];
    	}
    	if(sum!=15){
    		//System.out.println("4: "+ sum);
    		return false;
    	}
    	return true;

    }

    // Ler os rows x cols elementos da matriz
    public void read(Scanner in) {
    	for (int i=0; i<rows; i++)
    		for (int j=0; j<cols; j++)
    			data[i][j] = in.nextInt();
    }

    	public static Matrix identity(int n){
    		Matrix m = new Matrix(n,n);
    		for(int i = 0; i<n; i++){
    			for(int j = 0; j<n; j++){
    				if(i == j) m.data[i][j] = 1;
    				else m.data[i][j] = 0;		
    			}
    		}
    		return m;
    	}

    	public Matrix transpose(){
    		Matrix mt = new Matrix(cols,rows);
    		for(int i = 0; i<rows; i++){
    			for(int j = 0; j<cols; j++){
    				mt.data[j][i] = data[i][j];
    			}
    		}
    		return mt;
    	}

    	public Matrix sum(Matrix m){
    		Matrix ms = new Matrix(rows,cols);
	        //System.out.println("Linhas: "+rows+" Colunas: "+cols);
     		for(int i = 0; i<ms.rows; i++){
    			for(int j = 0; j<ms.cols; j++){
    	   			ms.data[i][j] = this.data[i][j] + m.data[i][j];
		            //System.out.println("ms.data["+i+"]["+j+"] = "+ms.data[i][j]);
    			}
    		}
    		return ms;
    	}

    	public Matrix multiply(Matrix m){

    		if (cols != m.rows) throw new RuntimeException("Dimensões não válidas.");

    		Matrix mm = new Matrix(rows, m.cols);

    		for(int i = 0; i < mm.rows; i++){
    			for(int j = 0; j < mm.cols; j++){
    				for(int k = 0; k < cols; k++){
		    //System.out.println("mm.data["+i+"]["+j+"] = "+mm.data[i][j]);
    					mm.data[i][j] += (data[i][k] * m.data[k][j]);
    				}
    			}
    		}
    		return mm;
    	}

        // Representacao em String da matrix
    	public String toString() {
    		String ans = "";
    		for (int i=0; i<rows; i++) {
    			for (int j=0; j<cols; j++)
    				ans += data[i][j] + " ";
    			ans += "\n";
    		}
    		return ans;
    	}

    }
