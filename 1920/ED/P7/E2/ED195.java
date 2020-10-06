import java.util.Scanner;

public class ED195{
    public static boolean balanced(String s){
	MyStack<Character> stack = new LinkedListStack<Character>();
	int n = s.length();
	if(n%2!=0) return false;
	String str = "";
	for(int i = 0; i<n; i++){
	    if(s.charAt(i) == '(' || s.charAt(i) == '['){
		stack.push(s.charAt(i));
	    }
	    else if((s.charAt(i) == ')' && stack.top() != '(') || (s.charAt(i) == ']' && stack.top()!='[')){
		return false;
	    }
	    else stack.pop();
	}
	if(stack.isEmpty()) return true;
	else return false;
    }
    /*
      public static void main(String args[]){
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      in.nextLine();
      for(int i = 0; i<n; i++){
      String s = in.nextLine();
      System.out.println(s+": "+balanced(s));
      }
      }*/
}
