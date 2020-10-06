public class Pair<T> {

    T p1,p2;
    
    public Pair(T a,T b){
        p1 = a;
        p2 = b;
    }

    public T getp1() { 
        return p1; 
    }

    public T getp2() { 
        return p2; 
    }

    public String toString() {
        return "(" + getp1() + "," + getp2()+")";
    }
}
  
