#include <stdio.h>
int main (void){
	float reciva,vasiva;
	printf("Introduza o Valor:");
	scanf("%f",&vasiva);
	reciva=(vasiva*0.23)+vasiva;
	printf("Valor sem IVA: %f\n",vasiva);
	printf("Valor com IVA: %f\n",reciva);
}