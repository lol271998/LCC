// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Uma classe para progressoes
// Ultima alteracao: 16/03/2019
// -----------------------------------------------------------

// Gera uma progressao. Por omissao e simplesmente: 0, 1, 2, ...
public class Progression {
   protected long current; // valor actual

   // Por omissao comeca em 0. This chama construtor da propria classe
   Progression() { this(0); }
   
   // Constroi progressao comencando num dado valor
   Progression(long start) { current = start; }

   // Devolve o valor actual e avanca a sequencia
   public long nextValue( ) {
      long answer = current;
      advance();
      return answer;
   }

   // Avanca para o proximo valor da sequenca
   protected void advance( ) {
      current++;
   }

   // Escreve os proximos n valores da progressao
   public void printProgression(int n) {
      for (int i=0; i<n; i++)
         System.out.print(nextValue() + " ");
      System.out.println();
   }
}
