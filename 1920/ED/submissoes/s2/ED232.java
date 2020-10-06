import java.util.Scanner;

public class ED232 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		for(int i = 0; i<n; i++){
			String type = in.nextLine();
			if(type.equals("char")){
				SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();
				SinglyLinkedList<Character> listr = new SinglyLinkedList<Character>();
				int k = in.nextInt();
				for(int j = 0; j<k; j++){
					list.addLast(in.next().charAt(0));
				}
				in.nextLine();
				k = in.nextInt();
				for(int j = 0; j<k; j++){
					listr.addLast(in.next().charAt(0));	
				}
				System.out.println("no inicio list = "+list+"| size = "+list.size());
				System.out.println("chamada a list.remove("+listr+")");
				list.remove(listr);
				System.out.println("no final list = "+list+" | size = "+list.size());
			}
			if(type.equals("int")){
				SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
				SinglyLinkedList<Integer> listr = new SinglyLinkedList<Integer>();
				int k = in.nextInt();
				for(int j = 0; j<k; j++){
					list.addLast(in.nextInt());
				}
				in.nextLine();
				k = in.nextInt();
				for(int j = 0; j<k; j++){
					listr.addLast(in.nextInt());	
				}
				System.out.println("no inicio list = "+list+"| size = "+list.size());
				System.out.println("chamada a list.remove("+listr+")");
				list.remove(listr);
				System.out.println("no final list = "+list+" | size = "+list.size());
				
			}
			if(type.equals("string")){
				SinglyLinkedList<String> list = new SinglyLinkedList<String>();
				SinglyLinkedList<String> listr = new SinglyLinkedList<String>();
				int k = in.nextInt();
				for(int j = 0; j<k; j++){
					list.addLast(in.next());
				}
				in.nextLine();
				k = in.nextInt();
				for(int j = 0; j<k; j++){
					listr.addLast(in.next());	
				}
				System.out.println("no inicio list = "+list+"| size = "+list.size());
				System.out.println("chamada a list.remove("+listr+")");
				list.remove(listr);
				System.out.println("no final list = "+list+" | size = "+list.size());
			}
			in.nextLine();
			System.out.println("--------------------------------");
		}
	}
}