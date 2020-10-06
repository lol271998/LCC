/* Escreva um programa que lê dois valores inteiros de numerador e denominador e escreve
a fração correspondente simplificada. Exemplo:
Numerador: 56
Denominador: 32
A fração 56/32 é equivalente a 7/4
Sugestão: Para simplificar uma fração p/q basta dividir o numerador e denominador pelo
máximo divisor comum de p, q. Utilize o método de Euclides apresentado na aula teórica 7
para calcular o m.d.c.*/
#include<stdio.h>
int mdc(int a, int b){
	int r;
	while(b!=0){
		r=a%b;
		a=b;
		b=r;
	}
	return a;
}
int main(void){
	int a,b,r;
	printf("Introduza o Numerador da fração: \n");
	scanf("%d",&a);
	printf("Introduza o Denominador da fração: \n");
	scanf("%d",&b);
	r=mdc(a,b);
	printf("A fração %d",a);
	printf("/%d",b);
	a=a/r;
	b=b/r;
	printf(" é equivalente a %d",a);
	printf("/%d\n",b);
}