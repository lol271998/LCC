public class ED196{
	public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){
		String tempNome;
		char tempLista;
		int n = q.size()/2;
		for(int i = 0; i<n; i++){
			tempNome = q.dequeue();
			tempLista = q.dequeue().charAt(0);
			switch(tempLista){
				case 'A':
					a.enqueue(tempNome);
				break;
				case 'B':
					b.enqueue(tempNome);
				break;
				default:
					if(a.size()<b.size()){
						a.enqueue(tempNome);
					}
					if(b.size()<a.size()){
						b.enqueue(tempNome);
					}
			}
		}
	}
}