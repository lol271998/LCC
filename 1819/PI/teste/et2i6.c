//Calcular a soma de duas frações a/b + c/d
//Arranjar denominador comum 
//Multiplicar o numerador pelo fator comum
//Somar as duas
#include <stdio.h>
int main(void){
	int den1,den2,num1,num2,denf,numf;
	printf("Introduzir a primeira fração:\n");
	scanf("%d",&num1);
	scanf("%d",&den1);
	printf("Introduzir a segunda fração: \n");
	scanf("%d",&num2);
	scanf("%d",&den2);
	denf=den2*den1;
	num1=num1*den2;
	num2=num2*den1;
	numf=num1+num2;
	printf("%d/%d \n",numf,denf);
}