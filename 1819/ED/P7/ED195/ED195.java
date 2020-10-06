public class ED195{
	public static boolean balanced(String s){
		MyStack<Character> stack = new LinkedListStack<Character>();
		/*System.out.println(s);
		System.out.println("");
		System.out.println("Tamanho da String: "+ (s.length()-1));
		/*Percorre a String adicionando '[' e '(' à string*/
		if(s.charAt(0)==']' || s.charAt(0)==')') return false;
		else{
			for(int i = 0; i<=(s.length()-1); i++){
				if(s.charAt(i) == '[' || s.charAt(i) == '('){
					stack.push(s.charAt(i));
					/*
					System.out.println("Adicionou ao stack:");
					System.out.println(stack);
					System.out.println("");*/
				}
				else{
					/*System.out.println("ELSE:");
					System.out.println("CharAt(i): " + s.charAt(i));*/
					if(s.charAt(i) == ')'){
						//System.out.println("CharAt(i) é igual a: " + s.charAt(i));
						if(stack.top() != '('){ 
							//System.out.println("É falso");
							return false;
						}
						else{
							/*System.out.println("Caracter: " + s.charAt(i));
							System.out.println("Fez stack pop [");*/
							stack.pop();
						}
					}
					if(s.charAt(i) == ']'){
						//System.out.println("CharAt(i) é igual a: " + s.charAt(i));
						if(stack.top()!= '['){
							//System.out.println("É falso"); 
							return false;
						}
						else{
							/*System.out.println("Caracter else: " + s.charAt(i));
							System.out.println("Fez stack pop (");*/
							stack.pop();
						}
					}
				}	
			/*System.out.println("i: "+i);
			System.out.println("");*/
			}
			if(stack.isEmpty()){
				//System.out.println("O stack está vazio");
				return true;
			}
			else{
				//System.out.println("O stack não está vazio");
				return false;
			}
		}	
	}
}