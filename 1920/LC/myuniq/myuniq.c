#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <string.h>
#define size 9999

struct opt{
	char prev[size], cur[size], saved[size];
	int i,c,d;
	int occ;
};

int opt(int argc, char* argv[], struct opt* list){
	int opt;
	while((opt = getopt(argc,argv,"icd"))!=-1){
		switch(opt){
			case 'i':
			list->i = 1;
			break;

			case 'c':
			list->c = 1;
			break;

			case 'd':
			list->d = 1;
			break;
		}
	}
	return optind;
}

// Abrir os ficheiros.
void openFiles(int start, int n, char** argv, FILE* arrayFiles[]){
	int i, j = 0;

	for(i = start; i<start+n; i++,j++){
		if(strcmp("-",argv[i]) == 0) arrayFiles[j] = stdin;
		else arrayFiles[j] = fopen(argv[i],"r");
		
		if(arrayFiles[j] == NULL){	
			printf("%s: No such file\n", argv[i]);
	  		exit(0);
	  	}
	}
}

int repeat(struct opt* list){
	//Caso seja não seja case sensitive (strcascmp para ignorar case sensitivity)
	if(list->i == 1 && strcasecmp(list->prev, list->cur) == 0) return 1;
	//Para comparar com case sensitive.
	else if(list->i != 1 && strcmp(list->prev, list->cur) == 0) return 1;

	else return 0;
}

int cond(struct opt* list){
	//Caso não exista ainda nenhuma frase igual
	if(list->saved[0] == '\0') return 0;
	//Caso já exista, e for só para imprimir as frases duplicadas
	if(list->d == 1 && list->occ > 1) return 1;
	//Caso não seja para imprimir só as frases duplicadas
	if(list->d != 1) return 1;

	return 0;
}

void uniq(FILE* file,struct opt* list){	

	while(fgets(list->cur,size,file)!=NULL){
		//Caso não seja a primeira frase a ser lida 
		if(repeat(list) != 1){
			//Verificar se não existe nenguma frase igual
			if(cond(list) == 1){
				if(list->c == 1) printf("%d ",list->occ);		
				printf("%s",list->saved);
			}
			list->occ = 1;
			strcpy(list->saved,list->cur);
		}
		else list->occ++;
		strcpy(list->prev,list->cur);
	}
	if(cond(list) == 1){
		if(list->c == 1) printf("%d ",list->occ);
		printf("%s",list->saved);
	}
}


int main(int argc, char* argv[]){

	/*---------Create and Save struct------*/
	
	struct opt list = {0};

	int ind = opt(argc,argv,&list);

	/*-----------Open Files---------------*/

	int n = argc-ind;

	if(n<=0) n = 1;

	FILE* arrayFiles[n];

	if(argc-ind == 0) arrayFiles[0] = stdin;

	else openFiles(ind, n, argv, arrayFiles);

	/*--------------Uniq-------------------*/

	for(int i = 0; i<n; i++) uniq(arrayFiles[i],&list);

	//printf("\n");

	return 0;
}