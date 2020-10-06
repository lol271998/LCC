/*Numa turma com 25 alunos, qual a probabilidade de que o aniversário de pelo menos
dois deles seja no mesmo dia? E se forem 50 alunos? O "paradoxo dos aniversários" é a
constantação de que esta probabilidade é maior do que parece ao senso comum.1 Vamos
estimar experimentalmente a probabilidade de aniversários repetidos com N alunos escrevendo
um programa que repetidamente gere dias aleatoriamente (N valores de 1 a 365) e
verifique a ocorrência de repetições.
Utilize rand() para gerar aleatoriamente um vector com N dias e a função do exercício 6.8
para testar repetições. Se fizer um grande número de experiências, a frequência relativa de
ocorrência de repetidos dá um valor aproximado da probabilidade. O número de alunos N
e de experiências deve ser facilmente modificável (por exemplo, usado #define).*/
#define N 90
#include <stdio.h>
#include <stdlib.h>
int repetidos(int vec[], int size){
    int a=0,temp;
	for(int i=0;i<=size;i++){
		temp=vec[i];
		for(int j=i+1;j<=size;j++){
			if(vec[j]==temp){
				a=1;
				break;
			}
		}
	}
	return a;
}
int random_1(void){
	int a;
      a = 1 + (int)((double)rand() /((double)RAND_MAX+1)*365);
      return a;
}
int main(void){
	int vec[N],c=0;
	for(int i=0;i<N;i++){
		vec[i]=random_1();
		if(repetidos(vec,N)==1) c++;
	}
	printf("%d\n",c);
}

