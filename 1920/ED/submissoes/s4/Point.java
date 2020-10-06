// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// TAD Ponto 2D (num plano) como falado nas primeiras aulas
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

public class Point {
   // Variavel estatica com nr pontos criados
   static int npoints = 0; 
   
   // Atributos
   int x;
   int y;

   // Construtor que recebe o conteudo a colocar nos atributos
   Point(int xvalue, int yvalue) {
      x = xvalue;
      y = yvalue;
      npoints++;
   }

   // Construtor padrao (sem argumentos)
   Point() { 
      x = 0;
      y = 0;
      npoints++;
   }
   
   // Metodo para mostrar o conteudo das variaveis x e y
   void show() {
      System.out.println("(" + x + "," + y + ")");
   }

   // mostra conteudo da variavel estatica
   static void showNumPoints() {
      System.out.println("npoints = " + npoints);
   }
}

