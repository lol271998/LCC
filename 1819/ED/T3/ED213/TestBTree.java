// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner stdin = new Scanner(System.in);
      int n = stdin.nextInt();
      for(int i = 0; i<n; i++){
         BTree<Integer> t = LibBTree.readIntTree(stdin);
         System.out.println(ED213.maxSum(t));
      }
   }
}