#include <stdio.h>
int main(void){
	int valor,n20=0,n10=0,n5=0,m1=0;
	printf("Introduza o Valor: ");
	scanf("%d",&valor);
	while(valor>0){
		while(valor%20==0 && valor>0){
			valor=valor-20;
			n20++;		
		}
		while(valor%10==0 && valor%20!=0 && valor>0){
			valor=valor-10;
			n10++;
		}
		while(valor%5==0 && valor%20!=0 && valor%10!=0 && valor>0){
			valor=valor-5;
			n5++;
		}
		if(valor%1==0 && valor%20!=0 && valor%10!=0 && valor%5!=0 && valor>0){
			valor=valor-1;
			m1++;
		}
	}
	printf("Notas de EUR 20: %d \n",n20);
	printf("Notas de EUR 10: %d \n",n10);
	printf("Notas de EUR 5 : %d \n",n5);
	printf("Moedas de EUR 1: %d \n",m1);
}