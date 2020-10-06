public class ED194{
	public static void reverse(MyStack<Integer> s, int n){
		int array[] = new int[s.size()];
		for(int i = 0; i<n; i++){
			//System.out.println("Tirou do stack: " + s.top());
			array[i] = s.pop();
		}
		for(int i = 0; i<n; i++){
			//System.out.println("Meteu no stack: " + array[i]);
			s.push(array[i]);
			//System.out.println("Array[i]: " + array[i]);
		}
	}
}