import java.util.Scanner;
public class TestMyQueue{
      public static void main(String[] args){
            MyQueue<Integer> a = new LinkedListQueue<Integer>();
            MyQueue<Integer> b = new LinkedListQueue<Integer>();
            Scanner stdin = new Scanner(System.in);
            int n = stdin.nextInt();
            System.out.println(n);
            stdin.nextLine();
            for(int i = 0; i<n; i++){
                  int numero = stdin.nextInt();
                  System.out.println(numero);
                  a.enqueue(numero);

            }
            n = stdin.nextInt();
            System.out.println(n);
            stdin.nextLine();
            for(int i = 0; i<n; i++){
                  int numero = stdin.nextInt();
                  System.out.println(numero);                  
                  b.enqueue(numero);
            }
            System.out.println(ED197.merge(a,b));
      }
}