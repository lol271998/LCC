public class ED197{
	public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
		MyQueue<Integer> q = new LinkedListQueue<Integer>();
		while(!a.isEmpty() && !b.isEmpty()){

			if(a.first() < b.first()){
				//System.out.println("Adicionou de 'a' a q: " + a.first());
				q.enqueue(a.dequeue());
			}
			else{
				//System.out.println("Adicionou de 'b' a q: " +  b.first());
				q.enqueue(b.dequeue());
			}
		}
		//System.out.println("Enquanto um não estiver vazio");
		while(!a.isEmpty() && b.isEmpty()){
			//System.out.println("'a' não está vazio");
			q.enqueue(a.dequeue());
		}
		while(!b.isEmpty() && a.isEmpty()){
			//System.out.println("'b' não está vazio");
			q.enqueue(b.dequeue());
		}
		return q;
	}
}