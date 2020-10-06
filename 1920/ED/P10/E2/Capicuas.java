import java.util.Arrays;

public class Capicuas{
	
	static boolean capicua(int v[], int start, int end){
		if(start>=end) return true; //Caso Base
		int temp = v[start];
		if(v[start] != v[end]) return false;
		else return capicua(v,start+1,end-1);

	}

	public static void main(String[] args){
		int v[] = {1,2,3,2,1};
		System.out.println(capicua(v, 0, 4));
		int u[] = {5,8,8,5};
		System.out.println(capicua(u, 0, 3));
		int k[] = {1,2,3,1};
		System.out.println(capicua(k, 0, 3));
		int l[] = {5,8,7,5};
		System.out.println(capicua(l, 0, 3));
	}
}