public class TestSinglyLinkedList{
	public static void main(String[] args){
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> newlist = new SinglyLinkedList<Integer>();
		for(int i = 0; i<10; i++){
			list.addLast(i);			
		}
		System.out.println("Lista antiga: " + list);
		newlist = list.copy();
		list.clear();
		System.out.println("Lista antiga vazia: " + list);
		System.out.println("Lista cópia: " + newlist);
	}
}