// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Instrucoes de Ciclo: break
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

class TestBreak {
   public static void main(String[] args) {
      for (int i=1; i<=2; i++) {
         for (int j=1; j<=10; j++) {
            if (j == 3) break;
            // Linha seguinte so sera executada quando j < 3
            System.out.println("ciclo j = " + j + " | i = " + i);
         }
         System.out.println("ciclo i = " + i);
      }
   }
}
