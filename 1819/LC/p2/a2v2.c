#include<stdio.h>
#include<stdlib.h>
int main(int argc, char **argv){
	int cont=0;
	char* aux;
	for(int i=1;i<argc;i++){
		cont = 0;
		aux = argv[i];
		while(aux[cont]) cont++;
	    printf("%d\n",cont);
	}
}