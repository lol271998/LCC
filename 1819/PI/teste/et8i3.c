/* Escreva uma função int desordem(int vec[], int size) que conta quantos pares
de valores numa variável indexada estão fora de ordem, isto é, vec[i] > vec[i + 1]. Exemplo:
se vec = {3, 1, 2, 2, 4, 0} e size=6 então o resultado deve ser 2 (porque 3 6≤ 1 e
4 6≤ 0).
Note ainda que se a sequência estiver por ordem ascendente, então o resultado é 0 e se
estiver por ordem descente, então o resultado é size − 1.*/
#include<stdio.h>
int desordem(int vec[], int size){
	int c=-1;
	for(int i=0;i<size;i++){
		if(vec[i]<vec[i-1])
			c++;
	}
	return c;
}
int main(void){
	int vec[]={3,1,2,2,4,0};
	printf("%d\n",desordem(vec,6));
}