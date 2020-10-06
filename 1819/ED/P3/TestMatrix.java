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

      Matrix m1 = this;
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
      
        Matrix m1 = this;
        
        if (m1.cols != m.rows) throw new RuntimeException("Dimensões não válidas.");
        
        Matrix mm = new Matrix(m1.rows, m.cols);
        
        for (int i = 0; i < mm.rows; i++)
          for (int j = 0; j < mm.cols; j++)
            for (int k = 0; k < m1.cols; k++)
              mm.data[i][j] += (m1.data[i][k] * m.data[k][j]);
        return mm;
    }
}
public class TestMatrix {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      Matrix m1 = Matrix.identity(5);
      System.out.println(m1);
      
      Matrix m2 = new Matrix(stdin.nextInt(), stdin.nextInt());
      m2.read(stdin);
      System.out.println(m2);
      Matrix m3 = new Matrix(stdin.nextInt(), stdin.nextInt());
      m3.read(stdin);
      System.out.println(m3);
      Matrix m4 = new Matrix(stdin.nextInt(), stdin.nextInt());
      m4.read(stdin);
      System.out.println(m4);

      Matrix m5 = m1.transpose();
      System.out.println(m5);
      Matrix m6 = m2.transpose();
      System.out.println(m6);

      Matrix m7 = m2.sum(m3);
      System.out.println(m7);
      Matrix m8 = m2.multiply(m4);
      System.out.println(m8);
   }
}
