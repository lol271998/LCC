// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// Classe com um no generico
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class Node<T> {
   private T value;      // Valor guardado no no
   private Node<T> next; // Referencia para o proximo no da lista

   // Construtor
   Node(T v, Node<T> n) {
      value = v;
      next = n;
   }

   // Getters e Setters
   public T getValue() { return value; }
   public Node<T> getNext()  { return next; }
   public void setValue(T v) { value=v; }
   public void setNext(Node<T> n) { next = n; }
}
