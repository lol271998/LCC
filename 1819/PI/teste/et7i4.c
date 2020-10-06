/*Escreva uma função int algum_digito(char str[]) que testa se uma cadeia é contém
algum carater de dígito decimal ('0' e '9'). O resultado deve ser 1 em caso afirmativo
e 0 em caso negativo.
Sugestão: utilize a função isdigit da biblioteca-padrão.*/
#include <stdio.h>
#include <ctype.h>
int todos_letras(char str[]){
	int a=0;
	for(int i=0;str[i]!='\0';i++){
		if(isdigit(str[i])!=0){
			a=1;
			break;
		}
	}
	return a;
}	
int main(void){
 char str[]="ASDASDS1";
 printf("%d\n",todos_letras(str));
}