// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao de Scanner a partir de uma String
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

import java.util.Scanner;

public class TestScannerFromString {
  public static void main (String[] args) {
    Scanner strIn = new Scanner("1 - 2 - 3 - 4 - 5");
    strIn.useDelimiter(" - ");
    while ( strIn.hasNextInt() ) {
      int n = strIn.nextInt();
      System.out.println(n);
    }
  }
}
