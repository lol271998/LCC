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

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
   
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
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
   public static Matrix identity(int n){
      
      Matrix m = new Matrix (n,n);
      
      for(int i = 0; i<n; i++){
         m.data[i][i] = 1;
      }
      
      return m;
   }
   public Matrix transpose() {
      Matrix m = new Matrix(cols, rows);
         
         for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) m.data[j][i] = this.data[i][j];
         }
        
        return m;
   }
   public Matrix sum(Matrix m){

      Matrix m1 = this; //chama a matrix mx (mx.Sum(m))
      Matrix ms = new Matrix(rows,cols);

      for(int i = 0; i<rows; i++){
         for(int j = 0; j<rows; j++){
            ms.data[i][j] = 0;
         }
      }

      for(int i = 0; i<rows; i++){
         for(int j = 0; j<cols; j++){
            ms.data[i][j] = m1.data[i][j] + m.data[i][j];
         }
      }
      return ms;
   }
   public Matrix multiply(Matrix m){
      
        Matrix m1 = this; //chama a matrix mx (mx.multiply(m))
        
        if (m1.cols != m.rows) throw new RuntimeException("Dimensões não válidas.");
        
        Matrix mm = new Matrix(m1.rows, m.cols);
        
        for (int i = 0; i < mm.rows; i++)
          for (int j = 0; j < mm.cols; j++)
            for (int k = 0; k < m1.cols; k++)
              mm.data[i][j] += (m1.data[i][k] * m.data[k][j]);
        return mm;
    }
}