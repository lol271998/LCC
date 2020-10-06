// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Atribuicao de varios tipo de variaveis
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

public class TestBasicTypes {
   public static void main(String[] args) {
      boolean flag = true;
      char      ch = 'A';
      byte       b = 12;
      short      s = 24;
      int        i = 257;
      long       l = 2147483648L;  // sem a letra e interpretado como int
      float      f = 3.1415f;      // sem a letra e interpretado como double  
      double     d = 2.1828;
      System.out.println("flag = " + flag); 
      System.out.println("ch = "   + ch); 
      System.out.println("b = "    + b); 
      System.out.println("s = "    + s); 
      System.out.println("i = "    + i); 
      System.out.println("l = "    + l); 
      System.out.println("f = "    + f); 
      System.out.println("d = "    + d); 
   }
}
