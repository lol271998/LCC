/*Escreva um programa que lê 3 valores inteiros da entrada-padrão e escreve o número
de valores distintos (1, 2 ou 3). Exemplos de execução:
Primeiro valor: 7
Segundo valor: 9
Terceiro valor: 7
Resposta: 2 valores distintos.*/
#include<stdio.h>
int main(void){
	int va,vb,vc,n=3;
	printf("Intrdoduza 3 valores: \n");
	scanf("%d %d %d",&va,&vb,&vc);
	printf("Primeiro valor: %d\n",va);
	printf("Segundo valor: %d\n",vb);
	printf("Terceiro valor: %d\n",vc);
	while(n>0){
		if(va==vb)
			n--;
		if(va==vc)
			n--;
		if(vb==vc){
			n--;
			break;
		}
		else
			break;
	}
	printf("Resposta: existem %d",n);
	printf(" valores distintos\n");
}