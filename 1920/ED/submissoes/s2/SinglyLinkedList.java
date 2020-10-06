/*
Nome: Filipe Colla David
Número mecanográfico: 201810097
Sobre ajudas: Não tive.
Explicação da Solução:

-reverse: Para este método, criei uma lista vazia e fui adicionando
ao início o valor da outra lista:
{1,2,3,4} -> {}
{1,2,3,4} -> {1}
{1,2,3,4} -> {2,1}
...
{1,2,3,4} -> {4,3,2,1}
Para tal usei o método addFirst();
Este método fica então com complexidade O(n),pois o metodo addFirst() 
tem complexidade constante e o método reverse é composto por um loop
com tamanho n, onde n é o tamanho da 
lista.

-occurrences: Para este método fiz um loop para contar quantos
elementos eram iguais a T, calculando assim o tamanho do array, 
caso não tivesse elementos fazia return null, pois não houve 
elemtos iguais a T, logo o array seria nulo. Caso contrário, com o
auxilio de outro loop voltaria a encontra os elementos iguais a T
mas desta vez iria guardar a sua posição no array com o auxilio de
uma condição. Este algoritmo fica com complexidade O(n), apesar de
ter dois loops, estes não são embarricados (O(2*n) = O(n))

-remove: Para este método fiz tive que usar dois loops embarricados
o primeiro usei para a lista com os elementos a remover, e o segundo
com a lista dos elementos que iam ser removidos. Antes de entrar
no segundo loop, criei outro loop while para remover, com o auxilio do
método removeFirst() (complexidade constante), os elementos à cabeça da 
lista,caso estes fossem iguais a um dos elementos a remover.
Caso a lista fosse vazia não tinha mais elementos para eliminar, fazia
return para terminar a função.
Não havendo mais elementos à cabeça que fossem iguais ao elemento em
comparação, seguia para o segundo loop onde elimino os elementos 
que estão no meio, todos excepto o primeiro e o último. Caso o último
fosse um elemento a eliminar, este seria eliminado fora do loop com uma
condição, caso a lista tivesse tamanho um e o último fosse um 
elemento a eliminar essa condição seria "apanhada" pelo loop que
elimina os valores à cabeça
No fim actualizava os valores de modo a "avançar" para o próximo
elemento da lista com os elementos a eliminar e para voltar ao inicio
da lista dos elementos que vão ser eliminados.
Este algoritmo tem complexidade O(n*(2*n)) = O(n²).
*/

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

   // Retorna o último valor da lista (ou null se a lista for vazia)
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

   // Remove o último elemento da lista (se for vazia nao faz nada)
   public void removeLast() {
   	if (isEmpty()) return;
   	if (size == 1) {
   		first = null;
   	} 
   	else {
         // Ciclo com for e uso de de size para mostrar alternativa ao while
   		Node<T> cur = first;
   		for (int i=0; i<size-2; i++)
   			cur = cur.getNext();
   		cur.setNext(cur.getNext().getNext());
   	}
   	size--;
   }

   //Inverte a lista
   public SinglyLinkedList<T> reverse(){
   	SinglyLinkedList <T> reverse = new SinglyLinkedList<T>();
   	Node<T> cur = first;
   	for(int i = 0; i<size; i++){
   		reverse.addFirst(cur.getValue());
   		cur = cur.getNext();
   	}
   	return reverse;
   }

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
