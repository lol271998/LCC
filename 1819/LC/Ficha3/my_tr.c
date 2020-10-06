#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>

#define BUFSIZE 1024

//Definir qual a string maior
//e passar para uma função que leia o input e transforme
void process(char* set1, char* set2,int size){
	int l;
	char *setm = malloc(size*sizeof(char));
	char *setM = malloc(size*sizeof(char));
	if(strlen(set1)>=strlen(set2)){ 
		l = strlen(set1);
		set1 = setM
		set2 = setm;
	}
	else{ 
		l = strlen(set2);
		set2 = setM;
		set1 = setm
	}
	for(int i = 0; i<strlen(setM);i++){
		
	}
}

void readAndPrint(){

}

int main(int argc, char* argv[]){
	char c;
	int size = BUFSIZE;

	char *set1 = malloc(size*sizeof(char));
	char *set2 = malloc(size*sizeof(char));

	//Sem opções
	if(argc == 3){
		set1 = argv[1];
		set2 = argv[2];
		process(set1,set2,size);
	}	
	else if(argc >3){
		while((c = getopt(argc,argv,"sd")) != -1){
			switch(c){

				//Opção s
				case 's':
				printf("s\n");
				break;

				//Opção d
				case 'd':
					printf("d\n");
				break;
			}
		}
	}
	else printf("ERRO\n");
}