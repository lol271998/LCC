// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao das classes de progressoes
// Ultima alteracao: 16/03/2019
// -----------------------------------------------------------

public class TestProgression {
   public static void main(String[ ] args) {
      Progression prog;

      System.out.print("Default Progression: ");
      prog = new Progression();
      prog.printProgression(10); // 0 1 2 3 4 5 6 7 8 9

      System.out.print("Progression with start 4: ");
      prog = new Progression(4);
      prog.printProgression(10); // 4 5 6 7 8 9 10 11 12 13
      
      System.out.print("Arithmetic progression with default increment: ");
      prog = new ArithmeticProgression();
      prog.printProgression(10); // 0 1 2 3 4 5 6 7 8 9
      
      System.out.print("Arithmetic progression with increment 5: ");
      prog = new ArithmeticProgression(5);
      prog.printProgression(10); // 0 5 10 15 20 25 30 35 40 45
      
      System.out.print("Arithmetic progression with start 2: ");
      prog = new ArithmeticProgression(5, 2);
      prog.printProgression(10); // 2 7 12 17 22 27 32 37 42 47
      
      System.out.print("Geometric progression with default base: ");
      prog = new GeometricProgression( );
      prog.printProgression(10); // 1 2 4 8 16 32 64 128 256 512
      
      System.out.print("Geometric progression with base 3: ");      
      prog = new GeometricProgression(3);
      prog.printProgression(10); // 1 3 9 27 81 243 729 2187 6561 19683

      System.out.print("Fibonacci progression with default start values: ");
      prog = new FibonacciProgression( );
      prog.printProgression(10); // 0 1 1 2 3 5 8 13 21 34

      System.out.print("Fibonacci progression with start values 4 and 6: ");
      prog = new FibonacciProgression(4, 6);
      prog.printProgression(8); // 4 6 10 16 26 42 68 110
   }
}
