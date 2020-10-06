import java.util.Scanner;
public class TestMyQueue{
   public static void main(String[] args){
      MyQueue<String> q = new LinkedListQueue<String>();
      MyQueue<String> a = new LinkedListQueue<String>();
      MyQueue<String> b = new LinkedListQueue<String>();
      
      q.enqueue("Luis");
      q.enqueue("B");
      q.enqueue("Pedro");
      q.enqueue("A");
      q.enqueue("Luisa");
      q.enqueue("A");
      q.enqueue("Joao");
      q.enqueue("X");
      q.enqueue("Jose");
      q.enqueue("X");
      q.enqueue("Miguel");
      q.enqueue("B");

      ED196.process(q,a,b);
      System.out.println("Queue q: " + q);
      System.out.println("Queue a: " + a);
      System.out.println("Queue b: " + b);
   }
}