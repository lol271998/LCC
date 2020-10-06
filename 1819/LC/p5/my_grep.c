#include <unistd.h>
#include <errno.h>
#include<string.h>
#include<stdio.h>
#include<stdlib.h>

void grepnormal(char* fname, char* texto){
	FILE *fp;
	fp = fopen(fname,"r");
	//Verificar a existência do ficheiro(FAZER)
	char *linha = (char*)malloc(100*sizeof(char));
	switch(fname[0]){
		case '-':
			switch(fname[1]){
				case'i':
					/*ignorar distinções de capitalização entre a string a procurar e o 
					conteúdo dos ficheiros.Por exemplo, se a string a procurar for 
					portugal e uma linha nos ficheiros contiverem a string
					PoRtuGaL, essa linha deverá ser considerada como uma pesquisa bem sucedida.*/
					break; 
				case'v':
					/*inverter o sentido de correspondência na pesquisa, procurando-se por 
					linhas que não contenham a string word. Por exemplo, se a string for 
					portugal deverão ser consideradas*/
					break;
				case'l':
					/*deverão apenas ser impressos, os nomes dos ficheiros 
					em que a procura teve sucesso.*/				
					break;
				case'c':
					/*deverá apenas ser impresso, para cada ficheiro, o 
					número de linhas em que a procura teve sucesso*/
					break;

			}
		default:
		//Imprimir o texto
		while(1){
			fgets(linha,100,fp); //Escreve no array linha o texto
			if(feof(fp))
				break;
			if(strstr(linha,texto)!=NULL)
				printf("%s",linha);
		}
		break;
	}
}
int main(int argc, char **argv){

	grepnormal(argv[2],argv[1]);
	return 0;
}