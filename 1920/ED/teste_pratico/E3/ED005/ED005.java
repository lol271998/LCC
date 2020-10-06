import java.util.Scanner;

public class ED005{
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for(int i = 0; i<n; i++){
			
			MyStack<Integer> s = new LinkedListStack<Integer>();
			String line = in.nextLine();
			
			for(int j = 0; j<line.length(); j++){
				if(line.charAt(j)!=' '){
					
					char c = line.charAt(j);
					if(Character.isDigit(c)){
						int a = Character.getNumericValue(c);
						System.out.println("num: "+a);
						s.push(a);
					}

					else{
						System.out.println("before pop: "+s);
						int a = s.pop();
						int b = s.pop();
						System.out.println("After pop"+s);
						System.out.printf("%d %c %d\n",a,c,b);
						switch(c){
							case '+':
							a = a+b;
							break;

							case '*':
							a = a*b;
							break;

							case '-':
							a = a-b;
							break;

							case '/':
							a = a/b;
							break;	
						}
						s.push(a);
					}
				}
			}
		}
	}
}