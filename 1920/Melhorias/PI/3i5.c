/* Escreva um programa que lê 3 valores inteiros da entrada padrão e escreve
o valor máximo, o minimo e a amplitude*/

#include<stdio.h>

int main(void){
	int a,b,c;
	scanf("%d %d %d", &a, &b, &c);
	printf("Primeiro valor: %d\n", a);
	printf("Segundo valor: %d\n", b);
	printf("Terceiro valor: %d\n", c);
	int vM,vm,amp;
	
	//Ver o maior
	if(a>=b) vM=a;
	else vM=b;
	if(c>=vM) vM=c;

	//Ver o menor
	if(a<=b) vm=a;
	else vm=b;
	if(c<=vm) vm=c;

	printf("Valor Máximo: %d\n",vM);
	printf("Valor Minimo: %d\n",vm);
	amp = vM-vm;
	printf("Amplitude: %d\n",amp);
	return 0;
}