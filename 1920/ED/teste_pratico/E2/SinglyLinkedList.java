// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
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
   		cur.setNext(cur.getNext().getNext());
   	}
   	size--;
   }

   //[ED188] Devolver elemento numa dada posição
   public T get(int pos){
   	Node<T> cur = first;
   	for(int i = 0; i<size; i++){
   		if(i == pos) return cur.getValue();
   		else cur = cur.getNext();
   	}
   	return null;
   }

   //[ED189] Remover elemento numa dada posição
   public T remove(int pos){
   	Node<T> cur = first;
   	if(pos>=size || pos < 0) return null;
   	if(pos == 0){
   		first = first.getNext();
   		size--;
   		return cur.getValue();
   	}
   	for(int i = 0; i<pos-1; i++){
   		cur = cur.getNext();
   	}
   	Node<T> elim = cur.getNext(); //Guardar o nó a eliminar
   	cur.setNext(cur.getNext().getNext());
   	size--;
   	return elim.getValue();
   }

   //[ED190] Cópia de uma lista
   public SinglyLinkedList<T> copy(){
   	SinglyLinkedList<T> cpy = new SinglyLinkedList<T>();
   	Node<T> cur = first;
   	for(int i = 0; i<size; i++){
   		cpy.addLast(cur.getValue());
   		cur = cur.getNext();
   	}
   	return cpy;
   }

   //[ED191] Duplicando elementos
   public void duplicate(){
   	if(size == 0) return;
   	Node<T> cur = first;
   	for(int i = 0; i<size; i++){
   		Node<T> dup = new Node<T>(cur.getValue(),cur.getNext());
   		cur.setNext(dup);
   		size++;
   		cur = cur.getNext().getNext();
   	}
   	addLast(cur.getValue());
   }

   //[ED192] Contando elementos
   public int count(T value){
   	int c = 0;
   	Node<T> cur = first;
   	for(int i = 0; i<size; i++){
   		if(cur.getValue().equals(value)) c++;
   		cur = cur.getNext();
   	}
   	return c;
   }

   //[ED193] Removendo todas as ocorrências de um elemento
   public void removeAll(T value){
   	Node<T> cur = first;
   	while(cur!=null && cur.getValue().equals(value)){ //Eliminar o primeiro
   		removeFirst();
   		cur = first;
   	}
   	if(cur == null) return; //Eram todos iguais
   	while(cur.getNext()!=null){ //Os restantes
   		if(cur.getNext().getValue().equals(value)){
   			cur.setNext(cur.getNext().getNext());
   			size--;
   		}
   		else cur = cur.getNext();
   	}
   	if(cur.getValue().equals(value)){ //Remover o ultimo
   		removeLast();
   	}
   }
   //[ED232] Deve devolver uma nova lista que é igual à lista original, mas invertida
   public SinglyLinkedList<T> reverse(){
   	Node<T> cur = first;
   	SinglyLinkedList<T> r = new SinglyLinkedList<T>();
   	for(int i = 0; i<size; i++){
   		r.addFirst(cur.getValue());
   		cur = cur.getNext();
   	}
   	return r;
   }

   //[ED232] Deve devolver um array contendo as posições (por ordem crescente) de todas as 
   //ocorrências do elemento elem na lista. 
   public int[] occurrences(T elem){
   	int c = 0;
   	Node<T> cur = first;
   	
   	for(int i = 0; i<size; i++){
   		if(cur.getValue().equals(elem)) c++;
   		cur = cur.getNext();
   	}

   	if(c == 0) return null;

   	cur = first;
   	int[] occ = new int[c];
   	int j = 0;
   	for(int i = 0; i<size; i++){
   		if(cur.getValue().equals(elem)){
   			occ[j] = i;
   			j++;
   		}
   		cur = cur.getNext();
   	}
   	return occ;
   }

   //[ED232] Deve remover da lista todos os elementos que estão na lista toRemove
   public void remove(SinglyLinkedList<T> toRemove){
   	if(isEmpty()) return;

   	Node<T> cur = first; 
   	Node<T> curtr = toRemove.first;
   	
   	for(int i = 0; i<toRemove.size(); i++){
     		while(first.getValue().equals(curtr.getValue())){
   			removeFirst();
   			if(!isEmpty())	cur = first;
   			else return;
   		}
   		for(int j = 0; j<size-2; j++){
   			if(cur.getNext().getValue().equals(curtr.getValue())){
   				cur.setNext(cur.getNext().getNext());
   				size--;
   				j--;
   			}
   			else cur = cur.getNext();

   		}
   		if(size > 1 && cur.getNext().getValue().equals(curtr.getValue())){
   			cur.setNext(null);
   			size--;
   		}
   		cur = first;
   		curtr = curtr.getNext();
   	}
   }

   public SinglyLinkedList<T> cut(int a, int k){
      SinglyLinkedList<T> l = new SinglyLinkedList<>();
      Node<T> cur = first;

      for(int i = 0; i<size; i++){
         if(i >= a){
            l.addLast(cur.getValue());
            k--;
         }
         if(k == 0) return l;
         cur = cur.getNext();
      }
      return l;
   }

   public void shift(int k){
      if(k == 0) return;
      Node<T> cur = first;
      for(int i = 0; i<k; i++){
         addLast(cur.getValue());
         first = cur.getNext();
         cur = first;
         size--;
      }
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
