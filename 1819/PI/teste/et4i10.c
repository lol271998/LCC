#include<stdio.h>
int raiz_babl(int a){
	int res,i;
	res=a/2;
	for(i=0;i<10;i++)
		res=0.5*(res+(a/res));
	return res;
}
int main(void){
	int numero;
	printf("Introduza o valor que quer fazer a raiz: \n");
	scanf("%d",&numero);
	numero=raiz_babl(numero);
	printf("A raiz é: %d\n",numero);
}