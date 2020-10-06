public class TestMyStack{
	public static void main(String[] args){
		int i;
		MyStack<Integer> s = new LinkedListStack<Integer>();
		for(i = 1; i<9; i++){
			s.push(i);
			System.out.println("Meteu: " + i);
		}
		System.out.println(s);
		ED194.reverse(s,4);
		System.out.println("Stack: " + s);
	}
}