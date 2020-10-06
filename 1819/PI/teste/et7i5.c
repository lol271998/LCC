/*Escreva uma função int forte(char str[]) que verifica se uma cadeia de carateres
é uma palavra passe forte usando o seguinte critério:
1. deve ter pelo menos 6 carateres;
2. deve conter pelo menos uma letra maíscula, uma letra minúscula e um algarismo.
deve ser 1 se for forte, 0 se não for*/
#include <ctype.h>
#include <string.h>
int forte(char str[]){
	int a=0,a1=0,a2=0,a3=0;
	if(strlen(str)<6) a=0;
	else{
		for(int i=0;str[i]!='\0';i++){
			if(isupper(str[i])!=0) a1=1;
			if(islower(str[i])!=0) a2=1;
			if(isdigit(str[i])!=0) a3=1;
		}
		if(a1+a2+a3==3) a=1;
		else a=0;
	}
	return a;
}