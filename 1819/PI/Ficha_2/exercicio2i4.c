#include <stdio.h>
int main (void)
{
	float valoriva,valor;
	printf("Introduza o valor: \n");
	scanf("%f",&valor);
	valoriva=(valor*0.23)+valor;
	printf("Valor sem IVA: %f\n",valor);
	printf("Valor com IVA: %f\n",valoriva);
}