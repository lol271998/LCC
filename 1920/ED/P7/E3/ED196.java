class ED196{
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){
	int n = q.size();
	for(int i = 0; i<n && q.isEmpty()!=true; i++){
	    String name = q.dequeue();
	    String list = q.dequeue();
	    if(list.equals("A")) a.enqueue(name);
	    else if(list.equals("B")) b.enqueue(name);
	    else if(list.equals("X")){
		if(a.size()<b.size()) a.enqueue(name);
		if(a.size()>b.size()) b.enqueue(name);
	    }
	}
    }
}
