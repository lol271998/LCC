// -----------------------------------------------------------
// Estruturas de Dados 2018/2019 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1819/
// -----------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples
// Ultima alteracao: 01/04/2018
// -----------------------------------------------------------

public class TestSinglyLinkedList {
   public static void main(String[] args) {

      // Criacao de lista de inteiros
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

      // Escrevendo lista (no inicio esta vazia)
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());  
      
      // Adicionando numeros de 1 a 5 ao final da lista
      for (int i=1; i<=5; i++)
         list.addLast(i);
      System.out.println(list);

      // Adicionando numeros de 6 a 10 ao inicio da lista
      for (int i=6; i<=10; i++)
         list.addFirst(i);
      System.out.println(list);

      // Verificando o tamanho da lista
      System.out.println("size = " + list.size());

      // Retirando o primeiro elemento
      list.removeFirst();
      System.out.println(list);

      // Retirando o ultimo elemento
      list.removeLast();
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());

      // Escreve o primeiro e ultimo elementos
      System.out.println("getFirst() = " + list.getFirst());
      System.out.println("getLast() = " + list.getLast());
      System.out.println(list.size());

      /*Remover um elemento numa posição*/
      System.out.println("Remover i = 6 : " + list.remove(4));
      System.out.println(list);
      System.out.println(list.size());

      /*Copiar a lista*/
      SinglyLinkedList<Integer> newlist = new SinglyLinkedList<Integer>(); 
      newlist = list.copy();
      System.out.println(newlist);

      list.addLast(4);

      System.out.println(list);

      System.out.println("Count (4): " + list.count(4));

      System.out.println("Check1");

      list.duplicate();

      System.out.println("Check2");
      
      System.out.println(list);

      System.out.println("Check3");
   }
}