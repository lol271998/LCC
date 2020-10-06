public class Primes {
    // Verifica se o número n é primo (apenas divisível por 1 e por si próprio)
    // [função ainda por completar]
    static boolean isPrime(int n) {
	int i = 1;
	do{
	    i++;
	}while(n%i!=0);
	if(i!=n) return false;
	else return true;
    }

    static boolean isPrimeo(int n){
	for(int i = 2; i<=n/2; i++){
	    if(n%i==0) return false;
	}
	return true;
    }
    
    public static void main(String[] args) {
	
	int n=100; // Limite dos números
	
	for (int i=2; i<=n; i++) if (isPrime(i)) System.out.println(i);

	for(int i = 2; i<=n; i++) if (isPrimeo(i)) System.out.println(i);
    }
}
