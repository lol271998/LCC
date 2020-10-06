/*Escrever um programa para calcular a soma de duas frações inteiras.
Deve ler o numerador e denominador de cada fração (valores inteiros) e 
imprime o o numerador e denominador da soma*/
#include<stdio.h>


int main(void){
	int num1,den1,num2,den2,rnum,rden;
	printf("Primeiro numerador?");
	scanf("%d",&num1);
	printf("Primeiro denominador?");
	scanf("%d",&den1);
	printf("Segundo numerador?");
	scanf("%d",&num2);
	printf("Segundo denominador?");
	scanf("%d",&den2);
	if(den1 == den2){
		rnum = num1+num2;
		printf("%d/%d + %d/%d = %d/%d\n",num1,den1,num2,den2,rnum,den1);
	}
	else{
		rden = den1*den2;
		num1 = num1*den2;
		num2 = num2*den1;
		rnum = num1+num2;
		printf("%d/%d + %d/%d = %d/%d\n",num1,den1,num2,den2,rnum,rden);

	}
}