/*Esvreva um programa que lê 3 valores inteiros da entrada padrão
e imprime o maior desses 3 numeros*/

#include<stdio.h>

int main(void){
	int a,b,c,maior;
	scanf("%d %d %d",&a,&b,&c);
	if(a>b) maior = a;
	else maior = b;
	if(c>maior) maior = c;
	printf("%d\n",maior);
}