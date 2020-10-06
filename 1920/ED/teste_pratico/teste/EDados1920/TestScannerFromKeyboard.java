// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao de Scanner a partir do teclado
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

import java.util.Scanner;

public class TestScannerFromKeyboard {
  public static void main (String[] args) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("Number of persons: ");

    int n = stdIn.nextInt();
    String[] names = new String[n];
    int[]    ages  = new int[n];

    for( int i = 0; i < n ; i++ ) {
      System.out.println("input name[space]age: ");
      names[i] = stdIn.next();
      ages[i]  = stdIn.nextInt();
    }

    for( int i = 0; i < n ; i++ )
      System.out.println("name: "+ names[i] + " age: " + ages[i]);
  }
}
