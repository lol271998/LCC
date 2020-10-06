/*Escreva um programa que lê uma sequência de inteiros terminada pelo valor 0 e determina
o máximo (i.e. maior valor da sequência). Sugestão: modique o exemplo apresentado
na aula teórica 6 para somar uma sequência de números.*/
#include<stdio.h>
int main(void){
	int numero,maior;
	printf("Introduza um número: \n");
	scanf("%d",&numero);
	maior=numero;
	while(numero!=0){
		printf("Introduza o número: \n");
		scanf("%d",&numero);
		if(numero==0) break;
			if(numero>=maior){
				maior=numero;
			}		
	}
	printf("Número maior: %d\n",maior);
}