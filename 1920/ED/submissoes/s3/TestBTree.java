// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      for(int i = 0; i<n; i++){
         System.out.println("initial t:");
         String tree = in.nextLine();
         BTree<Integer> t = LibBTree.readIntTree(in);
         t.printPreOrder();
         int[] a = new int[2];
         a = t.maxLevel();
         System.out.println("["+a[0]+","+a[1]+"]");
      }

      //ex: java -Xss256M ED233  para inputs grandes
      
      /*Escrever resultado de chamada a alguns metodos
      System.out.println("numberNodes = " + t.numberNodes());
      System.out.println("depth = " + t.depth());
      System.out.println("contains(2) = " + t.contains(2));
      System.out.println("contains(3) = " + t.contains(3));

       Escrever nos da arvore seguindo varias ordens possiveis
      t.printPreOrder();      
      t.printInOrder();
      t.printPostOrder();
      t.printBFS();
      t.printDFS();
      */

      //ED203
   }
}
