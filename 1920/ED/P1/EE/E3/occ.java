public class occ{
    public static void main(String[] args){
	int[] array = {1,2,5,2,6,2,4,6,1};
	int size = array.length;
	int num = 2;
	int cont = 0;
	for(int i = 0; i<size; i++){
	    if(array[i] == num) cont++;
	}
	System.out.println(cont);
    }
}
