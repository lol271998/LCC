/*Escreva uma função int ordenada(int vec[], int size) que testa se uma variável
indexada de inteiros está por ordem ascendente em sentido lato, isto é, 
se vec[i] ≤ vec[i + 1] para todos os índices i de 0 a size − 2. 
O resultado deve ser 1 em caso afirmativo e 0 em caso negativo. 
A função não deve modificar os valores da variável indexada.
Exemplos: se vec = {1, 3, 3, 5, 6} então o resultado de ordenada(vec, 5) é 1; se
vec = {1, 3, 2, 5, 6} então o resultado de ordenada(vec, 5) é 0.*/
#include<stdio.h>
int ordenada(int vec[], int size){
	int a=1;
	for(int i=0;i<size;i++){
		if(vec[i]<vec[i-1] && i>0){
			a=0;
			break;
		}
		else
			a=1;
	}
	return a;
}

int main(void){
	int vec[]={-1,-1};
	printf("%d\n",ordenada(vec,2));
}