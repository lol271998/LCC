// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Instrucoes de Ciclo: while
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

class TestWhile {
   public static void main(String[] args) {
      System.out.println("isPrime(19) = " + isPrime(19));
   } 
   
   public static boolean isPrime(int n) {
      int divisor = 2;
      while (divisor*divisor <= n) {
         if ( (n % divisor) == 0 ) 
            return false;
         divisor++;
      }
      return true;
   }   
}
