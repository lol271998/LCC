// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

public class SinglyLinkedList<T>{
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
        }
        else{
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

    public boolean contains(T x){
        Node<T> cur = first;
        if(size == 0) return false;
        for(int i = 0; i<size; i++){
            if(cur.getValue().equals(x)) return true;
            cur = cur.getNext();
        }
        return false;
    }
    //Devolve um elemento numa data posição
    public T get(int pos){
        Node<T> cur = first;
        for(int i = 0; i<size; i++){
            if(i == pos) return cur.getValue();
            else cur = cur.getNext();
        }
        return null;
    }

    //Remove um elemento numa dada posição
    public T remove(int pos){
        Node<T> cur = first;
        if(pos>=size || pos<0) return null;
        if(pos == 0){
            first = first.getNext();
            size--;
            return cur.getValue();
        }
        for(int i = 0; i<pos-1; i++){
            cur = cur.getNext();
        }
        Node<T> elim = cur.getNext();
        cur.setNext(cur.getNext().getNext());
        size--;
        return elim.getValue();
    }

    public void removevoid(int i){
        if(size == 0 || i>size) return;
        if(i == 0){
            first = first.getNext();
            size--;
        }
        Node<T> cur = first;
        for(int j = 0; j<i-1; j++){
            cur = cur.getNext();
        }
        cur.setNext(cur.getNext().getNext());
        size--;
    }

    //Cópia de uma lista
    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> l = new SinglyLinkedList<T>();
        Node<T> cur = first;
        for(int i = 0; i<size; i++){
            l.addLast(cur.getValue());
            cur = cur.getNext();
        }
        return l;
    }

    //Duplica cada elemento da lista
    public void duplicate(){
        if(size == 0) return;
        Node<T> cur = first;
        for(int i = 0; i<size-1; i++){
            Node<T> dup = new Node<T>(cur.getValue(), cur.getNext()); //Cria um novo nó, com o valor de cur e aponta para o próximo cur
            cur.setNext(dup); //Mete o cur a apontar para o dup
            cur = cur.getNext().getNext();
        }
        addLast(cur.getValue());
        size=(size*2)-2;
    }

    //Conta o numero de elementos igual a value
    public int count(T value){
        int c = 0;
        Node<T> cur = first;
        for(int i = 0; i<size; i++){
            if(cur.getValue().equals(value))c++;
            cur = cur.getNext();
        }
        return c;
    }

    //Remove da lista todas as ocorrências do valor value
    public void removeAll(T value){
        Node<T> cur = first;
        while(cur!=null && cur.getValue().equals(value)){
            removeFirst();
            cur = first;
        }
        if(cur==null) return;
        while(cur.getNext()!=null){
            if(cur.getNext().getValue().equals(value)){
                cur.setNext(cur.getNext().getNext());
                size--;
            }
            else cur = cur.getNext();
        }
        if(cur.getValue().equals(value)){
            removeLast();
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
