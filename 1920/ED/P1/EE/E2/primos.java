public class primos{
    
    public static void main(String[] args){
	int n = 1440;
	int n1 = n;
	int i = 2;
	System.out.print(n+" = ");
	while(n1!=1){
	    if(n1%i==0 && n1 == n){
		System.out.print(i);
		n1 = n1/i;
	    }
	    else if(n1%i==0){
		System.out.print(" * ");
		System.out.print(i);
		n1 = n1/i;
	    }
	    else i++;
	}
	System.out.println("");
	
    }
}
