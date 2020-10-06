//Escreva um programa que lê um valor em euros e cêntimos(um float), acrescenta a taxa de 
//IVA(23%) e imprime o resultado
#include<stdio.h>

int main(void){
	float valor;
	scanf("%f",&valor);
	valor = valor + (valor*.23);
	printf("res: %f\n",valor);
}