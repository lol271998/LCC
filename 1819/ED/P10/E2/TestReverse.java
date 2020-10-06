// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// Invertendo um array (versao recursiva)
// Ultima alteracao: 21/04/2018
// -----------------------------------------------------------

import java.util.Arrays;

public class TestReverse {

   // Inverter array v entre posicoes start e end
   static void reverse(int v[], int start, int end) {
      if (start>=end) return;     // Caso base: array de tamanho < 2
      int tmp = v[start];         // Trocar primeiro com ultimo
      v[start] = v[end];
      v[end] = tmp;
      reverse(v, start+1, end-1); // Chamada recursiva para o resto
   }
   
   // -----------------------------------------------------------

   static boolean capicua(int v[], int start, int end){
      if(start>=end) return true; //Caso base: array de tamanho < 2
      if(v[start] != v[end]) return true;
      return capicua(v,start+1,end-1);
   }
   static boolean capicua1(int v[], int start, int end){
      if(start>=end) return true; //Caso base: array de tamanho < 2
      if(v[start] == v[end]) return capicua1(v,start+1,end-1);
      return false;
   }
   
   public static void main(String[] args) {
      int v[] = {2,8,6,8,2}; // Inicializacao de array

      System.out.println("Antes  do reverse: " + Arrays.toString(v));
      reverse(v, 0, v.length-1);
      System.out.println("Depois do reverse: " + Arrays.toString(v));

      System.out.println(capicua(v,0,v.length-1));
      System.out.println(capicua1(v,0,v.length-1));
   }
}
