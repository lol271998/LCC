import java.util.Scanner;

public class ED232 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i = 0; i<n; i++){
			SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
			int k = in.nextInt();
			for(int j = 0; j<k; j++){
				list.addLast(in.nextInt());
			}
			in.nextLine();
		}
	}
}