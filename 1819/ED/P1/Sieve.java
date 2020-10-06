public class Sieve {

    // Procedimento para usar o algoritmo do Crivo de Eratóstenes
    // [procedimento ainda por completar]
    public static void sieve(int n, boolean prime[]){
	for(int i=2;i<=n;i++) {
	    if(prime[i]==true) {
		for(int a=i+1;a<=n;a++) {
		    if(a%i==0) prime[a]=false;
		}
	     }
	}
    }
    public static void main(String[] args) {
	
	int n=100; // Limite dos números

	// Cria um array de inteiros com tamanho n+1
	// (arrays começam na posição 0)
	boolean[] prime = new boolean[n+1];
	for(int i=0;i<n+1;i++) prime[i]=true;
	// Chama o procedimento sieve para números até 'n' no array 'prime'
	sieve(n, prime);
	// Escreve todos os números marcados a 'true' no array 'prime'
	for (int i=2; i<=n; i++){
	    if (prime[i])
		System.out.println(i);
	}
    }
}
