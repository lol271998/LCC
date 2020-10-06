/*Escreva um programa que lê um inteiro não-negativo e imprime a lista de fatores
primos (i.e. uma versão do comando factor do sistema Linux). Exemplo:
Numero inteiro: 24
24 : 2 2 2 3
Temos então que 24 = 2 × 2 × 2 × 3.
Sugestão: utilize um ciclo em que faz divisões sucessivas por inteiros crescentes começando
por 2, depois 3, etc. Note que se dividir tantas vezes quanto possível por um inteiro já
não será possível dividir pelos seus múltiplos, logo vamos apenas obter os fatores primos tal
como pretendido.*/
#include<stdio.h>
void fatores(int n){
	int div=2;
	printf("Numero inteiro: %d\n",n);
	printf("%d: ",n);
	while(n!=1){
		if (n%div==0){
			printf(" %d ",div);
			n=n/div;
		}
		else
			div++;
		if(n==1){
			break;
		}
	}
	printf("\n");
}
int main(void){
	int num;
	printf("Introduza o numero que quer fatorizar: \n");
	scanf("%d\n",&num);
	fatores(num);
}