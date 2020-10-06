/*Escreva uma função int contar_maiores(int vec[], int size, int val) cujos
argumento são uma variável indexada vec com tamanho size e um valor val e cujo resultado
deve ser a contagem do número de elementos de vec que são estritamente maiores do que
val.*/
#include<stdio.h>
int conta_maiores(int vec[], int size, int val){
	int c=0;
	for(int i=0;i<=size;i++){
		if(val<vec[i])
			c++;
	}
	return c;
}
int main(void){
	int vec[]={1,2,3,4,5,6,7,8,9};
	printf("%d\n",conta_maiores(vec,8,3));
}