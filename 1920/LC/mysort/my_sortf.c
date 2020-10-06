#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include <unistd.h>
#include <string.h>
#define size 999

struct var {
	//Opções
	int n,r;
};

int opt(int argc,char* argv[], struct var* x){
	int opt;
	while((opt = getopt(argc,argv, "nr"))!=-1){
		switch(opt){
			case 'r':
			x->r = 1;
			break;

			case 'n':
			x->n = 1;
			break;
		}
	}
	//Quantas opções foram lidas
	return optind;
}

void openFiles(int start, int end, char** fname, FILE* arrayFiles[]){

	int j = 0;
	for(int i = start; i<=end; i++,j++){
		if(strcmp(fname[i],"-") == 0) arrayFiles[j] = stdin;
		else{
			arrayFiles[j] = fopen(fname[i],"r");
			if(arrayFiles[j] == NULL){
				printf("%s: File not found\n", fname[i]);
				exit(EXIT_FAILURE);
			}
			//else printf("fname[%d]: %s\n",i,fname[i]);
		}
	}
}

/* qsort in c:

   Esta função recebe 4 parametros:
   1º -> arr que queremos ordenar
   2º -> o numero de elementos a ordenar
   3º -> o tamanho de cada elemento, n*sizeof(char), sizeof(int) etc
   4º -> uma função compare. É preciso ter atenção que esta função
   compare tem que ter argumentos polimorficos. Porque? não sei*/ 

int compare(const void* str1, const void* str2){
	return strcmp( (char*)str1, (char*)str2);
}

void ordStr(FILE* arrayFiles[],int end, struct var x){
	char line[size][size];
	int ind = 0;

	for(int i = 0; i<end; i++){
		while(fgets(line[ind],size-1,arrayFiles[i])!=NULL) ind++;
	}
	//qsort(array,size,sizeof de cada elemento, função que compara)
	qsort(line,ind,size*sizeof(char),compare);

	if(x.r == 1){
		for(int i = ind-1; i>=0; i--){
			for(int j = 0; line[i][j]!= '\n' && line[i][j]!='\0'; j++) putchar(line[i][j]);
			putchar('\n');
		}
	}
	else{
		for(int i = 0; i<ind; i++){
			for(int j = 0; line[i][j]!= '\n' && line[i][j]!='\0'; j++) putchar(line[i][j]);
			putchar('\n');
		}
	}
}

int compare2(const void* num1, const void* num2){
	return *(int*)num1 - *(int*)num2;
}

void ordNum(FILE* arrayFiles[],int end, struct var x){
	float num[size];
	int ind = 0;
	char line[size];

	for(int i = 0; i<end; i++){
		while((fgets(line, size-1, arrayFiles[i]))!=NULL){
			num[ind] = atof(line);
			ind++; 
		}
	}

	qsort(num,ind,sizeof(float),compare2);

	if(x.r == 1){
		for(int i = ind-1; i >= 0; i--){
			printf("%g\n",num[i]);
		}
	}
	else{
		for(int i = 0; i<ind; i++){
			printf("%g\n",num[i]);
		}
	}
}


int main(int argc, char* argv[]){

	struct var x = {0};

	int start = opt(argc,argv,&x);

	/* Opening several files*/
	//Tam: Numero de ficheiros que temos de abrir
	int tam = argc-start;
	if(tam == 0) tam = 1;
	// Caso não existam argumentos, o array à frente criado, tem que ter pelo menos tamanho 1

	//Array com os ficheiros que vão ser abertos
	FILE* arrayFiles[tam];
	//Caso não haja nada como argumentos
	if(argc-start == 0) arrayFiles[0] = stdin;
	else openFiles(start,argc-1,argv,arrayFiles);

	//Ordenar Strings
	if(x.n != 1) ordStr(arrayFiles, tam, x);

	//Ordenar Numeros
	else ordNum(arrayFiles, tam, x);

	return 0;
}