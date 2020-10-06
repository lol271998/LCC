#define MAX_LISTA 1000

#include <string.h>
#include <stdio.h>

struct pessoa{
 char* nome;
 char* telefone;
}Pessoa;

typedef struct pessoa PESSOA;
PESSOA lista[MAX_LISTA] = {{"rui", "226664441"},{"ana", "214444444"}};
int n = 2; // Número de pessoas da lista

int pesquisa(char *pal){
	for(int i = 0; i<n; i++){
 		if(strcmp(pal,lista[i].nome)==0)
 			return i;
 	}
		return -1;
}
int pesqui(int i, char *pal){
	for(int j = i; j<n; j++){
 		if(strcmp(pal,lista[i].nome)==0)
 			return i;
	}
	return -1
}
int main(void){
	printf("%d \n",pesquisa("ana"));
	return 0;
}