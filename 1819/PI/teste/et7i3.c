/*Escreva uma função int todos_letras(char str[]) que testa se uma cadeia contém
apenas carateres letras (maísculas ou minúsculas). O resultado deve ser 1 em caso 
afirmativo e 0 em caso negativo.
Sugestão: utilize a função isalpha da biblioteca-padrão*/
#include <stdio.h>
#include <ctype.h>
int todos_letras(char str[]){
	int a=1;
	for(int i=0;str[i]!='\0';i++){
		if(isalpha(str[i])==0){
			a=0;
			break;
		}
	}
	return a;
}	
int main(void){
 char str[]="olaesmcons123";
 printf("%d\n",todos_letras(str));
}