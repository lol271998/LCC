/*Escreva um programa que lê 3 valores inteiros da entrada-padrão e escreva a mediana,
isto é, o valor no meio quando os colocamos por ordem crescente. Assim, se os valores forem
a, b, c com a ≤ b ≤ c, então a mediana será b. Exemplos de execução:
Primeiro valor: 7
Segundo valor: 9
Terceiro valor: 7
Mediana: 7
Sugestão: uma forma de obter a mediana é somar os 3 valores e subtrair o valor máximo e
o valor mínimo; isto funciona mesmo nos casos em que alguns valores são iguais*/
#include<stdio.h>
int main(void){
	int a,b,c,maior,menor,res;
	printf("Introduza os 3 valores: \n");
	scanf("%d %d %d",&a,&b,&c);
	printf("Primeiro valor: %d\n",a);
	printf("Segundo valor: %d\n",b);
	printf("Terceiro valor: %d\n",c);
		if(a>=b) maior=a;
		else maior = b;
		if (c>=maior) maior=c;
		if(a<b) menor=a;
		else menor=b;
		if(c<menor) menor=c;
	res=(a+b+c)-(maior+menor);
	printf("Mediana: %d\n",res);
}