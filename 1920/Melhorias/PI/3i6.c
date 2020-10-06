/*Escreva um programa que lê 3 valores inteiros e 
e  escreve o numero de valores distintos*/

#include<stdio.h>
int main(void){
	int a,b,c;
	scanf("%d %d %d",&a,&b,&c);
	printf("Primeiro valor: %d\n", a);
	printf("Segundo valor: %d\n", b);
	printf("Terceiro valor: %d\n", c);
	if(a==b && b==c && a==c) printf("Resposta: 0 valores distintos \n");
	else if(a!=b && b!=c && a!=c) printf("Resposta: 3 valores distintos \n");
	else if((a!=b)^(b!=c)^(a!=c)) printf("Resposta: 1 valor distinto \n");
	else if((a!=b && a!=c) || (b!=c && b!=a) || (c!=b && c!=a)) printf("Resposta: 2 valores distintos \n");
}
