//Escrever um programa que leia uma quantia inteira 
//e que mostra como pagar essa quantia em notas de 20 10 5 e moedas de 1.
#include<stdio.h>

int main(void){
	int valor,n20,n10,n5,n1;
	n20=0;
	n10=0;
	n5=0;
	n1=0;
	scanf("%d",&valor);
	if(valor>20){
		n20 = valor/20;
		valor = valor - (n20*20);
	}
	if(valor>10){
		n10 = valor/10;
		valor = valor - (n10*10);
	}
	if(valor>5){
		n10 = valor/5;
		valor = valor - (n5*5);
	}
	if(valor!=0){
		n1 = valor;
		valor = valor-n1;
	}
	printf("notas de 20: %d\n",n20);
	printf("notas de 10: %d\n",n10);
	printf("notas de 5: %d\n",n5);
	printf("notas de 1: %d\n",n1);
}