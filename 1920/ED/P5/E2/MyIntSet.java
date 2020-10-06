public class MyIntSet implements IntSet {
    // Deverá colocar aqui os atributos e métodos
    private int size;
    private int elem[];
    private boolean isElem[];

    MyIntSet(int maxSize) {
	elem = new int[maxSize];
	size = 0;
	isElem = new boolean[maxSize];
    }

    MyIntSet(){ //porque é que é necessário ??
	this(1000);
    }
    
    // Retorna true se x esta no conjunto
    public boolean contains(int x){
	return isElem[x];
    }
    // Adiciona x ao conjunto
    public boolean add(int x){
	if(isElem[x] == false){
	    isElem[x] = true;    
	    size++;
	    return true;
	}
	return false;
    }
    // Remove x do conjunto
    public boolean remove(int x){
	if(isElem[x] == true){
	    isElem[x] = false;
	    size--;
	    return true;
	}
	return false;
    }
    // Retorna o numero de elementos do conjunto
    public int size(){
	return size;
    }
    // Limpa o conjunto (torna-o vazio)
    public void clear(){
	size = 0;
    }
}
