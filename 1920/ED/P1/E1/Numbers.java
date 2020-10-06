

public class Numbers{
    public static void main(String[] main){
	int n = 10;
	int i;
	System.out.print("Numeros de 1 a " + n + ": ");
	for(i = 0; i<n-1; i++){
	    System.out.print(i+",");
	}
	System.out.println(i);
	int soma = 0;
	System.out.print("Soma de numeros de 1 até "+n+": ");
	for(i = 1; i<=n; i++){
	    soma+=i;
	}
	System.out.println(soma);
    }
}
