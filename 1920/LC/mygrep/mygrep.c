#include<stdio.h>
#include<ctype.h>
#include<stdlib.h>
#include<getopt.h>
#include<string.h>

#define cond line[i] == ','||line[i] == '?'||line[i] == '\n'||line[i] == '.' || line[i] == ';' || line[i] == ':'


struct opt{

/*------------------OPÇÕES------------------*/
	
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

char* normalize(char *line){
	int j = 0;
	for (int i = 0; line[i] != '\0'; ++i) {
 	  	while (cond){
 	     	for (j = i; line[j] != '\0'; ++j) {
 	     	   line[j] = line[j + 1];
 	        }
        line[j] = '\0';
        }
    }
    return line;
}

char* decapitalize(char* str){
	for(int i = 0; i<strlen(str); i++){
		str[i] = tolower(str[i]);
	}
	return str;
}

int compare(struct opt *list, char* word, char* line, char*fname){
	int printed = 0;
	char *word1 = malloc(sizeof(char)*100);
	char *linecp = malloc(sizeof(char)*strlen(line)+1);
	strcpy(linecp,line);

	//Normaliza a linha tirando tudo o que não seja espaços ou caracteres
	linecp = normalize(linecp);
	if(list->i == 1){
		linecp = decapitalize(linecp);
		word = decapitalize(word);
	}

	word1 = strtok(linecp," ");

	while(word1 != NULL){
		if(strcmp(word1,word) == 0){
			return 1;
		}
		else if(strlen(word)<=strlen(word1) && printed == 0){
			if(isSubstring(word,word1)!=-1){
				return 1;
			}
		}
		word1 = strtok(NULL," ");
	}
	return 0;
}

void find(struct opt *list, char* fname, char* word){

	char* line;
	line = malloc(sizeof(char)*1000);
	int count = 0;

	//int i = 0;
	if(fname[0] == '-' || fname[0] == '\0'){
		while(fgets(line,1000,stdin)!=NULL){
			int comp = compare(list,word,line,fname);
			if(comp == 1 && list->v != 1 && list->l != 1 && list->c != 1) printf("%s",line);
			if(comp == 1 && list->l == 1){
				printf("(standard input)\n");
				return;
			}
			if(comp == 0 && list->v == 1 && list->l == 1){
				printf("(standard input)\n");
				return;
			}
			if(comp == 0 && list->v == 1 && list->c == 1) count++;
			if(comp == 0 && list->v == 1 && list->c != 1) printf("%s",line); 
			if(comp == 1 && list->c == 1 && list->v != 1) count++;
		}
		if(list->c == 1) printf("%d\n",count);
	}

	else{
		FILE *f = fopen(fname,"r");

		if(f==NULL){
      		fprintf(stderr, "%s: No such file or directory\n",fname);
      	return;
		}
		while(fgets(line,1000,f)!=NULL){
			int comp = compare(list,word,line,fname);
			if(comp == 1 && list->v != 1 && list->l != 1 && list->c != 1) printf("%s",line);
			if(comp == 1 && list->l == 1){
				printf("%s\n",fname);
				return;
			}
			if(comp == 0 && list->v == 1 && list->l == 1){
				printf("%s\n",fname);
				return;
			}
			if(comp == 0 && list->v == 1 && list->c == 1) count++;
			if(comp == 0 && list->v == 1 && list->c != 1) printf("%s",line); 
			if(comp == 1 && list->c == 1 && list->v != 1) count++;
		}
		if(list->c == 1) printf("%d\n",count);
		fclose(f);
	}
}

int main(int argc, char* argv[]){
	struct opt list = {0};
	
	char *word;

	option(&list,argc,argv);
	
	word = argv[1+list.nRead];

	for(int i = 2+list.nRead; i<argc; i++){
		if((argv[i][0] == '-' && argv[i][1] == '\0') || (argv[i][0] != '-')){
			//printf("argv[i] = %s\n",argv[i]);
			find(&list,argv[i],word);
		}
	}

	if(argc<=2+list.nRead){
		find(&list,"-",word);
	}
}