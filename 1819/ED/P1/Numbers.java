// Uma classe muito simples que usa um ciclo para imprimir numeros entre 1 e n

// O ficheiro tem de ter o mesmo nome da classe + a extensão '.java'
public class Numbers {
    public static void main(String[] args) {
	int n =500, /* limite dos numeros*/soma=0;	
	System.out.print("Numeros de 1 a " + n + ":"); // + é o operador de concatenação de strings
	for (int i=1; i<=n; i++){
	    soma=i+soma;
	    if(i<=9){
		System.out.print(i);
		System.out.print(',');
	    }
	    else
		System.out.println(i);
	}
	System.out.println(soma);
    }
}
