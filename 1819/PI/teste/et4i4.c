/*Escreva um programa que lê uma sequência de valores em vírgula-utuante terminada
pelo valor 0 e calcula a sua média aritmética (i.e. a soma dos valores a dividir pela sua
contagem). Sugestão: modique o exemplo apresentado na aula teórica 6 para somar uma
sequência de números.*/
#include<stdio.h>
int main(void){
	int media,soma,n=1,num;
	printf("Introduza um número: \n");
	scanf("%d",&num);
	soma=num;
	while(num!=0){
		printf("Introduza um número: \n");
		scanf("%d",&num);
		if(num==0) break;
		soma+=num;
		n++;
	}
	media=soma/n;
	printf("Média: %d\n",media);
}