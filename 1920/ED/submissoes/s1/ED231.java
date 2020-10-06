/*
Nome: Filipe Colla David
Número mecanográfico: 201810097
Sobre ajudas: Não tive.
Explicação da solução: 

-Flag 1 - Para a primeira flag calculei as primeiras am um '.', criando assim a tabela desejada.
Este algoritmo apesar de ter um loop inicial, o segundo loop tem complexidade O(n²) (n ao quadrado) que é maior do
que a complexidade do primeiro O(n), ficando então com a complexidade do maior O(n²)plitudes (máximas e minimas) fora do
ciclo for para ter um valor como referência para depois dentro do ciclo ter estes valores como referência e
comparar com as futuras amplitudes de modo a ver qual a maior.
Este algoritmo, flag_one, tem complexidade O(n), pois tem um loop que vai de 2 até n (n é o numero de dias)
e as restantes operações são de complexidade temporal constante.

-Flag 2 - Para a segunda flag usei um raciocínio semelhante ao da primeira, calculei o primeiro aumento 
percentual fora do loop para ter um valor de referência e caso este aumento fosse inferior a 5% incremento 
a variavel tempsize para contabilizar este aumento. Dentro do loop calculo o segundo intervalo, caso o primeiro
fosse menor ou igual do que 5% e o segundo maior do que 5%, significaria que o intervalo em que os aumentos são
menores ou iguais a 5% teria terminado, incremento o p++ e comparo tempsize com size, guardando assim o maior dos
dois. Caso contrário incremento o tempsize, pois encontro me num intervalo em que os aumentos percentuais são 
inferiores ou iguais a 5%. No final do loop tive que adicionar uma condição para contabilizar o ultimo intervalo em que
os aumentos são inferiores a 5%, caso contrário, se os aumentos terminassem num intervalo em que eram menor ou iguais
a 5%, não seria possivel contabilizar esse intervalo pois não houve uma alteração final. Da mesma forma que o algoritmo
anterior este tem uma complexidade O(n)

- Flag 3 - Na terceira flag comecei por calcular o maior valor de casos, de modo a ter as medidas para a tabela
(onde o numero máximo de casos é igual ao numero de linhas a dividir por 100 e as colunas são o numero de dias).
Depois com o uso de dois loops, um para as colunas e outro para as linhas, respectivamente, caso o valor de casos
de um certo dia a dividir por 100 fosse superior ou igual ao indice i, que começa por ser o valor máximo a 
dividir por 100 imprimia um '#' caso contrário imprimia um '.', criando assim a tabela desejada.
Este algoritmo apesar de ter um loop inicial, o segundo loop tem complexidade O(n²) (n ao quadrado) que é maior do
que a complexidade do primeiro O(n), ficando então com a complexidade do maior O(n²) (n ao quadrado).  

*/
import java.util.Scanner;

public class ED231{

	public static void flag_one(int days, int[] cases){
		int ampmin = cases[1]-cases[0];
		int ampmax = cases[1]-cases[0];

		for(int i = 2; i<days; i++){
			int amp = cases[i]-cases[i-1];
			if (amp>=ampmax) ampmax = amp;
			if (amp<=ampmin) ampmin = amp;
		}
		System.out.println(ampmin+" "+ampmax);
	}

	public static void flag_two(int days, int[] cases){
		int size = 0,tempsize = 0,per = 0;
		double p2;
		double p1 = ((double)cases[1]-(double)cases[0])/(double)cases[0];

		if(p1<=0.05){
			tempsize++;
		}

		for(int i = 2; i<days; i++){
			p2 = ((double)cases[i]-(double)cases[i-1])/(double)cases[i-1];	
			if(p1<=0.05 && p2>0.05){
				if(tempsize>=size){
					size = tempsize;
				}
				per++;
				tempsize = 0;
			}
			else if (p2<=0.05){
				tempsize++;
			}
			p1 = p2;
			if(i == days-1 && p1<=0.05) per++;
		}

		if(tempsize>=size) size = tempsize;
		System.out.println(per+" "+size);
	}

	public static void flag_three(int days, int[] cases){
		
		int max = cases[0];

		for(int i = 1; i<days; i++){
			if(cases[i]>=max) max = cases[i];
		}


		for(int i = max/100; i>0; i--){
			for(int j = 1; j<=days; j++){
				if(cases[j-1]/100>=i) System.out.print("#");
				else System.out.print(".");
			}
			System.out.println("");
		}

	}

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int days = in.nextInt();
		in.nextLine();
		int[] cases;
		cases = new int[days];
		
		for(int i = 0; i<days; i++){
			cases[i] = in.nextInt();
		}

		in.nextLine();
		int flag = in.nextInt();

		if(flag == 1){
			flag_one(days,cases);
		}

		if(flag == 2){
			flag_two(days,cases);
		}

		if(flag == 3){
			flag_three(days,cases);
		}

	}
}