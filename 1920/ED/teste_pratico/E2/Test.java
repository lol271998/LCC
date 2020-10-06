// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples
// Ultima alteracao: 01/04/2018
// -----------------------------------------------------------
import java.util.Scanner;

public class Test {
   public static void main(String[] args) {

      // Criacao de lista de inteiros
      SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      char c = 'a';
      for(int i = 0; i<3;i++){
         list.addLast(in.nextInt());
      }
      System.out.println(list);
      System.out.println(list.size());
      list.shift(2);
      System.out.println(list);
      System.out.println(list.size());
   }
}
