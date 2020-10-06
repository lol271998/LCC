public class TestSinglyLinkedList{
	public static void main(String[] args){
			SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		for(int i = 3; i<6; i++){
			list.addLast(i);
		}
		list.addLast(1);
		System.out.println(list);
		System.out.println("Numero de ocorrencias de 2: " + list.count(2));
	}
}