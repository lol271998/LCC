public class ED197{
	public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
		int n;
		MyQueue<Integer> q = new LinkedListQueue<Integer>();
		MyQueue<Integer> tempM = new LinkedListQueue<Integer>();
		MyQueue<Integer> tempm = new LinkedListQueue<Integer>();
		int i = 0;
		if(a.size()>b.size()){
	    	tempM = a;
	    	tempm = b;
	    	//System.out.println("'a' é maior");
	    	//System.out.println("");
		}
		else{
	    	tempM = b;
	    	tempm = a;
	    	//System.out.println("'b' é maior");
	    	//System.out.println("");
		}
		while(!tempm.isEmpty()){
			//System.out.println("Enquanto tempm não for vazio: " + tempm);
			if(tempm.first()<=tempM.first()){
				q.enqueue(tempm.dequeue());
				//System.out.println("Se tempm for maior de temM adicionar tempm");
				//System.out.println("tempm:" + tempm);
				//System.out.println("tempM:" + tempM);
				//System.out.println("q: " + q);
			}
			else{ 
				q.enqueue(tempM.dequeue());
				//System.out.println("Caso contrário");
				//System.out.println("tempM: " + tempM);
				//System.out.println("tempM: " + tempm);
				//System.out.println("q: " + q);
			}
			i++;
			//System.out.println("i:"+i);
		}
		//System.out.println("");
		if(!tempM.isEmpty()){
			//System.out.println("Se tempM não for vazio");
			while(!tempM.isEmpty()){
				//System.out.println("Enquanto tempM não for vazio adicionar os restantes a q");
				//System.out.println("q: " + q);
				q.enqueue(tempM.dequeue());
			}
		return q;
		}
		else return q;
	}
}