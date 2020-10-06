// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de implementacao de MergeSort
// Ultima alteracao: 21/04/2018
// -----------------------------------------------------------

import java.util.Arrays;

public class TestMergeSort {

   // Ordenar array v entre posicoes start e end
   static void mergeSort(int v[], int start, int end) {
      if (start == end) return;        // caso base (tamanho 1)
      int middle = (start + end) / 2;  // ponto medio
      mergeSort(v, start, middle);     // chamada recursiva a metade esquerda
      mergeSort(v, middle+1, end);     // chamada recursiva a metade direita
      merge(v, start, middle, end);    // combinar resultados
   }

   // Juntar duas metadas ja ordenadas
   static void merge(int v[], int start, int middle, int end) {
      int aux[] = new int[end-start+1]; // Novo array temporario
      
      int p1 = start;    // "Apontador" do array da metade esquerda
      int p2 = middle+1; // "Apontador" do array da metade direita
      int cur = 0;       // "Apontador" do array aux[] a conter juncao
      while (p1 <= middle && p2 <= end) { // Enquanto der para comparar
         if (v[p1] <= v[p2]) aux[cur++] = v[p1++]; // Escolher menor
         else aux[cur++] = v[p2++];                // e adicionar
      }
      while (p1<=middle) aux[cur++] = v[p1++]; // Adicionar o que resta
      while (p2<=end)    aux[cur++] = v[p2++];
      
      // Copiar array aux[] para v[]
      for (int i=0; i<cur; i++) v[start+i] = aux[i];
   }

   // -----------------------------------------------------------

   public static void main(String args[]) {
      int v[] = {1,5,2,8,4,3,7,6}; // Inicializacao de array

      System.out.println("Antes  do mergeSort: " + Arrays.toString(v));
      mergeSort(v, 0, v.length-1);
      System.out.println("Depois do mergeSort: " + Arrays.toString(v));
   }
   
}
