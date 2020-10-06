// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao do TAD Deque
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

public class TestMyDeque {
   public static void main(String[] args) {

      // Criacao do Deque
      MyDeque<Integer> q = new LinkedListDeque<Integer>();

      // Exemplo de insercao de elementos no inicio e no fim da fila
      for (int i=1; i<=4; i++) q.addFirst(i);
      for (int i=5; i<=8; i++) q.addLast(i); 
      System.out.println(q);

      // Exemplo de remocao de elementos no inicio e fim fila
      System.out.println("q.removeFirst() = " + q.removeFirst());
      System.out.println("q.removeLast() = " + q.removeLast());
      System.out.println(q);

      // Exemplo de utilizacao dos outros metodos
      System.out.println("q.size() = " + q.size());
      System.out.println("q.isEmpty() = " + q.isEmpty());
      System.out.println("q.first() = " + q.first());
      System.out.println("q.last() = " + q.last());
   }
}
