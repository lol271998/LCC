public class Lindenmayer{
    public static void main(String[] args){
	String str = "A";
	int n = 7;
	String str1 = "";
	System.out.println(str);
	for(int i = 0; i<n; i++){
	    int size = str.length();
	    str1 = "";
	    for(int j = 0; j<size; j++){
     
		if(str.charAt(j) == 'A'){
		    str1=str1+"AB";
		}
		else if(str.charAt(j) == 'B'){
		    str1=str1+"A";
		}
	    }
	    str = str1;
	    
	    System.out.println(str);
	}
    }
}
