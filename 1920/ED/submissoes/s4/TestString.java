// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao de Strings
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

import java.util.Arrays; // Para poder usar o Arrays.toString

public class TestString {
   public static void main(String[] args) {
      
      // Criacao de strings e escrita
      String c1 = new String("CC");
      String c2 = "1007";
      String c3 = c1 + " " + c2 + " rocks";
      System.out.println(c3);

      // Leitura de caracteres individuais e tamanho
      String s = "algoritmos";
      System.out.println("s.charAt(6) = " + s.charAt(6)); // 't'
      for(int i = 0; i < s.length(); i++) 
         System.out.print(s.charAt(i));
      System.out.println();

      // Comparacao de Strings
      String s1 = new String("Hello");
      String s2 = new String("Hello");
      System.out.println(s1.equals(s2)); // true
      System.out.println(s1 == s2);      // false 
      
      String s3= new String("Good-bye");
      String s4= new String("HELLO");
      System.out.println(s1.equals(s3));           // false
      System.out.println(s1.equals(s4));           // false
      System.out.println(s1.equalsIgnoreCase(s4)); // true (e um outro metodo)

      String s5 = "algoritmos";
      String s6 = "estruturas";
      System.out.println(s5.compareTo(s6)); // < 0

      // Substring
      System.out.println(s5.substring(2,5));

      // Conversao de e para array
      String s7 = "algoritmos";
      char[] a7 = s7.toCharArray();
      String s8 = new String(a7);
      System.out.println(Arrays.toString(a7));
      System.out.println(s8);
      
   }
}
