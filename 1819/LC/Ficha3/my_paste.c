#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>

#define bufsize 1024

void noopt(char* filename[],int argc){
	char c;
	char c1;
	int size = bufsize;
	FILE *read;
	FILE *final;
	char* linha = malloc(size*sizeof(char));
	//int size = bufsize;
	//Abrir os dois primeiros ficheiros, ler cada linha e concatenar as palavaras
	while(f<argv){
		read = fopen(filename,"r");
		while((c = getchar(filename)!='\n')){
			linha[i] = c;
		}
	}
}



int main(int argc, char* argv[]){
	char c;
	//printf("pre loop\n");
	if(argv[1][0] == '-'){
		while((c = getopt(argc,argv,"sd")) != -1){
			//printf("Entrou no loop\n");
			switch(c){
			
				case 'd':
					printf("d\n");
				break;
			
				case 's':
					printf("s\n");
				break;
			}
		}
	}
	else{
		noopt(argv, argc);
	}
	return 0;
}