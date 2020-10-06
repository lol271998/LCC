import java.util.Scanner;
public class ED120{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				if((i<=n/2 && (j>=(n/2)-i) && (j<=(n/2)+i)) || (i>n/2 && (j>=(n/2)-(n-i-1)) && ( j<= (n/2)+(n-i-1)) ))
					System.out.print("#");
				else System.out.print(".");
			}
		System.out.println();
		}	
	}
}