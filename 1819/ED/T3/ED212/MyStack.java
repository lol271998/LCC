// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// Interface para o TAD Pilha
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

public interface MyStack<T> {

   // Metodos que modificam a pilha
   public void push(T v); // Coloca um valor no topo da pilha
   public T pop();        // Retira e retorna o valor no topo da pilha

   // Metodos que acedem a informacao (sem modificar)
   public T top();           // Retorna valor no topo da pilha
   public int size();        // Retorna quantidade de elementos na pilha
   public boolean isEmpty(); // Indica se a pilha esta vazia
}
