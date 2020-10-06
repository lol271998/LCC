// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Sequencia de Fibonacci (subclasse de Progression)
// Ultima alteracao: 16/03/2019
// -----------------------------------------------------------


class FibonacciProgression extends Progression {
   protected long prev;

   // Por omissao cria fibonacci classico: 0, 1, 1, 2, 3, 5, ...
   public FibonacciProgression() { this(0, 1); }
   
   // Cria fibonacci com dois valores iniciais dados
   public FibonacciProgression(long first, long second) {
      super(first);
      prev = second - first; // valor ficticio antes do first
   }
   
   protected void advance( ) {
      long temp = prev + current;
      prev = current;
      current = temp;
   }
}
