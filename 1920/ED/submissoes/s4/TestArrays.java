// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao de Arrays
// Ultima alteracao: 04/02/2019
// -----------------------------------------------------------

import java.util.Arrays; // Funcoes Utilitarias de Arrays

public class TestArrays {
   public static void main(String[] args) {

      // Criacao e erro de sair fora dos limites
      int[] v = new int[4];
      v[0] = 2;
      //v[4] = 5; // ArrayIndexOutOfBoundsException 

      // Inicializacao e impressao
      int[] primes = {2,3,5,7,11,13}; // Cria e inicializa array
      System.out.println(primes);     // Apenas imprime a referência
      System.out.println(Arrays.toString(primes)); // Converte para String

      // Comparacao
      int[] a = {1,2,3,4,5};
      int[] b = {1,2,3,4,5};
      if( Arrays.equals(a,b) )
         System.out.println("same contents");

      // Soma de dois arrays
      int[] c = addArrays(a,b);
      System.out.println(Arrays.toString(c));
   }

   // Metodo para somar dois arrays
   public static int[] addArrays (int[] u, int[] v) {
      int[] res = new int[u.length];
      for ( int i = 0 ; i < u.length ; i++ ) 
         res[i] = u[i] + v[i];
      return res;
   }
   
}
