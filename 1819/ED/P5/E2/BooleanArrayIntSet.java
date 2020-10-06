public class BooleanArrayIntSet implements IntSet {
    // Deverá colocar aqui os atributos e métodos
    private int size;
    private int elem[];
    private boolean isElem[];
   		
    BooleanArrayIntSet(int maxSize) {
	elem = new int[maxSize];
	size = 0;
	isElem = new boolean[maxSize];
    }
    
    BooleanArrayIntSet(){
	this(10000000);
    }

    public int getSize(){
	return size;
    }

    public void setSize(int nsize){
	this.size = nsize;
    }

    public boolean contains(int x){
	for(int i = 0; i<size; i++){
	    if(isElem[i] == true) return true;
	}
	return false;
    }

    public boolean add(int x){
	if(!contains(x)){
	    if (size == elem.length) throw new RuntimeException("Maximum size of set reached");
	    elem[size] = x;
	    isElem[size] = true;
	    size++;
	    return true;
	}
	return false;
    }
    public boolean remove(int x){
	   return true;
    }

    public int size(){
	return size;	   			
    }

    public void clear(){
	size = 0;			
    }
}
