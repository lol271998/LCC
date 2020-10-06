public class TestSinglyLinkedList{
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); 
		for(int i = 0; i<5; i++){
			list.addLast(i);
		}
		list.duplicate();
		System.out.println(list);
	}
}