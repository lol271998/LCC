// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Implementacao do TAD Fila usando lista duplamente ligada
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

public class LinkedListQueue<T> implements MyQueue<T> {
   private DoublyLinkedList<T> list;

   LinkedListQueue() { list = new DoublyLinkedList<T>();}
   
   public void enqueue(T v) { list.addLast(v); }   
   public T dequeue() {
      T ans = list.getFirst();
      list.removeFirst();
      return ans;
   }
   public T first() { return list.getFirst();}
   public int size() {return list.size();}
   public boolean isEmpty() {return list.isEmpty();}

   public String toString() {return list.toString();}
}
