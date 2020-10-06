/*Escreva um programa que lê um valor x em virgula flutuante,
calcula a expressão 3x⁵+2x⁴-5x³-x²+7x-6*/

#include<stdio.h>

int main(void){
	float x,res;
	scanf("%f",&x);
	res = (3*(x*x*x*x*x))+(2*(x*x*x*x))-(5*(x*x*x))-(x*x)+(7*x)-6;
	printf("res: %f\n",res);
}