// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Limites dos varios tipos de variaveis
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

public class TestLimits {
   public static void main(String args[]) {
      // inteiros
      byte largestByte = Byte.MAX_VALUE;
      short largestShort = Short.MAX_VALUE;
      int largestInteger = Integer.MAX_VALUE;
      long largestLong = Long.MAX_VALUE;

      // virgula flutuante
      float largestFloat = Float.MAX_VALUE;
      double largestDouble = Double.MAX_VALUE;

      // mostrar limites
      System.out.println("Largest byte value: " + largestByte);
      System.out.println("Largest short value: " + largestShort);
      System.out.println("Largest integer value: " + largestInteger);
      System.out.println("Largest long value: " + largestLong);

      System.out.println("Largest float value: " + largestFloat);
      System.out.println("Largest double value: " + largestDouble);
    }
}
