import java.util.Scanner;
public class ED235{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		for(int i = 0; i<n; i++){
			int l = in.nextInt();
			for(int j = l; j>0; j--){
				for(int k = 0; k<l; k++){
					if(j >= l-k) System.out.print("#");
					else System.out.print(".");
				}
			System.out.println();
			}	
		}
	}
}