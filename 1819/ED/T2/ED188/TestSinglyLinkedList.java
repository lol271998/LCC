public class TestSinglyLinkedList{
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(); 
		for(int i = 0; i<10; i++){
			list.addLast(i);
			System.out.println(list);
		}
		System.out.println(list.get(5));	
	}
}