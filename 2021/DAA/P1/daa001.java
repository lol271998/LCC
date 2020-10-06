import java.util.Scanner;

public class daa001{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int count = 0; 
		for(int i = 0; i<n; i++){
			if(in.nextInt() == 42) count++;
		}

		System.out.println(count);

	}
}