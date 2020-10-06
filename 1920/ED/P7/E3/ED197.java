class ED197{
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
	MyQueue<Integer> q = new LinkedListQueue<Integer>();

	int n1 = a.size();
	int n2 = b.size();

	while(a.size()!=0 || b.size()!=0){
	    if(a.first()>b.first()) q.enqueue(a.dequeue());
	    else q.enqueue(b.dequeue());
	}
	if(a.size() != 0){
	    while(a.size()!=0){
		q.enqueue(a.dequeue());
	    }
	}
	else if(b.size()!= 0){
	    while(b.size()!=0){
		q.enqueue(b.dequeue());
	    }
	}
	return q;
    }
}
