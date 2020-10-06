import java.util.Scanner;
import java.lang.Object;

public class TestMyStack {
   public static MyStack<Integer> process(String[] word, int size){
      MyStack<Integer> stack = new LinkedListStack<Integer>();
      char c,op;
      int a,b,num;
      int res = -1;
      for(int i = 0; i<size; i++){
         c = word[i].charAt(0);
         if(c>='0' && c<='9'){
            num = Character.getNumericValue(c);
            System.out.print("Acrescentou ");
            System.out.print(num);
            System.out.println(" ao stack");
            stack.push(num);
            System.out.println(stack);
         }
         else{
            System.out.println("Entrou no else");
            while(stack.pop()!=null){
               System.out.println("Entrou no while");
               switch(c){
                  case '+':
                     if(stack.size()<2) return stack;
                     else{
                        a = stack.pop();
                        b = stack.pop();
                        if(stack.size()==0){
                        res = a+b;
                        stack.push(res);
                     }
                  break;
               
                  case '-':
                     a = stack.pop();
                     b = stack.pop();
                     res = a-b;  
                     stack.push(res);    
                     System.out.println("Stack: " + stack);                  
                  break;
                
                  case '/':
                     a = stack.pop();
                     b = stack.pop();
                     res = a/b;
                     System.out.println("Stack: " + stack);            
                  case'*':
                     a = stack.pop();
                     b = stack.pop();
                     res = a*b;
                     System.out.println("Stack: " + stack);
                  break;
                
                  default:
                     return stack;
               }
            }  
         }
      }
      return stack;
   }


   public static void main(String[] args) {

      String linha;
      Scanner stdin = new Scanner(System.in);
      int n = stdin.nextInt();
      stdin.nextLine();

      for(int i = 0; i<6; i++){
         
         linha = stdin.nextLine();
         
         String[] words = linha.split(" ");
         int size = words.length;
         System.out.println("size: " + size);
         for(int j = 0; j<size; j++){
            System.out.println("Numero: " + words[j]);
         }
         if(process(words,size).size() == -1){
            System.out.println("Expressao Incorrecta");
         }
         else
            System.out.println("Resultado: " + process(words,size).top());

      }
   }
}
