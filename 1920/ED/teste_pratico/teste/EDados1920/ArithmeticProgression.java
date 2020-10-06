// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Progressoes aritmeticas (subclasse de Progression)
// Ultima alteracao: 16/03/2019
// -----------------------------------------------------------

public class ArithmeticProgression extends Progression {
   protected long increment;

   // Por omissao cria progressao: 0, 1, 2, ...
   public ArithmeticProgression() { this(1, 0); }
   
   // Cria progressao: 0, stepsize, 2*stepsize,...
   public ArithmeticProgression(long stepsize) { this(stepsize, 0); }

   // Cria progressao com um dado incremento e um dado inicio
   public ArithmeticProgression(long stepsize, long start) {
      super(start);
      increment = stepsize;
   }
   
   protected void advance( ) {
      current += increment;
   }
}
