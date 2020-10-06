#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<getopt.h>
#include<string.h>

struct opt{

	int i;
	/*ignorar distinções de capitalização entre a palavra a procurar e o conteúdo dos ficheiros. Por
	exemplo, se a palavra a procurar for portugal e uma linha nos ficheiros contiver a palavra PoRtuGaL,
	essa linha deverá ser considerada como uma pesquisa bem sucedida. */

	int v;
	/*inverter o sentido de
	correspondência na pesquisa, procurando-se por linhas que não contenham a palavra word. PoRtuGaL
	exemplo, se a palavra for portugal deverão ser consideradas como pesquisa bem sucedida as linhas
	que não contenham a palavra portugal. */

	int l;
	/*deverão apenas ser impressos, os nomes dos ficheiros em que a procura teve sucesso*/

	int c;
	/*deverá apenas ser impresso, para cada ficheiro, o número de
	linhas em que a procura teve sucesso.*/

	int nRead; //Vê se foram lidas opções
};

void option(struct opt *list, int argc, char* argv[]){
	int opt;
	while((opt = getopt(argc,argv,"ivlc"))!=-1){
		switch(opt){
			case'i':
				list->i = 1;
				list->nRead++;
			break;

			case'v':
				list->v = 1;
				list->nRead++;
			break;

			case'l':
				list->l = 1;
				list->nRead++;
			break;

			case'c':
				list->c = 1;
				list->nRead++;
			break;

		}
	}
}