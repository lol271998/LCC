
public class ED195{
	public static boolean balanced(String s){
		MyStack<Character> stack = new LinkedListStack<Character>();
		if(s.charAt(0) == ')' || s.charAt(0) == ']') return false;
		else{
			for(int i = 0; i<=(s.length()-1); i++){				
				if(s.charAt(i) == '(' || s.charAt(i) == '[') stack.push(s.charAt(i));				
				else{
					if(s.charAt(i) == ')'){
						if(stack.top() != '(') return false;
						else stack.pop();
					}
					if(s.charAt(i) == ']'){
						if(stack.top() != '[') return false;
						else stack.pop();
					}
				}
			}
		if(stack.isEmpty()) return true;
		else return false;
		
		}		
	}
}