import java.util.Scanner;
public class TestSinglyLinkedList{
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		for(int i = 0;i<n;i++){
			stdin.nextLine();
			int l = stdin.nextInt();		
			for(int j = 0; j<l; j++){
				int k = stdin.nextInt();
				list.addLast(k);
			}
			stdin.nextLine();
			System.out.println("Lista sem o numero retirado: " + list);
			int indret = stdin.nextInt();
			System.out.println("Indice: " + indret);
			System.out.println("Numero a ser retirado: " + list.remove(indret));
			System.out.println("Lista com o numero retirado: " + list);
			System.out.println("");
			list.clear();
		}
	}
}