/* Escreva um programa que lê 3 valores inteiros correspondentes aos comprimentos dos
lados de um triangulo e que o classifique como:
-Equilatero: 3 lados iguais;
-Isósceles: 2 lados iguais;
-Escaleno: todos os lados diferentes*/


#include<stdio.h>

int main(void){
	int a,b,c;
	scanf("%d %d %d", &a, &b, &c);
	printf("Primeiro lado: %d\n", a);
	printf("Segundo lado: %d\n", b);
	printf("Terceiro lado: %d\n", c);
	if(a == b && b == c)printf("Triangulo Equilatero\n");
	else if(a!=b && b!=c && a!=c) printf("Triagulo Escaleno\n");
	else printf("Triangulo Isósceles\n");
}