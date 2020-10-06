#include<stdio.h>
#include<stdlib.h>
int main(int argc,char **argv){ //Conta caracteres
	
	int cont = 0;

	FILE *f1;
	FILE *f2;
	f1 = fopen(argv[1],"r");
	f2 = fopen(argv[2],"w+");
	//fscanf(f1,"%c",&c);
	while(!feof(f1)){//Enquanto houver caracteres para ler
		fgetc(f1);
		//fscanf(f1,"%c",&c);	
		//printf("c: %d\n", c);
		cont++;
	}
	fprintf(f2, "Numero de carateres: %d ",cont);
}