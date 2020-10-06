// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de flood fill
// Ultima alteracao: 21/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class TestFloodFill {
   static int rows;            // Numero de linhas
   static int cols;            // Numero de colunas   
   static char m[][];          // Matriz de celulas
   static boolean visited[][]; // Saber se uma dada posicao ja foi visitada

   // Tamanho da mancha que inclui posicao (y,x)
   static int t(int y, int x) {
      if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
      if (visited[y][x]) return 0;  // Caso base: celula ja visitada
      if (m[y][x] == '.') return 0; // Caso base: celula vazia
      int count = 1;        // celula nao vazia
      visited[y][x] = true; // marcar como visitada
      count += t(y-1, x);   // Adicionando celulas nao vizinhas
      count += t(y+1, x);
      count += t(y, x+1);
      count += t(y, x-1);
      return count;
   }
   
   // -----------------------------------------------------------
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      // Leitura de uma matriz de caracteres
      rows = in.nextInt();
      cols = in.nextInt();
      m = new char[rows][cols];
      visited = new boolean[rows][cols];
      for (int i=0; i<rows; i++)
         m[i] = in.next().toCharArray();

      // Teste do metodo t(y,x)
      System.out.printf("t(0,0) = %d\n", t(0,0));
      System.out.printf("t(2,5) = %d\n", t(2,5));
      System.out.printf("t(4,0) = %d\n", t(4,0));      
   }
   
}
