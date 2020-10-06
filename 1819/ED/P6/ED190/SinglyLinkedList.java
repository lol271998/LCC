// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
   private Node<T> first;    // Primeiro no da lista
   private int size;         // Tamanho da lista

   // Construtor (cria lista vazia)
   SinglyLinkedList() {
      first = null;
      size = 0;
   }

   // Retorna o tamanho da lista
   public int size() {
      return size;
   }

   // Devolve true se a lista estiver vazia ou falso caso contrario
   public boolean isEmpty() {
      return (size == 0);
   }
   
   // Adiciona v ao inicio da lista
   public void addFirst(T v) {
      Node<T> newNode = new Node<T>(v, first); 
      first = newNode;
      size++;
   }

   // Adiciona v ao final da lista
   public void addLast(T v) {
      Node<T> newNode = new Node<T>(v, null); 
      if (isEmpty()) {
         first = newNode;
      } else {
         Node<T> cur = first;
         while (cur.getNext() != null)
            cur = cur.getNext();
         cur.setNext(newNode);         
      }
      size++;
   }

   // Retorna o primeiro valor da lista (ou null se a lista for vazia)
   public T getFirst() {
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();      
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
      first = first.getNext();
      size--;
   }

   // Remove o ultimo elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
      if (isEmpty()) return;
      if (size == 1) {
         first = null;
      } else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
         Node<T> cur = first;
         for (int i=0; i<size-2; i++)
            cur = cur.getNext();
         cur.setNext(null);
      }
      size--;
   }

   /*Encontrar o valor associado ao indice*/
   public T get(int pos){
      int pos1 = 0; 
      if(pos<0 || pos>=size || isEmpty()) return null;
      Node<T> cur = first;
      while(pos1 != pos){
         cur = cur.getNext();
         pos1++;
      }
      return cur.getValue();
   }

   /*Remover um valor dado uma posição*/
   public T remove(int pos){
      //Se a posição não existir
      if(pos<0 || pos>= size || isEmpty() || get(pos) == null) return null;
      
      Node<T> temp = first;
      
      //Se o valor a retirar é o primeiro (FUNCIONA)
      if(pos == 0){
         first = first.getNext();
         size--;
         return temp.getValue();
      }
      
      //Se for o ultimo
      if(pos == size-1){
         Node<T> cur = first;
         for (int i=0; i<size-2; i++){
            cur = cur.getNext();
         }
         temp = cur.getNext();
         cur.setNext(null);
         size--;
         return  temp.getValue();
      }

      //Encontra o anterior
      for(int i = 0; temp != null && i<pos-1; i++){
         temp = temp.getNext();
      }
      Node<T> tempret = temp.getNext();
      Node<T> next = temp.getNext().getNext();

      temp.setNext(next);
      size--;
      return tempret.getValue();
   }
   /*Copia a lista*/
   public SinglyLinkedList<T> copy(){
      SinglyLinkedList <T> list = this;
      SinglyLinkedList<T> listacopia = new SinglyLinkedList<T>();
      if(list.isEmpty()) return listacopia;
      else{
         listacopia.addFirst(list.getFirst());
         for(int i = 1; i<size; i++){
            listacopia.addLast(list.get(i));
         }
      }
      return listacopia;
   }
   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";                     
      }      
      str += "}";
      return str;
   }
}
