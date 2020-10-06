public class ED194{
    
    public static void reverse(MyStack<Integer> s, int n){
	int[] array = new int[n];
	for(int i = 0; i<n; i++){
	    array[i] = s.pop();
	}
	for(int i = 0; i<n; i++){
	    s.push(array[i]);
	}
    }
    /*
    // Main apenas para testar no seu computador
    public static void main(String[] args) {
	MyStack<Integer> s = new LinkedListStack<Integer>();

	for (int i=5; i>0; i--)
	    s.push(i);
	System.out.println(s); // Antes da chamada a reverse
	reverse(s, 3);
	System.out.println(s); // Depois da chamada a reverse
    }
    */
}
