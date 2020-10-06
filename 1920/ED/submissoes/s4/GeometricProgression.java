// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Progressoes geometricas (subclasse de Progression)
// Ultima alteracao: 16/03/2019
// -----------------------------------------------------------

public class GeometricProgression extends Progression {
   protected long base;

   // Por omissao cria progressao: 1, 2, 4, 8, 16, ...
   public GeometricProgression() { this(2, 1); }
   
   // Cria progressao: 1, b, b^2, b^3, ...
   public GeometricProgression(long b) { this(b, 1); }

   // Cria progressao com uma dada base e um dado inicio
   public GeometricProgression(long b, long start) {
      super(start);
      base = b;
   }
   
   protected void advance( ) {
      current *= base;
   }
}
