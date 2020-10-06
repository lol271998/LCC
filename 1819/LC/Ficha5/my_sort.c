#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <getopt.h>
#define bufsize 1024

void printFile(char f[],char str[], int n){
	FILE *write = fopen(str,"w");
	for(int i = 0; i<n; i++){
		fprintf(write,f);
	}
	fclose(write);
}

void readAndSort(char opt, char str[]){
	int  fn[10000];
	char fw[10000];
	int n;
	char ch1;

	FILE* read = fopen(str, "r" );
	for(int i = 0;(ch1=getc(read)) != EOF;i++){
		fw[i] = ch1;
		n=i; 	
  	}
  	//Sem opção
  	if(opt =='s'){

  	}
  	if(opt == 'r'){
  		for(int i = 0; i<n;i++){
  			for(int j = 0; j<n; j++){
  				if(fw[i]<fw[j]){
  					char temp = fw[i];
  					fw[i] = fw[j];
  					fw[j] = temp;
  				}
  			}
  		}
  		fclose(read);
  		printFile(fw,str,n);

  	}
  	if(opt == 'n'){
  		printf("Opção n");
  	}
  	if(opt == 'k'){
  		printf("Opção k");
  	}
  	if(opt == 't'){
  		printf("Opção t");
  	}
}
int main(int argc, char** argv){
	int option;
  	for(int i = 1; i<argc; i++){
  		if(argv[i][0] != '-'){
  			readAndSort('s',argv[i]);
  		}
  		else{
  			while ((option = getopt(argc, argv, "rnkt")) != -1){
    			switch (option){
      				//Ordena por ordem decrescente
      				case 'r':
        				readAndSort('r',argv[i]);
      				break;
      				//Ordena as linhas do ficheiro que devem ser interpretadas como numeros
      				case 'n':
        				readAndSort('n',argv[i]);
      				break;
      				//Ordena a partir de um certo ponto
      				case 'k':
        				readAndSort('k',argv[i]);
      				break;
      				//Ordena separando de algo
      				case 't':
      					readAndSort('t',argv[i]);
       				break;
    			}
  			}
  		}
  	}
	return 0;
}