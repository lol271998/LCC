import java.util.Scanner;

public class ED121{

    static boolean palindromo(String s){
	int size = s.length();
	for(int i = 0; i<size; i++){
	    if( s.charAt(i) != s.charAt(size-i-1)) return false;
	}
	return true;
    } 
    
    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	System.out.println(n);
	String str[] = new String[n];
	stdin.nextLine();
	for(int i = 0; i<n; i++){
	    str[i] = stdin.nextLine();
	    //System.out.println(str[i]);
	    str[i] = str[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
	    //System.out.println(str[i]);
	    if(palindromo(str[i]) == true) System.out.println("sim");
	    else System.out.println("nao");
	}
    }
}
