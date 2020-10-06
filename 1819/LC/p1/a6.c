#include<stdio.h>
#include<stdlib.h>
int main(int argc, char *argv[]){
	int linha, coluna;
	FILE *f;
	int *matrix;
	
	f = fopen(argv[1],"r");
	
	fscanf(f,"%d %d",&linha, &coluna);

	matrix = malloc(linha*coluna*sizeof(int));

	for(int i = 0; i < linha; i++){
		for(int j = 0; j < coluna; j++){
			fscanf(f,"%d", matrix + i*coluna + j);
		}
		printf("\n");
	}
	fclose(f);
	return 0;
}