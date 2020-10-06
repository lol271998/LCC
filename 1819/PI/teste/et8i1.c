/*Defina uma função void eliminar(char str[], char ch) que elimina a primeira
ocorrência de um carater ch de uma cadeia de carateres. Exemplo: se str = "ABBA", então
depois de executar eliminar(str, 'B') devemos ter str = "ABA".
Tenha o cuidado de colocar corretamente o terminador '\0'.*/
#include<string.h>
#include<stdio.h>
void eliminar(char str[], char ch){
	int l=strlen(str);
	for(int i=0;str[i]!='\0';i++){
		if(str[i]==ch)
			str[i]=str[i+1];
	}
	str[l-1]='\0';
}
int main(void){
	char str[]="BBA";
	eliminar(str,'B');
	printf("%s\n",str);
}
