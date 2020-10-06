// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// Exemplo de utilizacao do TAD Fila
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

public class TestMyQueue {
   public static void main(String[] args) {

      // Criacao da fila
      MyQueue<String> q = new LinkedListQueue<String>();
      MyQueue<Integer> a = new LinkedListQueue<Integer>();
      MyQueue<Integer> b = new LinkedListQueue<Integer>();

      /*
      // Exemplo de insercao de elementos na fila
      for (int i=1; i<=8; i++)
         q.enqueue(i); // insere i no final da fila
      System.out.println(q);

      // Exemplo de remocao de elementos da fila
      for (int i=0; i<4; i++) {
         int aux = q.dequeue(); // retira o elemento no inicio da fila
         System.out.println("q.dequeue() = " + aux);
      }
      System.out.println(q);

      // Exemplo de utilizacao dos outros metodos
      System.out.println("q.size() = " + q.size());
      System.out.println("q.isEmpty() = " + q.isEmpty());
      System.out.println("q.first() = " + q.first());
      */
      for(int i = 0; i<5; i++){
         a.enqueue(i);
      }
      for(int i = 0; i<7; i++){
         b.enqueue(2*i);
      }
      System.out.println(ED197.merge(a,b));
   }
}
