import java.util.Scanner;

public class ED184{
    static double media(int vec[], int n){
	int sum = 0;
	for(int i = 0; i<n; i++){
	    sum+=vec[i];
	}
	double sumd = sum;
	double nd = n;
	return sumd/nd;
    }
    public static void main (String[] args){
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	int vec[] = new int[n];
	int maior = stdin.nextInt();
	int menor = maior;
	vec[0] = maior;
	for(int i = 1; i<n; i++){
	    vec[i] = stdin.nextInt();
	    if(vec[i]>maior) maior = vec[i];
	    if(vec[i]<menor) menor = vec[i];
	}
	System.out.printf("%.2f\n",media(vec,n));
	System.out.println(maior-menor);
    }
}
