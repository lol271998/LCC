/*Escreva uma função void capitalizar(char str[]) que transforma todas as letras
duma cadeia em maísculas; outros carateres devem ficar inalterados. O argumento é uma
cadeia de carateres (não necessariamente letras) terminada por \0.
Sugestão: use a função toupper da biblioteca padrão para transformar cada carater em
maíscula.*/
#include<stdio.h>
#include<ctype.h>
void capitalizar(char str[]){
	for(int i=0;str[i]!='\0';i++){
		if(str[i]>='a' && str[i]<='z')
			str[i]=toupper(str[i]);
	}
}
int main(void){
	char str[]="abd123ABCasd";
	capitalizar(str);
	printf("%s\n",str);
}