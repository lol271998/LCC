// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples
// Ultima alteracao: 01/04/2018
// -----------------------------------------------------------
import java.util.Scanner;

public class TestSinglyLinkedList {
    public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		for(int i = 0; i<n; i++){
	    	SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
	    	int l = stdin.nextInt();
	    	for(int j = 0; j<l; j++){
				int k = stdin.nextInt(); 
				list.addLast(k);
	    	}
	    	System.out.println(list);
	    	list.removevoid(0);
	    	System.out.println(list);
    	}
	}
}
