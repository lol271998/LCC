// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Interface para o TAD Deque
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

public interface MyDeque<T> {

   // Metodos que modificam o deque
   public void addFirst(T v); // Coloca um valor no inicio da fila
   public void addLast(T v);  // Coloca um valor no final da fila
   public T removeFirst();    // Retira e retorna o valor no inicio da fila
   public T removeLast();     // Retira e retorna o valor no final da fila

   // Metodos que acedem a informacao (sem modificar)
   public T first();          // Retorna valor no inicio da fila
   public T last();           // Retorna valor no final da fila
   public int size();         // Retorna quantidade de elementos na fila
   public boolean isEmpty();  // Indica se a fila esta vazia
}
