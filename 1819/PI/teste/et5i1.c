/* Usando a função de teste de primalidade apresentada na aula 7, escreva um programa
que imprime uma lista de primos até um limite superior especificado pelo utilizador. Exemplo:
Limite superior? 100
2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97*/
#include<stdio.h>
#define FALSE 0
#define TRUE  1
int primo(int n) {
   int d;
   if(n <= 1) return FALSE;
   for (d = 2; d < n; d++) {
     if (n%d == 0)  // d divide n?
       return FALSE;
    }
   return TRUE;
}

int main(void){
	int l,n;
	printf("Introduza o limite superior: \n");
	scanf("%d",&l);
	for(n=2;n<=l;n++){
		if(primo(n)==TRUE)
			printf("%d ",n);
	}
}