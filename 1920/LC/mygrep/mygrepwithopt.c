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

int isSubstring(char *s1, char *s2) { 
    int M = strlen(s1); 
    int N = strlen(s2); 
  
    /* A loop to slide pat[] one by one */
    for (int i = 0; i <= N - M; i++) { 
        int j; 
  
        /* For current index i, check for pattern match */
        for (j = 0; j < M; j++) 
            if (s2[i + j] != s1[j]) 
                break; 
  
        if (j == M) 
            return i; 
    } 
  
    return -1; 
}

void find(struct opt *list, char* fname, char* word,int argc){

	char* line;
	line = malloc(sizeof(char)*1000);

	//Standart input
	if(fname[0] == '-' || fname[0] == '\0' || (argc==3 && list->nRead>=1)){
		fname = " ";
		while(fgets(line,1000,stdin)!=NULL){
			if(list->l == 1 && print(list,word,line,fname) == 0){
				printf("(standard input)");
				return;
			}
			else{
				print(list,word,line);
			}
		}
	}

	else{
		FILE *f = fopen(fname,"r");

		if(f==NULL){
      		fprintf(stderr, "%s: No such file or directory\n",fname);
      	return;
		}
		while(fgets(line,1000,f)!=NULL){
			print(list,word,line,fname);
		}
		fclose(f);
	}
}

int main(int argc, char* argv[]){
	struct opt list = {0};
	
	char *word;
	option(&list,argc,argv);

	word = argv[1+list.nRead];
	printf("word: %s\n",word);

	//int numfiles = argc - 
	
	for(int i = 2+list.nRead; i<argc; i++){
		if((argv[i][0] == '-' && argv[i][1] == '\0') || (argv[i][0] != '-')){
			printf("find: %s\n",argv[i]);
			find(&list,argv[i],word,argc);
		}
	}

	if(argc<=2){
		find(&list,"-",word,argc);
	}
}

