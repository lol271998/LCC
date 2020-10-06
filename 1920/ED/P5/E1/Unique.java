import java.util.Scanner;

public class Unique{
    public static void main(String[] args){
	int n = Integer.parseInt(args[0]);
	
	IntSet s = new MyIntSet(n); // Chama o construtor padrão

	Scanner stdin = new Scanner(System.in);
	
	for(int i = 0; i<n; i++){
	    s.add(stdin.nextInt());
	}
	System.out.println(s.size());
    }
}
