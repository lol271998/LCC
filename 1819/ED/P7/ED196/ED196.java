public class ED196{
	public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){
		int n = (q.size())/2;
		for(int i = 0; i<n; i++){
			String nome;
			char lista;
			nome = q.dequeue();
			lista = q.dequeue().charAt(0);
			/*
			System.out.println("lista: "+ lista);
			System.out.println("Nome: "+ nome);
			System.out.println("Fim for");
			System.out.println(q);*/
			switch(lista){
				case 'A':
					a.enqueue(nome);
					//System.out.println(a);
				break;			
				case 'B':
					b.enqueue(nome);
					//System.out.println(a);				
				break;
				default:
					if(a.size()<b.size()) a.enqueue(nome);
					if(a.size()>b.size()) b.enqueue(nome);
			}			
		}
	}
}