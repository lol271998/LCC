public class MyIntSet implements IntSet{
    private int size;
    private int elem[];
   		
    MyIntSet(int maxSize) {
	elem = new int[maxSize];
	size = 0;
    }
    
    MyIntSet(){
	this(10000000);
    }
    
    /*Verifica se contem o elemento*/
    public boolean contains(int x){
	for(int i = 0; i<size; i++){
	    if(elem[i] == x) return true;
	}
	return false;
    }

    /* Adiciona x ao conjunto*/	
    public boolean add(int x){
    	if (!contains(x)) {
	    if (size == elem.length) throw new RuntimeException("Maximum size of set reached");         
	    elem[size] =  x;
	    size++;
	    return true;
    	}
	return false;
    }

    /*Remove x do conjunto*/
    public boolean remove(int x){
	if(contains(x)){
	    for(int i = 0; i<size; i++){
		if(elem[i] == x){
		    elem[i] = elem[size-1];
		    size--;
		    return true;
		}
	    }
	}
	return false;
    }

    /*Retorna o numero de elementos do conjunto*/
    public int size(){
	return size;	   			
    }

    /* Limpa o conjunto (torna-o vazio)*/
    public void clear(){
	size = 0;
    }
}
