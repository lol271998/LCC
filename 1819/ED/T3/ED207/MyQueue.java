// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// Interface para o TAD Fila
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

public interface MyQueue<T> {

   // Metodos que modificam a fila
   public void enqueue(T v); // Coloca um valor no final da fila
   public T dequeue();       // Retira e retorna o valor no inicio da fila

   // Metodos que acedem a informacao (sem modificar)
   public T first();         // Retorna valor no inicio da fila
   public int size();        // Retorna quantidade de elementos na fila
   public boolean isEmpty(); // Indica se a fila esta vazia
}
