#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <getopt.h>

/* OUTPUT */
/* O número de: linhas		palavras	bytes contidos*/

struct x{

	/*--------------------Opções-----------------------*/

	int c;  // Imprime a contagem de bytes

	int l;  // Imprime a contagem de linhas

	int w;  // Imprime a contagem de palavras

	int L;  // Imprime o comprimento da linha mais longa

	/*----------------Variaveis Finais-----------------*/

	int nc; // Conta o tamanho da contagem de bytes

	int nl; // Conta o tamanho da contagem de linhas

	int nw; // Conta o tamanho da contagem de palavras

	int nL; // Conta o tamanho da linha

	/*--------------Variavel Temporária----------------*/

	int temp_nl; // Para comparar o tamanho da linha

	int nread;   // Ver se foi dado algum argumento para ler da shell



};

void option(struct x *list, int argc, char** argv){
	int opt;

	while((opt=getopt(argc,argv,"clwL"))!=-1){
		switch(opt){
			case 'c':
				list->c = 1;
			break;

			case 'l':
				list->b = 1;
			break;

			case 'w':
				list->w = 1;
			break;

			case'L':
				list->l = 1;
			break;
		}
	}
	//Se não foi dado nada, temos que apresentar as opções todas
	if(list->c!=1 && list->l!=1 && list->w!=1 && list->L!=1){
		list->c = 1;
		list->l = 1;
		list->w = 1;

	}
	list->nRead = argc - optnid;
}

readAndPrint(struct x *list, char**argv){

}

int main(int argc, char* str){

	//Zerar a lista
	struct x list = {0}

	//Guardar a opção
	option(&list,argc,argv);

	for(int i=1; i<argc; i++){
		//Se existe opção ou se é só o nome do ficheiro
		if((argv[i][0]=='-' && argv[i][1]=='\0')||(argv[i][0]!='-')) readAndPrint(&list, argv[i]);
	}
	//Caso não tenha sido lido nada
	if(list.nRead==0) readAndPrint(&list, " ");

	//Caso tenha sido lido algo
	else if(list.nRead>1) escreve()
 }