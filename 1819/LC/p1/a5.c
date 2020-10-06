#include<stdio.h>
#include<stdlib.h>
int main(int argc, char *argv[]){
    
    int linhas = atoi(argv[1]);
    int colunas = atoi(argv[2]);
    int val;

    if(argc > 1){
    	FILE *f;
    	f = fopen(argv[3],"w+"); //Cria o ficheiro com o nome que está em argv[3]

    	fprintf(f,"%d %d", linhas, colunas); //Imprime o valor das linhas e das colunas no ficheiro

    	for(int i = 0; i < linhas*colunas;i++){
    		scanf("%d",&val);
    		fprintf(f," %d",val); //Imprime os valores criados no ficheiro
    	}
    }
    else printf("São necessários mais argumentos");
    return 0;
}