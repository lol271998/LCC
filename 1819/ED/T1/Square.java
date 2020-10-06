import java.util.Scanner;

class Square{

	public static void linha_square(int inc, int n){
		if(inc == 0 | inc == n-1){
			for(int i = 0; i<n; i++){
				if(i == 0) System.out.print("+");
				if(i == n-1) System.out.println("+");
				else System.out.print("-");
			}
		}
		else{
			for(int i = 0; i<n; i++){
				if(i == 0) System.out.print("|");
				if(i == n-1) System.out.println("|");
				else System.out.print("-");
			}
		}
	}

	public static void main(String [] args){
		int n = 100;
		for(int i = 0; i<n; i++){
			linha_square(i,n);
		}
	}
}